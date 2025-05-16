package Modul_5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Data awal
        daftarBarang.add(new Barang("Pulpen", 10));
        daftarBarang.add(new Barang("Buku Tulis", 20));
        daftarBarang.add(new Barang("Penghapus", 5));

        int pilihan;
        do {
            System.out.println("\n=== Menu Manajemen Stok ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // bersihkan newline

                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Nama Barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Stok Awal: ");
                        try {
                            int stok = scanner.nextInt();
                            scanner.nextLine();
                            daftarBarang.add(new Barang(nama, stok));
                            System.out.println("Barang berhasil ditambahkan.");
                        } catch (InputMismatchException e) {
                            System.out.println("Input stok harus berupa angka!");
                            scanner.nextLine();
                        }
                    }
                    case 2 -> {
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Stok barang kosong.");
                        } else {
                            System.out.println("Daftar Barang:");
                            for (Barang b : daftarBarang) {
                                System.out.println("- " + b.getNama() + " (Stok: " + b.getStok() + ")");
                            }
                        }
                    }
                    case 3 -> {
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Tidak ada barang untuk dikurangi.");
                            break;
                        }

                        for (int i = 0; i < daftarBarang.size(); i++) {
                            System.out.println(i + ". " + daftarBarang.get(i).getNama() + " (Stok: " + daftarBarang.get(i).getStok() + ")");
                        }

                        try {
                            System.out.print("Pilih indeks barang: ");
                            int index = scanner.nextInt();
                            scanner.nextLine();

                            Barang barang = daftarBarang.get(index);

                            System.out.print("Jumlah stok yang dikurangi: ");
                            int jumlah = scanner.nextInt();
                            scanner.nextLine();

                            if (jumlah > barang.getStok()) {
                                throw new StokTidakCukupException("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
                            }

                            barang.setStok(barang.getStok() - jumlah);
                            System.out.println("Stok berhasil dikurangi.");
                        } catch (InputMismatchException e) {
                            System.out.println("Input harus berupa angka!");
                            scanner.nextLine();
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Indeks barang tidak valid.");
                        } catch (StokTidakCukupException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 0 -> System.out.println("Terima kasih!");
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }

        } while (pilihan != 0);

        scanner.close();
    }
}
