package com.praktikum.main;

import com.praktikum.users.Admin;       // Import Admin class
import com.praktikum.users.Mahasiswa;   // Import Mahasiswa class
import com.praktikum.users.User;        // Import User class (for polymorphism)

import java.util.Scanner;

// LoginSystem.java
public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Data untuk Admin
        String namaAdminDefault = "Riyal Etmin";
        String nimAdminDefault = "202110370311537";
        String usernameAdminValid = "Admin" + "373";
        String passwordAdminValid = "Password" + "373";

        // Data untuk Mahasiswa
        String namaMahasiswaAnda = "Fauzan Irawan";
        String nimMahasiswaAnda = "202110370311373";

        // Membuat objek Admin dan Mahasiswa
        Admin adminUser = new Admin(namaAdminDefault, nimAdminDefault, usernameAdminValid, passwordAdminValid);
        Mahasiswa mahasiswaUser = new Mahasiswa(namaMahasiswaAnda, nimMahasiswaAnda);

        System.out.println("Sistem Login");
        System.out.println("----------------------------");
        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan Anda (1 atau 2): ");

        int pilihanLogin = 0;
        if (input.hasNextInt()) {
            pilihanLogin = input.nextInt();
        } else {
            System.out.println("Input tidak valid. Harap masukkan angka (1 atau 2).");
            input.close();
            return;
        }
        input.nextLine();

        System.out.println("----------------------------");

        User loggedInUser = null; // Variable of type User to hold the logged-in object

        switch (pilihanLogin) {
            case 1:
                System.out.println("--- Login Admin ---");
                System.out.print("Masukkan Username Admin: ");
                String usernameInput = input.nextLine();
                System.out.print("Masukkan Password Admin: ");
                String passwordInput = input.nextLine();

                if (adminUser.login(usernameInput, passwordInput)) {
                    loggedInUser = adminUser; // Assign Admin object to User variable
                    // adminUser.displayInfo(); // displayInfo is now called within displayAppMenu
                } else {
                    System.out.println("Login gagal. Silakan coba lagi.");
                }
                break;

            case 2:
                System.out.println("--- Login Mahasiswa ---");
                System.out.print("Masukkan Nama Mahasiswa: ");
                String namaInput = input.nextLine();
                System.out.print("Masukkan NIM Mahasiswa: ");
                String nimInput = input.nextLine();

                if (mahasiswaUser.login(namaInput, nimInput)) {
                    loggedInUser = mahasiswaUser; // Assign Mahasiswa object to User variable
                    // mahasiswaUser.displayInfo(); // displayInfo is now called within displayAppMenu
                } else {
                    System.out.println("Login gagal. Silakan coba lagi.");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

        // Polymorphism: Call displayAppMenu() on the User variable
        if (loggedInUser != null) {
            loggedInUser.displayAppMenu(); // The correct displayAppMenu (Admin or Mahasiswa) is called
        }

        input.close();
        System.out.println("----------------------------");
        System.out.println("Program selesai.");
    }
}