package com.workintech.models;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private static Map books = new HashMap<>();

    public static Map getBooks() {
        return books;
    }
}
