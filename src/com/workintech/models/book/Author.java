package com.workintech.models.book;

import java.util.HashMap;
import java.util.Map;

public class Author {
    private String firstName;
    private String lastName;
    private int birthYear;
    private String description;
    private Map<Long, Book> books = new HashMap<>();

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Long, Book> getBooks() {
        return books;
    }
}
