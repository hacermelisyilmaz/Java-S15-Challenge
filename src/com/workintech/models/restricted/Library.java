package com.workintech.models.restricted;

import com.workintech.models.book.Book;
import com.workintech.models.member.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Library {
    private static Map<Long, Book> books = new HashMap<>();
    private static Map<Long, Member> members = new TreeMap<>();

    public static Map<Long, Book> getBooks() {
        return books;
    }

    public static Book getBook (long ISBN) {
        if (!books.containsKey(ISBN)) System.out.println("Invalid ISBN or the book is not found in the system.");
        return books.get(ISBN);
    }

    public static Map<Long, Member> getMembers() {
        return members;
    }

    public static Member getMember (long ID) {
        if (!members.containsKey(ID)) System.out.println("Invalid ID or the member is not found in the system.");
        return members.get(ID);
    }

    protected static void addBooks(Book... newBooks) {
        for (Book newBook: newBooks) {
            if (books.containsKey(newBook.getISBN())) System.out.println("This book is already in the system.");
            else {
                books.put(newBook.getISBN(), newBook);
                System.out.println(newBook.getName() + " is successfully added.");
            }
        }
    }

    protected static void addMembers(Member... newMembers) {
        for (Member newMember: newMembers) {
            if (members.containsKey(newMember.getMemberID())) System.out.println("A member with the given ID is already in the system.");
            else {
                members.put(newMember.getMemberID(), newMember);
                System.out.println(newMember.getName() + " is successfully added.");
            }
        }
    }
}
