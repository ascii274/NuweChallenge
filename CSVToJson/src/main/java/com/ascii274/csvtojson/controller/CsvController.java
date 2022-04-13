package com.ascii274.csvtojson.controller;

import com.ascii274.csvtojson.model.CSVColumn;
import com.ascii274.csvtojson.model.Product;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/nuwechallenges/api/v1/csvtojson")
public class CsvController {
    final static Logger logger = LoggerFactory.getLogger(CsvController.class);
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

    /**
     * Show a column data
     *
     * @param column
     */
    @GetMapping(value = "/get-one-column/{column}")
    public List<String> getColumnProduct6(@PathVariable Integer column){
        List<String> lista = new ArrayList<>();
        try(
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setDelimiter(',')
                        .setHeader("header")
                        .build()
                        .parse(br);
        ) {
            for(CSVRecord record : parser) {
                //columns values -> 0: code 1:product 2:price
                lista.add(record.get(column) );
            }
        } catch (Exception e) {
            logger.error(e.getMessage() );
            return getColumnDefault();
        }
        return lista;
    }

    /**
     * Show columns from 1 to 3.
     *
     * @param columns
     * @return
     */
    @GetMapping(value="/get-more-column")
    public List<String> getSomeColumns(@RequestBody CSVColumn columns){
        List<String> lista = new ArrayList<>();
        try(
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                CSVParser parser = CSVFormat.DEFAULT.builder()
//                        .setDelimiter(",")
//                        .setHeader() //Sets the header to the given values.
                        .build()
                        .parse(br);
        ) {
                for(CSVRecord record : parser) {
                    if(columns.getColumns().size()==1)
                    {
                        lista.add(record.get( columns.getColumns().get(0) ));
                    }
                    if(columns.getColumns().size()==2){
                        lista.add(record.get( columns.getColumns().get(0) ) + " " + record.get(columns.getColumns().get(1)) );
                    }
                    if(columns.getColumns().size()==3){
                        lista.add(record.get( columns.getColumns().get(0) ) + " " + record.get(columns.getColumns().get(1)) + " " + record.get(columns.getColumns().get(2)) );
                    }
                }
        } catch (Exception e) {
            logger.error(e.getMessage() );
            return getColumnDefault();
        }
        return lista;
    }

    /**
     * Default List<String> to return when column produce outbound
     *
     * @return
     */
    private List<String> getColumnDefault(){
        List<String> listDefault = new ArrayList<>();
        listDefault.add("Index out of bounds");
        return listDefault;
    }


}
