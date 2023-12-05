package com.workintech.models.person;

import com.workintech.enums.PersonType;

public abstract class Person {
    private String name;
    private String phoneNumber;
    private PersonType type;

    public Person(String name, PersonType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PersonType getType() {
        return type;
    }
}
