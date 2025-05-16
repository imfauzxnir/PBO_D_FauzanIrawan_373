package com.praktikum.users;

import com.praktikum.actions.AdminActions; // Import the interface
import java.util.Scanner; // Needed for displayAppMenu loop

public class Admin extends User implements AdminActions { // Inheritance & Interface Implementation
    private String usernameAdminValid;
    private String passwordAdminValid;

    // Constructor Admin
    public Admin(String nama, String nim, String usernameAdminValid, String passwordAdminValid) {
        super(nama, nim); // Calling superclass constructor
        this.usernameAdminValid = usernameAdminValid;
        this.passwordAdminValid = passwordAdminValid;
    }

    // Getter methods (optional, but good practice)
    public String getUsernameAdminValid() {
        return usernameAdminValid;
    }

    public String getPasswordAdminValid() {
        return passwordAdminValid;
    }

    // Overriding abstract login method from User
    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(this.usernameAdminValid) && inputPassword.equals(this.passwordAdminValid);
    }

    // Implementing AdminActions methods (placeholders for now)
    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }

    // Overriding abstract displayAppMenu method from User
    @Override
    public void displayAppMenu() {
        Scanner menuInput = new Scanner(System.in); // New Scanner for menu input

        int choice = -1; // Use an invalid initial choice to enter loop
        while (choice != 0) {
            System.out.println("\n--- Menu Admin ---");
            System.out.println("Selamat datang, Admin " + getNama() + "!");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan Anda: ");

            if (menuInput.hasNextInt()) {
                choice = menuInput.nextInt();
                menuInput.nextLine(); // Consume newline
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                menuInput.nextLine(); // Consume invalid input
                continue; // Continue loop
            }

            switch (choice) {
                case 1:
                    manageItems(); // Call implemented method
                    break;
                case 2:
                    manageUsers(); // Call implemented method
                    break;
                case 0:
                    System.out.println("Logging out Admin...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Overriding displayInfo method (optional based on previous implementation)
    @Override
    public void displayInfo() {
        // Display Admin-specific login success message before potentially calling super.displayInfo()
        System.out.println("Login sebagai Admin berhasil!");
        // super.displayInfo(); // Optional: to also show Nama and NIM from User class
    }
}