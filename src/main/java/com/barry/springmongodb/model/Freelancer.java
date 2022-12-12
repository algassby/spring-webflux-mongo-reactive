package com.barry.springmongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@Document(collection = "Freelancer")
@ToString
public class Freelancer {

    @Id
    private String id;
    private String name;
    private int age;
    private List<String> skills;

}