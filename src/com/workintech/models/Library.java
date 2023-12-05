package com.workintech.models;

import com.workintech.models.book.Book;
import com.workintech.models.person.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Library {
    private static Map<Long, Book> books = new TreeMap<>();
    private static Map<Long, Member> members = new TreeMap<>();

    public static Map<Long, Book> getBooks() {
        return books;
    }

    public static Book getBook (long ISBN) {
        return books.get(ISBN);
    }

    public static Map<Long, Member> getMembers() {
        return members;
    }

    public static Member getMember (long ID) {
        return members.get(ID);
    }


}
