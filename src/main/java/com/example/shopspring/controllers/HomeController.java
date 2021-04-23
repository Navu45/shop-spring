package com.example.shopspring.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@RestController
public class HomeController {

    @Value("${home}")
    private String homePagePath;

    @GetMapping("/home")
    public String home() throws FileNotFoundException {
        StringBuilder homePageHTML = new StringBuilder();
        Scanner scanner = new Scanner(new File(homePagePath));
        while (scanner.hasNextLine()) {
            homePageHTML.append(scanner.nextLine()).append("\n");
        }
        return homePageHTML.toString();
    }
}