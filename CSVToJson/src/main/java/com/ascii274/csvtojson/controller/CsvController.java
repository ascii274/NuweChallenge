package com.ascii274.csvtojson.controller;

import com.ascii274.csvtojson.model.Product;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/nuwechallenges/api/v1/csvtojson")
public class CsvController {
    private static String fileName = "CSVToJson/build/resources/main/csv/restaurant.csv";

    @GetMapping(value="/test")
    public String test(){
        return "Hello CSV to Json";
    }

    /**
     * - Show all products.
     * @return
     * @throws IOException
     * @throws CsvException
     */
    @GetMapping(value="/get-all-products")
    public List<Product> getAllProducts() throws IOException{
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        List<Product> products = new CsvToBeanBuilder(csvReader)
                .withType(Product.class)
                .build()
                .parse();
        csvReader.close();
        return products;

    }


}
