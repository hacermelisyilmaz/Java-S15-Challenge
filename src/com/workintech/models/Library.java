package com.workintech.models;

import com.workintech.models.book.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Library {
    private static Map<Long, Book> books = new HashMap<>();

    public static Map<Long, Book> getBooks() {
        return books;
    }

    public static Book getBook (long ISBN) {
        return books.get(ISBN);
    }
}
