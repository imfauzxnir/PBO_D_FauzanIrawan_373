import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Buat Scanner
        Scanner input = new Scanner(System.in);

        // Input data
        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan jenis kelamin (L/P): ");
        char gender = input.next().charAt(0);

        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = input.nextInt();

        // Hitung umur
        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;

        // Ubah jenis kelamin ke bentuk lengkap
        String jenisKelamin;
        if (gender == 'L' || gender == 'l') {
            jenisKelamin = "Laki-laki";
        } else if (gender == 'P' || gender == 'p') {
            jenisKelamin = "Perempuan";
        } else {
            jenisKelamin = "Tidak diketahui";
        }

        // Output hasil
        System.out.println("\n--- Data Pengguna ---");
        System.out.println("Nama          : " + nama);
        System.out.println("Jenis Kelamin : " + jenisKelamin);
        System.out.println("Umur          : " + umur + " tahun");

        // Tutup Scanner
        input.close();
    }
}
