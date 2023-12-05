package com.workintech.models.person;

import com.workintech.enums.PersonType;

public abstract class Member extends Person{
    private long memberID;
    private String dateOfMembership;
    private int numberOfBooksBorrowed;
    private double bill;

    public Member(String name, PersonType type, long memberID, String dateOfMembership) {
        super(name, type);
        this.memberID = memberID;
        this.dateOfMembership = dateOfMembership;
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

    public int getNumberOfBooksBorrowed() {
        return numberOfBooksBorrowed;
    }

    public void setNumberOfBooksBorrowed(int numberOfBooksBorrowed) {
        this.numberOfBooksBorrowed = numberOfBooksBorrowed;
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
                ", numberOfBooksBorrowed=" + numberOfBooksBorrowed +
                '}';
    }
}
