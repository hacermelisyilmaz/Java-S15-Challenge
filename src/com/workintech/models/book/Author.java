package com.workintech.models.book;

import java.util.HashMap;
import java.util.Map;

public class Author {
    private String firstName;
    private String lastName;
    private int birthYear;
    private String description;
    private Map books = new HashMap();

    public Author(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public Author(String firstName, String lastName, int birthYear, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.description = description;
    }


}
