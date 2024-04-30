package com.hospitalmenegment1.model;

public class Person {
    private  int id;
    private String name;
   private String email;
   private String designation;
    private String address;
    private String illness;
   private int bill;


    public Person() {
    }

    public Person(int id,String name,String email,String designation,String address,String illness,int bill) {
        this.id = id;
        this.name=name;
        this.email=email;
        this.designation=designation;
        this.address=address;
        this.illness=illness;
        this.bill=bill;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", designation='" + designation + '\'' +
                ", address='" + address + '\'' +
                ", illness='" + illness + '\'' +
                ", bill=" + bill +

                '}';
    }
}
