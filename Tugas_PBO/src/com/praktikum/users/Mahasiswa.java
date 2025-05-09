package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions; // Import the interface
import java.util.Scanner; // Needed for reportItem and displayAppMenu loop

public class Mahasiswa extends User implements MahasiswaActions { // Inheritance & Interface Implementation

    // Constructor Mahasiswa
    public Mahasiswa(String nama, String nim) {
        super(nama, nim); // Calling superclass constructor
    }

    // Overriding abstract login method from User
    @Override
    public boolean login(String inputNama, String inputNim) {
        // Validation against attributes inherited from User
        return inputNama.equals(getNama()) && inputNim.equals(getNim());
    }

    // Implementing MahasiswaActions methods
    @Override
    public void reportItem() {
        Scanner reportInput = new Scanner(System.in); // New Scanner for report input

        System.out.println("\n--- Laporkan Barang Temuan/Hilang ---");
        System.out.print("Masukkan Nama Barang: ");
        String namaBarang = reportInput.nextLine();
        System.out.print("Masukkan Deskripsi Barang: ");
        String deskripsiBarang = reportInput.nextLine();
        System.out.print("Masukkan Lokasi Terakhir/Ditemukan: ");
        String lokasi = reportInput.nextLine();

        System.out.println("\nLaporan Anda telah diterima:");
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsiBarang);
        System.out.println("Lokasi: " + lokasi);
        System.out.println("Terima kasih telah melaporkan.");

        // reportInput.close(); // Closing Scanner inside the method might be problematic if main Scanner is still needed.
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

    // Overriding abstract displayAppMenu method from User
    @Override
    public void displayAppMenu() {
        Scanner menuInput = new Scanner(System.in); // New Scanner for menu input

        int choice = -1; // Use an invalid initial choice to enter loop
        while (choice != 0) {
            System.out.println("\n--- Menu Mahasiswa ---");
            System.out.println("Selamat datang, Mahasiswa!");
            super.displayInfo(); // Display basic info using superclass method
            System.out.println("----------------------");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
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
                    reportItem(); // Call implemented method
                    break;
                case 2:
                    viewReportedItems(); // Call implemented method
                    break;
                case 0:
                    System.out.println("Logging out Mahasiswa...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        // menuInput.close(); // Closing Scanner inside the method might be problematic if main Scanner is still needed.
    }

    // Overriding displayInfo method (optional based on previous implementation)
    @Override
    public void displayInfo() {
        // Display Mahasiswa-specific login success message before calling super.displayInfo()
        System.out.println("Login sebagai Mahasiswa berhasil!");
        // super.displayInfo(); // Called inside displayAppMenu now
    }
}