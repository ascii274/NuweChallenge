package com.ascii274.mongodb.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

/**
 *  On develop
 */

@Component
public class MongoDBConnection {
/*

    private String messageConnection;
    MongoClient mongoClient;
    MongoDatabase database;

    public MongoDBConnection() {
        mongoClient = new com.mongodb.MongoClient("localhost", 27017);
        database = mongoClient.getDatabase("babcn-users");
        try {
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            Document commandResult = database.runCommand(command);
            messageConnection = "Connected successfully to server.";
        } catch (MongoException me) {
            System.err.println("An error occurred while attempting to run a command: " + me);
        }
    }
*/


}
