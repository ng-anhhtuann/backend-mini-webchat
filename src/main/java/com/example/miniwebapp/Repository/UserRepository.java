package com.example.miniwebapp.Repository;

import com.example.miniwebapp.Models.Form.LogIn;
import com.example.miniwebapp.Models.Form.SignUp;
import com.example.miniwebapp.Models.Response;
import com.example.miniwebapp.Models.User;
import com.example.miniwebapp.Config.Database;
import com.example.miniwebapp.Utilities.MailValidation;
import com.google.gson.Gson;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Date;
import java.util.UUID;

public class UserRepository implements UserInterface{
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
        if (signUp.getUserName().equals("") || signUp.getNameDisplay().equals("") || signUp.getPassword().equals("") || signUp.getMail().equals("")) {
            return new Response(false,"Fill all the cells");
        }

        Document searchMail = new Document();
        searchMail.put("mail", signUp.getMail());
        Document searchUserName = new Document();
        searchUserName.put("userName", signUp.getUserName());

        FindIterable<Document> cursorMail = userCollection.find(searchMail);
        FindIterable<Document> cursorUserName = userCollection.find(searchUserName);

        try (final MongoCursor<Document> cursorIteratorMail = cursorMail.cursor();
             final MongoCursor<Document> cursorIteratorUserName = cursorUserName.cursor()){
            if (cursorIteratorMail.hasNext() || cursorIteratorUserName.hasNext()){
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
        return new Response(true, "Inserted new user");
    }

    @Override
    public Object signInUser(LogIn logIn) {
        return null;
    }

}
