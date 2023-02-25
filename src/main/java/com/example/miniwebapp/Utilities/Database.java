package com.example.miniwebapp.Utilities;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;

public class Database {
    private static final String DATABASE_NAME = "webchat";

    @Value("${spring.data.mongodb.uri}")
    private String uri;

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
