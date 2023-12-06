package com.workintech.models.restricted;

import com.workintech.enums.PersonType;
import com.workintech.models.book.Book;
import com.workintech.models.member.Member;
import com.workintech.models.member.Person;

import java.util.Locale;
import java.util.Scanner;

public class Librarian extends Person {
    private String password;
    public Librarian(String name, String password) {
        super(name, PersonType.LIBRARIAN);
        this.password = password;
    }

    public boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        return this.password.equals(password);
    }

    public void addNewMember(Member... newMembers) {
        if (authenticate()) Library.addMembers(newMembers);
        else System.out.println("Incorrect password. Member could not be added.");
    }

    public void addToCollection(Book... books) {
        if (authenticate()) Library.addBooks(books);
        else System.out.println("Incorrect password. Book could not be added.");
    }

    public void removeFromCollection(long ISBN) {
        if (authenticate()) {
            Library.getBooks().remove(ISBN);
            System.out.println("Book is successfully removed.");
        }
        else System.out.println("Incorrect password. Book could not be removed.");
    }

    public void editBookInfo(long ISBN) {
        Scanner scanner = new Scanner(System.in);
        if (authenticate()) {
            String type = "";
            while (type.equals("exit")) {
                System.out.println("Choose what to change (name, author, edition, year, publisher, price). Type 'exit' to exit: ");
                type = scanner.nextLine().toLowerCase(Locale.ENGLISH);

                switch (type) {
                    case "exit":
                        break;
                    case "name":
                        System.out.println("Type the new " + type + ": ");
                        String newName = scanner.nextLine();
                        ((Book)Library.getBooks().get(ISBN)).setName(newName);
                    case "author":
                        System.out.println("Type the first name of the " + type + ": ");
                        String first = scanner.nextLine();
                        System.out.println("Type the last name of the " + type + ": ");
                        String second = scanner.nextLine();
                        ((Book)Library.getBooks().get(ISBN)).setAuthor(first, second);
                    case "edition":
                        System.out.println("Type the new " + type + ": ");
                        int newEdition = scanner.nextInt();
                        ((Book)Library.getBooks().get(ISBN)).setEdition(newEdition);
                    case "year":
                        System.out.println("Type the new " + type + ": ");
                        int newYear = scanner.nextInt();
                        ((Book)Library.getBooks().get(ISBN)).setYear(newYear);
                    case "publisher":
                        System.out.println("Type the new " + type + ": ");
                        String newPublisher = scanner.nextLine();
                        ((Book)Library.getBooks().get(ISBN)).setPublisher(newPublisher);
                    case "price":
                        System.out.println("Type the new " + type + ": ");
                        double newPrice = scanner.nextDouble();
                        ((Book)Library.getBooks().get(ISBN)).setPrice(newPrice);
                    default:
                        System.out.println("Incorrect field. Please choose one of the following: name, author, edition, year, publisher, price");
                }

            }
            System.out.println("Book information is successfully edited.");
        }
        else System.out.println("Incorrect password. Book information could not be edited.");
    }

    public void createBill() {

    }

    public void returnDeposit() {

    }

    public void setPassword(String password) {
        this.password = password;
    }
}
