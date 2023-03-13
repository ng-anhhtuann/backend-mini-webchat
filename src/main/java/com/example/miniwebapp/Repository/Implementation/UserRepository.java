package com.example.miniwebapp.Repository.Implementation;

import com.example.miniwebapp.Models.Form.LogIn;
import com.example.miniwebapp.Models.Form.SignUp;
import com.example.miniwebapp.Models.Response;
import com.example.miniwebapp.Models.User;
import com.example.miniwebapp.Config.Database;
import com.example.miniwebapp.Repository.Manager.IUser;
import com.example.miniwebapp.Utilities.MailValidation;
import com.example.miniwebapp.Utilities.StringValidation;
import com.google.gson.Gson;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserRepository implements IUser {
    public static final Database database = Database.getDatabase();

    public static final MongoDatabase mongoDb = database.getMongoDatabase();

    private static final MongoCollection<Document> userCollection = mongoDb.getCollection("users");
    /*
    * Singleton repository
    * */
    public static UserRepository userRepository = new UserRepository();
    public static UserRepository getUserRepository() {
        if ( userRepository == null ){
            return new UserRepository();
        }
        return userRepository;
    }

    /**
     * @author ng-anhhtuann
     * @param signUp
     * @return status Object
     */
    @Override
    public Object signUpUser(SignUp signUp) {
        /*
        * Invalidation check
        * @params mail
        * @params null object
        * @params missing properties
        * */
        if (signUp == null) {
            return new Response(false,"Something's wrong");
        }
        if (!MailValidation.check(signUp.getMail())) {
            return new Response(false, "Invalid mail form");
        }
        if (StringValidation.check(signUp.getUserName())
            || StringValidation.check(signUp.getNameDisplay())
            || StringValidation.check(signUp.getPassword())
            || StringValidation.check(signUp.getMail())) {
            return new Response(false,"Fill all the cells");
        }

        Document search = new Document("mail", signUp.getMail())
            .append("userName", signUp.getUserName());

        FindIterable<Document> cursor = userCollection.find(search);

        try (final MongoCursor<Document> cursorIterator = cursor.cursor()){
            if (cursorIterator.hasNext()){
                return new Response(false,"Username or Mail existed");
            } else {
                String uuid = "" + UUID.randomUUID();
                String time = "" + new Date().getTime();
                User user = new User(uuid,
                        signUp.getUserName(),
                        signUp.getNameDisplay(),
                        signUp.getMail(),
                        signUp.getPassword(),
                        time,
                        time,
                        "",
                        true);
                Document userDocument = Document.parse(new Gson().toJson(user));
                userCollection.insertOne(userDocument);
            }
        }
        catch (Exception e){
            return new Response(false, e.getMessage());
        }
        return new Response(true, "SignUp successfully!");
    }

    /**
     * @author ng-anhhtuann
     * @param logIn
     * @return status Object
     */
    @Override
    public Object signInUser(LogIn logIn) {
        /*
         * Invalidation check
         * @params mail
         * @params null object
         * @params missing properties
         * */
        if (logIn == null) {
            return new Response(false,"Something's wrong");
        }
        if (StringValidation.check(logIn.getUserName())
            || StringValidation.check(logIn.getPassword())) {
            return new Response(false,"Fill all the cells");
        }

        /**
         * Search appearance of userName with password existed in db
         */
        Document searchUserName = new Document("userName",logIn.getUserName());
        Document searchUserNameWithPassword = new Document("userName",logIn.getUserName())
            .append("password",logIn.getPassword());

        FindIterable<Document> cursorUserName = userCollection.find(searchUserName);
        FindIterable<Document> cursorUserNameWithPassword = userCollection.find(searchUserNameWithPassword);

        try(final MongoCursor<Document> cursorIteratorUserName = cursorUserName.cursor();
            final MongoCursor<Document> cursorIteratorUserNameWithPassWord = cursorUserNameWithPassword.cursor()){
            if (cursorIteratorUserName.hasNext()){
                if (cursorIteratorUserNameWithPassWord.hasNext()){
                    return new Response(true,"Login successfully!");
                } else {
                    return new Response(false, "Wrong password!");
                }
            } else {
                return new Response(false, "User not found!");
            }
        } catch (Exception e){
            return new Response(false, e.getMessage());
        }
    }

    /**
     * @author ng-anhhtuann
     * @return list of all users
     */
    @Override
    public Object getAllUser() {
        List<User> listUser = new ArrayList<>();
        List<Document> listOfDoc = new ArrayList<>();
        try (MongoCursor<Document> cursor = userCollection.find().iterator()) {
            while (cursor.hasNext()) {
                listOfDoc.add(cursor.next());
            }
        }
        for (Document document : listOfDoc) {
            User user = new User(
                document.getString("id"),
                document.getString("userName"),
                document.getString("nameDisplay"),
                document.getString("mail"),
                document.getString("password"),
                document.getString("createAt"),
                document.getString("updateAt"),
                document.getString("avatar"),
                document.getBoolean("online")
            );
            listUser.add(user);
        }
        return listUser;
    }
}
