package com.ascii274.retomwc2022.repository;

import com.ascii274.retomwc2022.exception.DeveloperException;
import com.ascii274.retomwc2022.model.Categoria;
import com.ascii274.retomwc2022.model.Developer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class DeveloperRepository implements IDeveloperRepository {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DeveloperRepository.class);

    @Override
    public Developer createDeveloper() throws DeveloperException {
        Developer developer;
        Categoria categoria;

        System.out.println("************ Alta developer ******************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca nombre:");
        String name = scanner.nextLine();
        System.out.println("Introduzca email:");
        String email = scanner.nextLine();
        System.out.println("Escoja categoria[\n 0:Front\n 1:Back\n 2:Mobile\n 3:Data]");
        String categoriaString = scanner.nextLine();

        System.out.println("Introduzca telefono:");
        String phone = scanner.nextLine();
        System.out.println("Introduzca fecha: (Ejemplo: Abr 1,2021)");
        String date = scanner.nextLine();

        try {
            categoria = getCategory(categoriaString);
        } catch (Exception e) {
            throw new DeveloperException("Error al obtener categoria");
        }
        developer = new Developer(name,email,categoria,phone,date);
        log.info(developer.toString());
        return developer;

    }

    /**
     * - POJO Developer insert
     * @param developers
     * @param developer
     * @throws Exception
     */
    @Override
    public void insertDeveloper(MongoCollection<Document> developers, Developer developer) throws DeveloperException {
        ObjectMapper mapper = new ObjectMapper();
        final Document wrapper = new Document();
        String json = null;
        try {
            json = mapper.writeValueAsString(developer);
        } catch (JsonProcessingException e) {
            throw new DeveloperException("Error al pasar developer a json " + developer);
        }
        wrapper.append("developer",json);
        developers.insertOne(Document.parse(json));
    }


    @Override
    public Categoria getCategory(String categoriaString) {
        Categoria categoria = null;

        switch (categoriaString.trim()){
            case "0": //Front:
                categoria = Categoria.FRONT;
                break;
            case "1": //Back
                categoria = Categoria.BACK;
                break;
            case "2": //Mobile
                categoria = Categoria.MOBILE;
                break;
            case "3": //Data
                categoria = Categoria.DATA;
                break;
            default: // empty
                break;
        }
        return categoria;
    }

}
