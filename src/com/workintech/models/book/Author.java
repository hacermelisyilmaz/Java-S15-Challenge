package com.workintech.models.book;

import java.util.Map;

public class Author {
    private String firstName;
    private String lastName;
    private int birthYear;
    private String description;
    private Map<Long, Book> books;

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

    public void addBook(Book newBook) {
        if (books.containsKey(newBook.getISBN())) System.out.println("This book is already in the system.");
        else if (!(newBook.getAuthor().getLastName().equals(lastName) && newBook.getAuthor().getFirstName().equals(firstName)))
            System.out.println("This book does not belong to the selected author.");
        else books.put(newBook.getISBN(), newBook);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + birthYear + ")";
    }
}
