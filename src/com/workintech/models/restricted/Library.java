package com.workintech.models.restricted;

import com.workintech.models.book.Author;
import com.workintech.models.book.Book;
import com.workintech.models.member.Member;

import java.util.*;
import java.util.stream.Collectors;


public class Library {
    private static Set<Author> authors = new HashSet<>();
    private static Map<Long, Book> books = new HashMap<>();
    private static Map<Long, Member> members = new TreeMap<>();
    private static double deposit = 10.00;

    public static Map<Long, Book> getBooks() {
        return books;
    }

    public static Book getBook(long ISBN) {
        if (books.containsKey(ISBN)) return books.get(ISBN);
        else System.out.println("Invalid ISBN or the book is not found in the system.");
        return null;
    }

    public static Set<Book> getBook(String type, String search) {
        Set<Book> searchResults = new HashSet<>();
        String lowerCaseSearch = search.toLowerCase(Locale.ENGLISH);

        switch (type) {
            case "name":
                searchResults = books.values().stream()
                        .filter(book -> book.getName().toLowerCase(Locale.ENGLISH).contains(lowerCaseSearch))
                        .collect(Collectors.toSet());
            case "author":
                searchResults = books.values().stream()
                        .filter(book -> (book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName())
                                .toLowerCase(Locale.ENGLISH).contains(lowerCaseSearch))
                        .collect(Collectors.toSet());
            case "genre":
                searchResults = books.values().stream()
                        .filter(book -> book.getGenre().toLowerCase(Locale.ENGLISH).contains(lowerCaseSearch))
                        .collect(Collectors.toSet());
            default:
                System.out.println("Invalid search type.");
        }
        return searchResults;
    }

    public static Map<Long, Member> getMembers() {
        return members;
    }

    public static Member getMember(long ID) {
        if (!members.containsKey(ID)) System.out.println("Invalid ID or the member is not found in the system.");
        return members.get(ID);
    }

    protected static void addBooks(Book... newBooks) {
        for (Book newBook : newBooks) {
            if (books.containsKey(newBook.getISBN())) System.out.println("This book is already in the system.");
            else {
                books.put(newBook.getISBN(), newBook);
                newBook.getAuthor().getBooks().put(newBook.getISBN(), newBook);
                System.out.println(newBook.getName() + " is successfully added.");
            }
        }
    }

    protected static void addMembers(Member... newMembers) {
        for (Member newMember : newMembers) {
            if (members.containsKey(newMember.getMemberID()))
                System.out.println("A member with the given ID is already in the system.");
            else {
                members.put(newMember.getMemberID(), newMember);
                System.out.println(newMember.getName() + " is successfully added.");
            }
        }
    }

    protected static void addAuthors(Author... newAuthors) {
        for (Author newAuthor : newAuthors) {
            authors.add(newAuthor);
            System.out.println(newAuthor.toString() + " is successfully added.");
        }
    }

    public static double getDeposit() {
        return deposit;
    }
}
