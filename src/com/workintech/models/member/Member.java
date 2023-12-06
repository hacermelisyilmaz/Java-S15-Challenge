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
    private double bill;

    public Member(String name, PersonType type, long memberID, String dateOfMembership, Map<Long, Book> borrowedBooks) {
        super(name, type);
        this.memberID = memberID;
        this.dateOfMembership = dateOfMembership;
        this.borrowedBooks = borrowedBooks;
    }

    public void borrowBook(long ISBN, int maxLimit) {
        if (Library.getBooks().containsKey(ISBN)) {
            if (Library.getBook(ISBN).getStatus() == BookStatus.AVAILABLE) {
                if (borrowedBooks.size() < maxLimit) {
                    borrowedBooks.put(ISBN, Library.getBook(ISBN));
                    Library.getBook(ISBN).setStatus(BookStatus.LENT);
                    Library.getBook(ISBN).setBorrower(Library.getMember(memberID));
                }
                else System.out.println("You have reached the limit for borrowing books (%d)" + maxLimit);
            }
            else System.out.println("The book is not available.");
        }
        else System.out.println("Book not found in the system.");
    }

    public void returnBook(long ISBN) {
        boolean flag = false;

        if (Library.getBooks().containsKey(ISBN)) flag = true;
        else System.out.println("Book not found in the system.");

        if (flag && borrowedBooks.containsKey(ISBN)) {
            borrowedBooks.remove(ISBN);
            Library.getBook(ISBN).setStatus(BookStatus.AVAILABLE);
            Library.getBook(ISBN).setBorrower(null);
        }
        else System.out.println("The book is not in your borrowed book list.");
    }

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

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name=" + getName() +
                "memberID=" + memberID +
                "type=" + getType() +
                "phone=" + getPhoneNumber() +
                ", dateOfMembership='" + dateOfMembership + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return Long.compare(this.memberID, ((Member) o).getMemberID());
    }
}
