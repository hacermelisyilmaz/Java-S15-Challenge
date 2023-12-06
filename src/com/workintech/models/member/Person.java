package com.workintech.models.member;

import com.workintech.enums.PersonType;

public abstract class Person {
    private String name;
    private String phoneNumber;
    private PersonType type;

    public Person(String name, PersonType type) {
        this.name = name;
        this.type = type;
    }

    public Person(String name, String phoneNumber, PersonType type) {
        this.name = name;
        this.phoneNumber = phoneNumber;
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
