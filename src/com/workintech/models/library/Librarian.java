package com.workintech.models.library;

import com.workintech.enums.PersonType;
import com.workintech.models.book.Author;
import com.workintech.models.book.Book;
import com.workintech.models.member.Member;
import com.workintech.models.member.Person;

import java.util.Locale;
import java.util.Optional;
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

    public void addNewAuthor(Author... newAuthors) {
        if (authenticate()) Library.addAuthors(newAuthors);
        else System.out.println("Incorrect password. Author could not be added.");
    }

    public void addNewMember(Member... newMembers) {
        if (authenticate()) Library.addMembers(newMembers);
        else System.out.println("Incorrect password. Member could not be added.");
    }

    public void addNewStudyRoom(StudyRoom... studyRooms) {
        if (authenticate()) Library.addStudyRooms(studyRooms);
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
        Optional<Book> bookOptional = Optional.ofNullable(Library.getBook(ISBN));
        if (bookOptional.isPresent()) {
            if (authenticate()) {
            Scanner scanner = new Scanner(System.in);
                String type = "";
                while (!type.equals("exit")) {
                    System.out.println("Choose what to change (name, author, edition, year, publisher, price). Type 'exit' to exit: ");
                    type = scanner.nextLine().toLowerCase(Locale.ENGLISH);
                    Book book = bookOptional.get();

                    switch (type) {
                        case "exit":
                            break;
                        case "name":
                            System.out.println("Type the new " + type + ": ");
                            String newName = scanner.nextLine();
                            book.setName(newName);
                            System.out.println(type + " successfully changed to " + newName);
                            break;
                        case "author":
                            System.out.println("Type the first name of the " + type + ": ");
                            String first = scanner.nextLine();
                            System.out.println("Type the last name of the " + type + ": ");
                            String second = scanner.nextLine();
                            book.setAuthor(first, second);
                            System.out.println(type + " successfully changed to " + first + " " + second);
                            break;
                        case "edition":
                            System.out.println("Type the new " + type + ": ");
                            int newEdition = scanner.nextInt();
                            book.setEdition(newEdition);
                            System.out.println(type + " successfully changed to " + newEdition);
                            break;
                        case "year":
                            System.out.println("Type the new " + type + ": ");
                            int newYear = scanner.nextInt();
                            book.setYear(newYear);
                            System.out.println(type + " successfully changed to " + newYear);
                            break;
                        case "publisher":
                            System.out.println("Type the new " + type + ": ");
                            String newPublisher = scanner.nextLine();
                            book.setPublisher(newPublisher);
                            System.out.println(type + " successfully changed to " + newPublisher);
                            break;
                        case "price":
                            System.out.println("Type the new " + type + ": ");
                            double newPrice = scanner.nextDouble();
                            book.setPrice(newPrice);
                            System.out.println(type + " successfully changed to " + newPrice);
                            break;
                        default:
                            System.out.println("Incorrect field.");
                    }
                }
                System.out.println("Book information is successfully edited.");
            }
            else System.out.println("Incorrect password. Book information could not be edited.");
        } else System.out.println("Edit request failed.");

    }
}
