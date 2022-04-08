package com.ascii274.csvtojson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/nuwechallenges/api/v1/csvtojson")
public class CsvController {

    @GetMapping(value="/test")
    public String test(){
        return "Hello CSV to Json";
    }


}
