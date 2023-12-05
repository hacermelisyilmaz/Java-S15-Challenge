package com.workintech.models.person;

import com.workintech.enums.PersonType;
import com.workintech.models.Library;
import com.workintech.models.book.Book;

import java.util.Locale;
import java.util.Scanner;

public class Librarian extends Person {
    private String password;
    public Librarian(String name, PersonType type, String password) {
        super(name, type);
        this.password = password;
    }

    public boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        return this.password.equals(password);
    }

    public void addBook(String password, Book book) {
        if (authenticate()) Library.getBooks().put(book.getISBN(), book);
        else System.out.println("Incorrect password.");
    }


    public void createBill() {

    }

    public void returnDeposit() {

    }

    public void setPassword(String password) {
        this.password = password;
    }
}
