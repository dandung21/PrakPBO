package Posttest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DiskonTokoOnline {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalBelanja = 0;
        String tipeMember = "";
        boolean inputValid = false;

        // Meminta input total belanja dengan validasi
        while (!inputValid) {
            System.out.print("Masukkan total belanja (dalam Rupiah): ");
            try {
                totalBelanja = scanner.nextDouble();
                if (totalBelanja < 0) {
                    System.out.println("Total belanja tidak boleh negatif. Silakan masukkan angka yang valid.");
                } else {
                    inputValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka untuk total belanja.");
                scanner.next(); // Membersihkan input yang salah
            }
        }
        scanner.nextLine(); // Membersihkan newline setelah nextDouble()

        inputValid = false; // Reset untuk input tipe member

        // Meminta input tipe member dengan validasi
        while (!inputValid) {
            System.out.print("Masukkan tipe member (Platinum, Gold, Silver, Non-member): ");
            tipeMember = scanner.nextLine().trim(); // Menghapus spasi di awal/akhir
            if (tipeMember.equalsIgnoreCase("Platinum") ||
                tipeMember.equalsIgnoreCase("Gold") ||
                tipeMember.equalsIgnoreCase("Silver") ||
                tipeMember.equalsIgnoreCase("Non-member")) {
                inputValid = true;
            } else {
                System.out.println("Tipe member tidak valid. Harap masukkan Platinum, Gold, Silver, atau Non-member.");
            }
        }

        double diskonUtama = 0;
        double diskonTambahan = 0;

        // Menentukan diskon utama menggunakan if-else
        if (totalBelanja > 500000) {
            diskonUtama = 0.20; // 20%
        } else if (totalBelanja >= 250000) { // Antara 250.000 hingga 500.000
            diskonUtama = 0.10; // 10%
        } else {
            diskonUtama = 0; // Tidak ada diskon
        }

        double totalSetelahDiskonUtama = totalBelanja - (totalBelanja * diskonUtama);

        // Menentukan diskon tambahan menggunakan switch-case
        switch (tipeMember.toLowerCase()) {
            case "platinum":
                diskonTambahan = 0.05; // 5%
                break;
            case "gold":
                diskonTambahan = 0.03; // 3%
                break;
            case "silver":
                diskonTambahan = 0.02; // 2%
                break;
            case "non-member":
                diskonTambahan = 0; // Tidak ada diskon tambahan
                break;
            // Default tidak perlu karena sudah divalidasi di awal
        }

        double totalDiskonKeseluruhan = (totalBelanja * diskonUtama) + (totalSetelahDiskonUtama * diskonTambahan);
        double totalPembayaran = totalBelanja - totalDiskonKeseluruhan;

        System.out.println("\n--- Rincian Belanja ---");
        System.out.printf("Total Belanja Awal: Rp %,.2f%n", totalBelanja);
        System.out.printf("Diskon Utama (%.0f%%): Rp %,.2f%n", (diskonUtama * 100), (totalBelanja * diskonUtama));
        System.out.printf("Diskon Tambahan Member (%.0f%%): Rp %,.2f%n", (diskonTambahan * 100), (totalSetelahDiskonUtama * diskonTambahan));
        System.out.printf("Total Diskon: Rp %,.2f%n", totalDiskonKeseluruhan);
        System.out.printf("Total Pembayaran: Rp %,.2f%n", totalPembayaran);

        // Menggunakan ternary operator untuk menampilkan status diskon
        String statusDiskon = (totalDiskonKeseluruhan > 0) ? "Pelanggan mendapatkan diskon." : "Pelanggan tidak mendapatkan diskon.";
        System.out.println(statusDiskon);

        scanner.close();
    }
}