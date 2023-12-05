package com.workintech.models.person;

import com.workintech.enums.BookStatus;
import com.workintech.enums.PersonType;
import com.workintech.models.book.Book;

public class Faculty extends Member {
    private static int maxBooklimit = 15;


    public Faculty(String name, PersonType type, long memberID, String dateOfMembership) {
        super(name, type, memberID, dateOfMembership);
    }
}
