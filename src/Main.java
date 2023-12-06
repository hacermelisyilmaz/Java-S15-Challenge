import com.workintech.models.Library;
import com.workintech.models.book.Author;
import com.workintech.models.book.Book;
import com.workintech.models.person.Member;
import com.workintech.models.person.Student;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /* ADDING BOOKS TO THE GENERAL COLLECTION */
        Library.addToCollection(
                new Book(9780060931407L, new Author("Doris", "Lessing", 1919), "The Golden Notebook",
                        1962, 20, "2013/12/13", "Harper Perennial", 52.99, "2022/09/21"),
                new Book(9780140135152L, new Author("John", "Berger", 1926), "The Ways of Seeing",
                        1972, 5, "1990/12/01", "Penguin Group", 19.90, "2022/11/09"),
                new Book(9780805210415L, new Author("Primo", "Levi", 1919), "The Periodic Table",
                        1975, 3, "1995/04/04", "Schocken", 8.90, "2023/06/23"),
                new Book(9789750501364L, new Author("Sevgi", "Soysal", 1936), "Şafak",
                        1975, 2, "1975/04/01", "İletişim Yayınları", 11.00, "2023/09/22"),
                new Book(9789753632904L, new Author("Füruzan", "NA", 1932), "Benim Sinemalarım",
                        1973, 2, "NA", "Yapı Kredi Yayınları", 3.90, "2023/02/22"));


    }
}