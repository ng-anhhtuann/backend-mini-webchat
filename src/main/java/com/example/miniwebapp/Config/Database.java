package com.example.miniwebapp.Config;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

public class Database {
    private static final String DATABASE_NAME = "webchat";

    @Value("${spring.data.mongodb.uri}")
    private final String uri = "mongodb+srv://root:nguyenanhtuandangcongnhat@webchat.gqvgjqa.mongodb.net/webchat?retryWrites=true&w=majority";

    private static Database database;
    private final MongoClient mongoClient;
    private final MongoDatabase mongoDatabase;

    private Database() {
        mongoClient = MongoClients.create(uri);
        mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);
    }

    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }
}
