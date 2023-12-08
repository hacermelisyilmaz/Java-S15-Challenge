import com.workintech.models.member.Member;
import com.workintech.models.restricted.Library;
import com.workintech.models.book.Author;
import com.workintech.models.book.Book;
import com.workintech.models.member.Faculty;
import com.workintech.models.restricted.Librarian;
import com.workintech.models.member.Person;
import com.workintech.models.member.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Create the librarian
        Person librarian = new Librarian("Evrim Yılmaz", "1");

        // Adding books to the general colleciton
        Author lessing1919 = new Author("Doris", "Lessing", 1919, new HashMap<>());
        Author berger1926 = new Author("John", "Berger", 1926, new HashMap<>());
        Author levi1919 = new Author("Primo", "Levi", 1919, new HashMap<>());
        Author soysal1936 = new Author("Sevgi", "Soysal", 1936, new HashMap<>());
        Author furuzan1932 = new Author("Füruzan", "NA", 1932, new HashMap<>());
        Author plath1932 = new Author("Sylvia", "Plath", 1932, new HashMap<>());

        System.out.println("Adding authors to the author list...");
        ((Librarian) librarian).addNewAuthor(lessing1919, berger1926, levi1919, soysal1936, furuzan1932, plath1932);

        System.out.println("\nAdding new books to the collection...");
        ((Librarian) librarian).addToCollection(
                new Book(9780060931407L, lessing1919, "The Golden Notebook", 1962,
                        20, "2013/12/13", "Harper Perennial",
                        52.99, "2022/09/21", "novel"),
                new Book(9780140135152L, berger1926, "The Ways of Seeing", 1972,
                        5, "1990/12/01", "Penguin Group",
                        19.90, "2022/11/09", "essays"),
                new Book(9780805210415L, levi1919, "The Periodic Table", 1975,
                        3, "1995/04/04", "Schocken",
                        8.90, "2023/06/23", "biography"),
                new Book(9789750501364L, soysal1936, "Şafak", 1975,
                        2, "1975/04/01", "İletişim Yayınları",
                        11.00, "2023/09/22", "novel"),
                new Book(9789753632904L, furuzan1932, "Benim Sinemalarım", 1973,
                        2, "NA", "Yapı Kredi Yayınları",
                        3.90, "2023/02/22", "shortstories"),
                new Book(9780571268863L, plath1932, "The Bell Jar", 1963,
                        20, "2013/03/01", "Faber & Faber",
                        7.90, "2020/08/27", "novel"));

        // Adding members
        System.out.println("\nAdding new members to the library...");
        Member student = new Student("Melis Yılmaz", 2023404001, "2023/06/23", new TreeMap<>());
        Member faculty = new Faculty("Doğancan  Kınık", 2022400002, "2022/05/02", new TreeMap<>());

        ((Librarian) librarian).addNewMember(
                student,
                new Student("Miray Tunç", 2022415001, "2022/11/25", new TreeMap<>()),
                faculty,
                new Faculty("Erhan Fırat", 2019400001, "2019/06/03", new TreeMap<>())
        );

        // Adding an already existing book to the system
        System.out.println("\nAdding an already existing book to the system...");
        ((Librarian) librarian).addToCollection(
                new Book(9789750501364L, soysal1936,
                        "Şafak", 1975, 2, "1975/04/01", "İletişim Yayınları",
                        11.00, "2023/09/22", "fiction"));


        // Selecting a specific book from the system
        System.out.println("\nSearch for specific book from the system");
        System.out.println("\nBy ISBN:");
        System.out.println("* INVALID *");
        System.out.println("Book: " + Library.getBook(97897505));
        System.out.println("* VALID *");
        System.out.println(Library.getBook(9789750501364L));

        System.out.println("\nBy name:");
        System.out.println("* INVALID *");
        System.out.println("Book: " + Library.getBook("name", "enlightenment"));
        System.out.println("* VALID *");
        System.out.println(Library.getBook("name", "the golden"));

        System.out.println("\nBy author:");
        System.out.println("* INVALID *");
        System.out.println("Book: " + Library.getBook("author", "dworkin"));
        System.out.println("* VALID *");
        System.out.println(Library.getBook("author", "soysal"));

        System.out.println("\nBy genre:");
        System.out.println("* INVALID *");
        System.out.println("Book: " + Library.getBook("genre", "poem"));
        System.out.println("* VALID *");
        System.out.println(Library.getBook("genre", "novel"));

        // Edit information of a book
        System.out.println("\nEdit information of a specific book in the system:");
        System.out.println("Book details before: " + Library.getBook(9789750501364L));
        ((Librarian) librarian).editBookInfo(9789750501364L);
        System.out.println("Book details after: " + Library.getBook(9789750501364L));

        // Remove a book
        System.out.println("\nRemove a book from the system:");
        System.out.println("Books in the collection before:");
        Iterator booksIterator = Library.getBooks().values().iterator();
        int i = 1;
        while (booksIterator.hasNext()) {
            System.out.println(i + ". " + ((Book) booksIterator.next()).getName());
            i++;
        }
        ((Librarian) librarian).removeFromCollection(9789750501364L); // Şafak
        System.out.println("Books in the collection after:");
        booksIterator = Library.getBooks().values().iterator();
        i = 1;
        while (booksIterator.hasNext()) {
            System.out.println(i + ". " + ((Book) booksIterator.next()).getName());
            i++;
        }

        // Borrow a book
        System.out.println("\nBorrow the book");
        System.out.println("Before:");
        System.out.println(Library.getBook(9780060931407L));
        System.out.println(Library.getBook(9780571268863L)); // The Bell Jar
        System.out.println(Library.getMember(2023404001));

        student.borrowBook(9780060931407L);
        student.borrowBook(9780571268863L); // The Bell Jar

        System.out.println("After:");
        System.out.println(Library.getBook(9780060931407L));
        System.out.println(Library.getBook(9780571268863L));  // The Bell Jar
        System.out.println(Library.getMember(2023404001));

        // Return the book
        System.out.println("\nReturn the book");
        System.out.println("Before:");
        System.out.println(Library.getBook(9780060931407L));
        System.out.println(Library.getMember(2023404001));

        student.returnBook(9780060931407L);

        System.out.println("After:");
        System.out.println(Library.getBook(9780060931407L));
        System.out.println(Library.getMember(2023404001));

        // Reserve the book
        System.out.println("\nReserve the book");
        System.out.println("Before:");
        System.out.println(Library.getBook(9780060931407L));
        System.out.println(Library.getBook(9780571268863L));  // The Bell Jar
        System.out.println(Library.getMember(2022400002));

        ((Faculty) faculty).reserveBook(9780060931407L);
        ((Faculty) faculty).reserveBook(9780571268863L);

        System.out.println("After:");
        System.out.println(Library.getBook(9780060931407L));
        System.out.println(Library.getBook(9780571268863L));  // The Bell Jar
        System.out.println(Library.getMember(2022400002));
    }
}