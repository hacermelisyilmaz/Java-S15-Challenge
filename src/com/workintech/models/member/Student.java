package com.workintech.models.member;

import com.workintech.enums.BookStatus;
import com.workintech.enums.PersonType;
import com.workintech.models.book.Book;
import com.workintech.models.restricted.Library;

import java.util.Map;
import java.util.Optional;

public class Student extends Member {
    private int maxBooklimit = 5;
    private double bill;

    public Student(String name, long memberID, String dateOfMembership, Map<Long, Book> borrowedBooks) {
        super(name, PersonType.STUDENT, memberID, dateOfMembership, borrowedBooks);
        bill = 0;
    }

    @Override
    public void borrowBook(long ISBN) {
        Book book = Library.getBook(ISBN);

        if (book != null) {
            if (book.getStatus() == BookStatus.AVAILABLE) {
                if (getBorrowedBooks().size() < maxBooklimit) {
                    getBorrowedBooks().put(book.getISBN(), book);
                    book.setStatus(BookStatus.LENT);
                    book.setBorrower(this);
                    bill -= Library.getDeposit();
                }
                else System.out.println("You have reached the limit for borrowing books (%d)" + maxBooklimit);
            }
            else if (book.getStatus() == BookStatus.LENT) {
                System.out.println("The book is not available. Borrower:");
                System.out.println(book.getBorrower());
            }
            else {
                System.out.println("The book is reserved by the following faculty member. Please wait for the book to be available");
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
                bill += Library.getDeposit();
                book.setStatus(BookStatus.AVAILABLE);
                book.setBorrower(null);
            } else System.out.println("The book is not in your borrowed book list.");
        } else System.out.println("Return request failed.");
    }

    public double getBill() {
        return bill;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name=" + super.getName() +
                ", id=" + super.getMemberID() +
                ", bill=" + bill +
                '}';
    }
}
