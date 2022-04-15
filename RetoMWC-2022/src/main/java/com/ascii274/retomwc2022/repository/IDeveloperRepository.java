package com.ascii274.retomwc2022.repository;


import com.ascii274.retomwc2022.exception.DeveloperException;
import com.ascii274.retomwc2022.model.Categoria;
import com.ascii274.retomwc2022.model.Developer;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public interface IDeveloperRepository {
    public Developer createDeveloper() throws DeveloperException;
    public void insertDeveloper(MongoCollection<Document> developers, Developer developer) throws DeveloperException;
    public Categoria getCategory(String categoriaString);
}
