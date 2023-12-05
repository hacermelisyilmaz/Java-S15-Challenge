package com.workintech.models.person;

import com.workintech.enums.BookStatus;
import com.workintech.enums.PersonType;
import com.workintech.models.Library;
import com.workintech.models.book.Book;

import java.util.*;

public abstract class Member extends Person {
    private long memberID;
    private String dateOfMembership;
    private Map<Long, Book> borrowedBooks = new TreeMap<>();
    private int numberOfBooksBorrowed;
    private double bill;

    public Member(String name, PersonType type, long memberID, String dateOfMembership) {
        super(name, type);
        this.memberID = memberID;
        this.dateOfMembership = dateOfMembership;
    }

    public void borrowBook(Long newISBN) {
        boolean flag = false;

        if (Library.getBooks().containsKey(newISBN)) flag = true;
        else System.out.println("Book not found in the system.");

        if (flag && Library.getBook(newISBN).getStatus() == BookStatus.AVAILABLE) {
            borrowedBooks.put(newISBN, Library.getBook(newISBN));
            Library.getBook(newISBN).setStatus(BookStatus.LENT);
        }
        else System.out.println("The book is not available.");
    }

    public long getMemberID() {
        return memberID;
    }

    public void setMemberID(long memberID) {
        this.memberID = memberID;
    }

    public String getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(String dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public int getNumberOfBooksBorrowed() {
        return numberOfBooksBorrowed;
    }

    public void setNumberOfBooksBorrowed(int numberOfBooksBorrowed) {
        this.numberOfBooksBorrowed = numberOfBooksBorrowed;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name=" + getName() +
                "memberID=" + memberID +
                "type=" + getType() +
                "phone=" + getPhoneNumber() +
                ", dateOfMembership='" + dateOfMembership + '\'' +
                ", numberOfBooksBorrowed=" + numberOfBooksBorrowed +
                '}';
    }
}
