package com.ascii274.retomwc2022.helper;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConnectDB {

    private MongoClient client = MongoClients.create();
    MongoDatabase database = client.getDatabase("nuwe-db");
    private MongoCollection<Document> developers = database.getCollection("developers");

    public MongoClient getClient() {
        return client;
    }

    public void setClient(MongoClient client) {
        this.client = client;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MongoDatabase database) {
        this.database = database;
    }

    public MongoCollection<Document> getDevelopers() {
        return developers;
    }

    public void setDevelopers(MongoCollection<Document> developers) {
        this.developers = developers;
    }
}
