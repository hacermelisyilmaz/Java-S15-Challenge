package com.workintech.models.book;

import com.workintech.enums.BookStatus;
import com.workintech.models.person.Member;

public class Book {
    private long ISBN;
    private Author author;
    private String name;
    private int year;
    private int edition;
    private String publisher;
    private double price;
    private BookStatus status;
    private String dateOfPurchase;
    private Member borrower;

    public Book(long ISBN, Author author, String name, int year, String dateOfPurchase) {
        this.ISBN = ISBN;
        this.author = author;
        this.name = name;
        this.year = year;
        this.dateOfPurchase = dateOfPurchase;
    }

    public Book(long ISBN, Author author, String name, int year, int edition, String publisher, double price, String dateOfPurchase) {
        this.ISBN = ISBN;
        this.author = author;
        this.name = name;
        this.year = year;
        this.edition = edition;
        this.publisher = publisher;
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
    }

    public long getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getEdition() {
        return edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuthor(String firstName, String lastName) {
        this.author.setFirstName(firstName);
        this.author.setLastName(lastName);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }

    public void updateStatus(BookStatus newStatus) {
        if (status == newStatus) System.out.println("The book is already " + newStatus);
        else status = newStatus;
    }

    public void changeBorrower(Member newBorrower) {
        if (borrower == newBorrower) System.out.println(newBorrower + " already has this book.");
        else borrower = newBorrower;
    }



    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", borrower=" + borrower +
                '}';
    }
}
