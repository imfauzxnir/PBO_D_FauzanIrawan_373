package com.praktikum.users;

// User.java
public abstract class User { // Abstraction: Abstract Class
    private String nama; // Encapsulation
    private String nim;  // Encapsulation

    // Constructor
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // Abstract method for login - implementation is deferred to subclasses
    public abstract boolean login(String input1, String input2); // Abstraction: Abstract Method (Polymorphism base)

    // Abstract method to display the application menu - implementation is deferred to subclasses
    public abstract void displayAppMenu(); // Abstraction: Abstract Method (Polymorphism base)

    // Concrete method to display basic user info
    public void displayInfo() {
        System.out.println("Nama User: " + getNama());
        System.out.println("NIM User : " + getNim());
    }
}