package com.workintech.models;

import com.workintech.models.book.Book;
import com.workintech.models.person.Member;

import java.util.Map;


public class Library {
    private static Map<Long, Book> books;
    private static Map<Long, Member> members;

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

    public static void addToCollection(Book... newBooks) {
        for (Book newBook: newBooks) {
            if (books.containsKey(newBook.getISBN())) System.out.println("This book is already in the system.");
            else books.put(newBook.getISBN(), newBook);
        }
    }

    public static void addMember(Member... newMembers) {
        for (Member newMember: newMembers) {
            if (members.containsKey(newMember.getMemberID())) System.out.println("A member with the given ID is already in the system.");
            else members.put(newMember.getMemberID(), newMember);
        }
    }
}
