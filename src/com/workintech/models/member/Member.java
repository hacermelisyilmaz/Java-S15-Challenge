package com.workintech.models.member;

import com.workintech.enums.BookStatus;
import com.workintech.enums.PersonType;
import com.workintech.models.restricted.Library;
import com.workintech.models.book.Book;

import java.util.*;

public abstract class Member extends Person implements Comparable {
    private long memberID;
    private String dateOfMembership;
    private Map<Long, Book> borrowedBooks;

    public Member(String name, PersonType type, long memberID, String dateOfMembership, Map<Long, Book> borrowedBooks) {
        super(name, type);
        this.memberID = memberID;
        this.dateOfMembership = dateOfMembership;
        this.borrowedBooks = borrowedBooks;
    }

    public abstract void borrowBook(long ISBN);
    public abstract void returnBook(long ISBN);

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

    public Map<Long, Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Map<Long, Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public int compareTo(Object o) {
        return Long.compare(this.memberID, ((Member) o).getMemberID());
    }
}
