package com.workintech.models.person;

import com.workintech.enums.PersonType;
import com.workintech.models.book.Book;

import java.util.HashMap;
import java.util.Map;

public class Student extends Member {
    private static int maxBooklimit = 5;
    private Map<String, Book> borrowedBooks = new HashMap<>();

    public Student(String name, PersonType type, long memberID, String dateOfMembership, Map<Long, Book> borrowedBooks) {
        super(name, type, memberID, dateOfMembership, borrowedBooks);
    }

    public Map<String, Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
