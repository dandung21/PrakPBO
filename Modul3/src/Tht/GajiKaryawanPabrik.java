package Tht;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GajiKaryawanPabrik {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Program Penghitung Gaji Karyawan Pabrik ===");

        // Meminta jumlah karyawan
        int jumlahKaryawan = 0;
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print("Masukkan jumlah karyawan yang akan dihitung gajinya: ");
                jumlahKaryawan = scanner.nextInt();
                if (jumlahKaryawan <= 0) {
                    System.out.println("Jumlah karyawan harus lebih dari 0.");
                } else {
                    inputValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka bulat.");
                scanner.next(); // Membersihkan input yang salah
            }
        }
        scanner.nextLine(); // Membersihkan newline setelah nextInt()

        // Array untuk menyimpan data gaji
        String[] idKaryawan = new String[jumlahKaryawan];
        String[] namaKaryawan = new String[jumlahKaryawan];
        String[] shiftKaryawan = new String[jumlahKaryawan];
        int[] jamKerjaMingguan = new int[jumlahKaryawan];
        int[] hariAbsen = new int[jumlahKaryawan];
        double[] gajiBersih = new double[jumlahKaryawan];

        // Loop untuk meminta data setiap karyawan
        for (int i = 0; i < jumlahKaryawan; i++) {
            System.out.println("\n--- Data Karyawan ke-" + (i + 1) + " ---");

            System.out.print("ID Karyawan: ");
            idKaryawan[i] = scanner.nextLine();

            System.out.print("Nama Karyawan: ");
            namaKaryawan[i] = scanner.nextLine();

            // Meminta shift kerja dengan validasi
            inputValid = false;
            while (!inputValid) {
                System.out.print("Shift Kerja (Pagi/Siang/Malam): ");
                String shiftInput = scanner.nextLine().trim();
                if (shiftInput.equalsIgnoreCase("Pagi") ||
                    shiftInput.equalsIgnoreCase("Siang") ||
                    shiftInput.equalsIgnoreCase("Malam")) {
                    shiftKaryawan[i] = shiftInput;
                    inputValid = true;
                } else {
                    System.out.println("Shift tidak valid. Harap masukkan 'Pagi', 'Siang', atau 'Malam'.");
                }
            }

            // Meminta total jam kerja dengan validasi
            inputValid = false;
            while (!inputValid) {
                try {
                    System.out.print("Total Jam Kerja dalam Seminggu: ");
                    jamKerjaMingguan[i] = scanner.nextInt();
                    if (jamKerjaMingguan[i] < 0 || jamKerjaMingguan[i] > (7 * 24)) { // Maksimal 7 hari x 24 jam
                        System.out.println("Jam kerja tidak masuk akal. Harap masukkan angka antara 0 dan 168.");
                    } else {
                        inputValid = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid. Harap masukkan angka bulat untuk jam kerja.");
                    scanner.next(); // Membersihkan input yang salah
                }
            }
            scanner.nextLine(); // Membersihkan newline setelah nextInt()

            // Meminta jumlah hari absen dengan validasi
            inputValid = false;
            while (!inputValid) {
                try {
                    System.out.print("Jumlah Hari Absen Tanpa Alasan (0-7 hari): ");
                    hariAbsen[i] = scanner.nextInt();
                    if (hariAbsen[i] < 0 || hariAbsen[i] > 7) {
                        System.out.println("Jumlah hari absen tidak valid. Harap masukkan angka antara 0 dan 7.");
                    } else {
                        inputValid = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid. Harap masukkan angka bulat untuk hari absen.");
                    scanner.next(); // Membersihkan input yang salah
                }
            }
            scanner.nextLine(); // Membersihkan newline setelah nextInt()

            // --- Perhitungan Gaji ---
            double tarifPerJam = 0;
            switch (shiftKaryawan[i].toLowerCase()) {
                case "pagi":
                    tarifPerJam = 50000; // Contoh tarif
                    break;
                case "siang":
                    tarifPerJam = 55000; // Contoh tarif
                    break;
                case "malam":
                    tarifPerJam = 60000; // Contoh tarif
                    break;
            }

            double gajiPokok = jamKerjaMingguan[i] * tarifPerJam;
            double potonganAbsen = hariAbsen[i] * 100000; // Potongan Rp100.000 per hari absen
            double gajiLembur = 0;
            double potonganKurangKerja = 0;

            // Hitung lembur
            if (jamKerjaMingguan[i] > 40) {
                int jamLembur = jamKerjaMingguan[i] - 40;
                gajiLembur = jamLembur * (tarifPerJam * 1.5); // Tarif lembur 1.5x dari tarif normal
            }

            // Hitung potongan jika kurang dari 30 jam
            if (jamKerjaMingguan[i] < 30) {
                potonganKurangKerja = gajiPokok * 0.10; // Potongan 10%
            }
            
            // Hitung gaji bersih
            gajiBersih[i] = gajiPokok + gajiLembur - potonganAbsen - potonganKurangKerja;
            
            // Pastikan gaji tidak negatif
            if (gajiBersih[i] < 0) {
                gajiBersih[i] = 0;
            }
        }

        // --- Menampilkan Laporan Gaji ---
        System.out.println("\n\n=== Laporan Gaji Karyawan ===");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-18s | %-8s | %-8s | %-8s | %-15s |\n",
                          "ID", "Nama", "Shift", "Jam Krj", "Absen", "Gaji Bersih");
        System.out.println("--------------------------------------------------------------------------------------------------");

        for (int i = 0; i < jumlahKaryawan; i++) {
            System.out.printf("| %-5s | %-18s | %-8s | %-8d | %-8d | Rp %,12.2f |\n",
                              idKaryawan[i], namaKaryawan[i], shiftKaryawan[i],
                              jamKerjaMingguan[i], hariAbsen[i], gajiBersih[i]);
        }
        System.out.println("--------------------------------------------------------------------------------------------------");

        System.out.println("\nTerima kasih telah menggunakan program ini!");
        scanner.close();
    }
}
