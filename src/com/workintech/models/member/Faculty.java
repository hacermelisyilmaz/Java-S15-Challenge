package com.workintech.models.member;

import com.workintech.enums.BookStatus;
import com.workintech.enums.PersonType;
import com.workintech.models.book.Book;
import com.workintech.models.restricted.Library;

import java.util.Map;
import java.util.Optional;

public class Faculty extends Member {
    private static int maxBooklimit = 15;

    public Faculty(String name, long memberID, String dateOfMembership, Map<Long, Book> borrowedBooks) {
        super(name, PersonType.FACULTY, memberID, dateOfMembership, borrowedBooks);
    }

    @Override
    public void borrowBook(long ISBN) {
        Optional<Book> bookOptional = Optional.ofNullable(Library.getBook(ISBN));

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (book.getStatus() == BookStatus.AVAILABLE) {
                if (getBorrowedBooks().size() < maxBooklimit) {
                    getBorrowedBooks().put(book.getISBN(), book);
                    book.setStatus(BookStatus.LENT);
                    book.setBorrower(Library.getMember(getMemberID()));
                } else System.out.println("You have reached the limit for borrowing books (%d)" + maxBooklimit);
            } else if (book.getStatus() == BookStatus.LENT) {
                System.out.println("The book is not available. Borrower:");
                System.out.println(book.getBorrower());
                System.out.println("You can reserve this book.");
            } else {
                System.out.println("The book is reserved by the following faculty member. Please wait for the book to be available.");
                System.out.println(book.getReserver());
            }
        } else System.out.println("Borrow request failed.");
    }

    @Override
    public void returnBook(long ISBN) {
        Optional<Book> bookOptional = Optional.ofNullable(Library.getBook(ISBN));

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (getBorrowedBooks().containsKey(ISBN)) {
                getBorrowedBooks().remove(ISBN);
                book.setStatus(BookStatus.AVAILABLE);
                book.setBorrower(null);
            } else System.out.println("The book is not in your borrowed book list.");
        } else System.out.println("Return request failed.");
    }

    public void reserveBook(long ISBN) {
        Optional<Book> bookOptional = Optional.ofNullable(Library.getBook(ISBN));

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (book.getStatus() == BookStatus.AVAILABLE) {
                System.out.println("The book is available, you can directly borrow it.");
            } else if (book.getStatus() == BookStatus.LENT) {
                System.out.println("The book is not available. Borrower:");
                System.out.println(book.getBorrower());
                book.setStatus(BookStatus.RESERVED);
                book.setReserver(this);
                System.out.println("You reserved this book. Please wait for it to be available for borrowing it.");
            } else {
                System.out.println("The book is already reserved by the faculty member:");
                System.out.println(book.getReserver());
            }
        } else System.out.println("Reservation failed.");
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name=" + super.getName() +
                "}";
    }
}