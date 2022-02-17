package com.ascii274.retomwc2022.controller;


import com.ascii274.retomwc2022.dto.Categoria;
import com.ascii274.retomwc2022.dto.Developer;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public interface IDeveloperController {
    public Developer createDeveloper() throws Exception;
    public void insertDeveloper(MongoCollection<Document> developers, Developer developer) throws Exception;
    public Categoria getCategory(String categoriaString) throws Exception;
}
