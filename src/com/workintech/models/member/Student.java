package com.workintech.models.member;

import com.workintech.enums.Status;
import com.workintech.enums.PersonType;
import com.workintech.models.book.Book;
import com.workintech.models.library.Library;
import com.workintech.models.library.StudyRoom;

import java.util.Map;
import java.util.Optional;

public class Student extends Member {
    private int maxBooklimit = 5;
    private double bill;
    private int reservedRoomNo = 0;

    public Student(String name, long memberID, String dateOfMembership, Map<Long, Book> borrowedBooks) {
        super(name, PersonType.STUDENT, memberID, dateOfMembership, borrowedBooks);
        bill = 0;
    }

    @Override
    public void borrowBook(long ISBN) {
        Book book = Library.getBook(ISBN);

        if (book != null) {
            if (book.getStatus() == Status.AVAILABLE) {
                if (getBorrowedBooks().size() < maxBooklimit) {
                    getBorrowedBooks().put(book.getISBN(), book);
                    book.setStatus(Status.LENT);
                    book.setBorrower(this);
                    bill -= Library.getDeposit();
                }
                else System.out.println("You have reached the limit for borrowing books:" + maxBooklimit);
            }
            else if (book.getStatus() == Status.LENT) {
                System.out.println("The book is not available. Borrower:");
                System.out.println(book.getBorrower().getName());
            }
            else {
                System.out.println("The book is reserved by the following faculty member. Please wait for the book to be available");
                System.out.println(book.getReserver().getName());
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
                book.setStatus(Status.AVAILABLE);
                book.setBorrower(null);
            } else System.out.println("The book is not in your borrowed book list.");
        } else System.out.println("Return request failed.");
    }

    public void reserveStudyRoom (int roomNo) {
        StudyRoom room = Library.getStudyRoom(roomNo);
        if (room != null) {
            if (room.getStatus() == Status.AVAILABLE) {
                room.setStatus(Status.RESERVED);
                room.setReserver(this);
                reservedRoomNo = roomNo;
            }
            else System.out.println("Room not available. Please check again later.");
        }
    }

    public void cancelStudyRoomReservation (int roomNo) {
        StudyRoom room = Library.getStudyRoom(roomNo);
        if (room != null) {
            if (room.getStatus() == Status.RESERVED) {
                room.setStatus(Status.AVAILABLE);
                room.setReserver(null);
                reservedRoomNo = 0;
            }
            else System.out.println("Room already available.");
        }
    }

    public double getBill() {
        return bill;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + super.getName() +
                ", ID=" + super.getMemberID() +
                ", bill=" + bill +
                ", reservedRoomNo=" + reservedRoomNo +
                '}';
    }
}
