package com.workintech.models.book;

import com.workintech.enums.BookStatus;
import com.workintech.models.member.Member;
import com.workintech.models.member.Person;

public class Book implements Comparable {
    private long ISBN;
    private Author author;
    private String name;
    private int year;
    private int edition;
    private String dateOfPublication;
    private String publisher;
    private String genre;
    private double price;
    private BookStatus status;
    private String dateOfPurchase;
    private Person borrower;
    private Person reserver;

    public Book(long ISBN, Author author, String name, int year, int edition, String dateOfPublication, String publisher, double price, String dateOfPurchase, String genre) {
        this.ISBN = ISBN;
        this.author = author;
        this.name = name;
        this.year = year;
        this.edition = edition;
        this.dateOfPublication = dateOfPublication;
        this.publisher = publisher;
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
        this.genre = genre;
        this.status = BookStatus.AVAILABLE;
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

    public Person getBorrower() {
        return borrower;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Person getReserver() {
        return reserver;
    }

    public void setReserver(Person reserver) {
        this.reserver = reserver;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return ISBN == book.ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", status=" + status +
                ", year=" + year +
                ", genre=" + genre +
                ", edition=" + edition +
                ", dateOfPublication='" + dateOfPublication + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                "}\n";
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Book) o).getName());
    }
}
