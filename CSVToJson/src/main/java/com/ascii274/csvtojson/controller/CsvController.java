package com.ascii274.csvtojson.controller;

import com.opencsv.CSVReader;
import org.apache.commons.csv.CSVFormat;
import com.ascii274.csvtojson.model.Product;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value="/nuwechallenges/api/v1/csvtojson")
public class CsvController {
    private static String fileName = "CSVToJson/build/resources/main/csv/restaurant.csv";

    @GetMapping(value="/test")
    public String test(){
        return "Hello CSV to Json";
    }

    /**
     * Show all columns froms csv data
     *
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

    /**
     * Show all columns froms csv data
     *
     * @throws IOException
     */
    @GetMapping(value="/get-column-1")
    public void getColumnProduct() throws IOException{
        File file = new File("CSVToJson/build/resources/main/csv/restaurant.csv");
        List<String> products = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        for(String p:products ){
            String[] array = p.split("-");
            System.out.println(array[0]);
        }
    }

    /**
     * Show all columns froms csv data
     *
     * @throws IOException
     */

    @GetMapping(value="/get-column-2")
    public void getColumnProduct2() throws IOException {
        File file = new File("CSVToJson/build/resources/main/csv/restaurant.csv");
        List<String> products = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        for(int i=0;i<products.size();i++){
            System.out.println(products.get(i));
        }
    }

    /**
     * Show all columns froms csv data
     *
     * @throws FileNotFoundException
     */
    @GetMapping(value = "/get-column-3")
    public void getColumnProduct3() throws FileNotFoundException {
        File file = new File("CSVToJson/build/resources/main/csv/restaurant.csv");
        BufferedReader fileReader = null;
        final String DELIMETER = ",";
        String line = "";
        fileReader = new BufferedReader(new FileReader(file));
        String[] products = line.split(DELIMETER);

        for(String s:products){
            System.out.println(s);
        }
    }

    /**
     * Show two columns( code,product ) from csv data ( DEPRECATED)
     *
     * @throws IOException
     */
    @GetMapping(value = "/get-column-4")
    public void getColumnProdcut4() {
        try(
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(br);
        ) {
            for(CSVRecord record : parser) {
                System.out.println(record.get("code") + " " + record.get("product"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Show two columns( code,product ) from csv data
     */
    @GetMapping(value = "/get-column-5")
    public void getColumnProduct5(){
        try(
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                CSVParser parser = CSVFormat.Builder
                        .create()
                        .setDelimiter(',')
                        .setHeader()
                        .build()
                        .parse(br);
        ) {
            for(CSVRecord record : parser) {
                //columns values -> 0: code 1:product 2:price
                System.out.println(Integer.parseInt(record.get("code")) + " " + record.get("product"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Show two columns from csv data
     */
    @GetMapping(value = "/get-column-6")
    public void getColumnProduct6(){
        try(
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setDelimiter(',')
                        .setHeader()
                        .build()
                        .parse(br);

        ) {
            for(CSVRecord record : parser) {
                //columns values -> 0: code 1:product 2:price
                System.out.println(Integer.parseInt(record.get(0)) + " " + record.get(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
