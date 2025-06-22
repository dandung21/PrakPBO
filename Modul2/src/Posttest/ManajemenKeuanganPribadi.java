package Posttest;

import java.util.Scanner;
import java.lang.Math; // Math class diimpor secara otomatis, tapi ini untuk kejelasan

public class ManajemenKeuanganPribadi{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1) Menerima Input dari Pengguna
        System.out.print("Masukkan Nama Anda: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Usia Anda: ");
        int usia = input.nextInt();

        System.out.print("Masukkan Jumlah Uang yang Dimiliki (Rp): ");
        double jumlahUangDimiliki = input.nextDouble();

        System.out.print("Masukkan Rata-rata Pengeluaran Harian (Rp): ");
        double pengeluaranHarian = input.nextDouble();

        // 2) Konversi Tipe Data
        double usiaDouble = (double) usia; // Konversi int ke double
        int jumlahUangInt = (int) jumlahUangDimiliki; // Konversi double ke int (memotong desimal)

        System.out.println("\n--- Data Setelah Konversi ---");
        System.out.println("Usia (double): " + usiaDouble);
        System.out.println("Jumlah Uang Dimiliki (int): " + jumlahUangInt);

        // 3) Perhitungan Keuangan
        double estimasiPengeluaran30Hari = pengeluaranHarian * 30;
        double sisaUang30Hari = jumlahUangDimiliki - estimasiPengeluaran30Hari;

        double estimasiBulanBertahan;
        String statusKeuangan;

        if (pengeluaranHarian * 30 == 0) { // Menghindari pembagian dengan nol
            estimasiBulanBertahan = Double.POSITIVE_INFINITY; // Atau bisa juga 0 jika tidak ada pengeluaran
            statusKeuangan = "Keuangan Anda sangat aman (tidak ada pengeluaran)!";
        } else {
            estimasiBulanBertahan = jumlahUangDimiliki / (pengeluaranHarian * 30);
            if (estimasiBulanBertahan < 1) {
                statusKeuangan = "PERINGATAN: Keuangan Anda kurang stabil!";
            } else if (estimasiBulanBertahan > 6) {
                statusKeuangan = "Keuangan Anda dalam kondisi aman.";
            } else {
                statusKeuangan = "Keuangan Anda cukup stabil.";
            }
        }

        // 4) Operator Perbandingan & Logika
        System.out.println("\n--- Hasil Perbandingan & Logika ---");
        boolean usiaLebihDari30 = usia > 30;
        System.out.println("Apakah usia lebih dari 30? " + usiaLebihDari30);

        boolean usiaLebihDari30DanUangLebihDari10Juta = (usia > 30) && (jumlahUangDimiliki > 10000000);
        System.out.println("Apakah usia > 30 dan uang > 10 juta? " + usiaLebihDari30DanUangLebihDari10Juta);

        boolean usiaKurangDari30AtauUangLebihDari5Juta = (usia < 30) || (jumlahUangDimiliki > 5000000);
        System.out.println("Apakah usia < 30 atau uang > 5 juta? " + usiaKurangDari30AtauUangLebihDari5Juta);

        // 5) Menggunakan Math dan Hutang
        System.out.print("\nMasukkan Jumlah Hutang Anda (Rp, masukkan angka negatif jika tidak ada hutang): ");
        double jumlahHutang = input.nextDouble();

        double nilaiAbsolutHutang = Math.abs(jumlahHutang);
        double pengeluaranHarianDibulatkan = Math.ceil(pengeluaranHarian);

        // Menghasilkan bilangan acak antara 100.000 dan 1.000.000
        double bonusTakTerduga = 100000 + (Math.random() * (1000000 - 100000));
        
        // Asumsi total uang setelah pengeluaran dan bonus untuk contoh output
        // Jika diasumsikan setelah pengeluaran harian dan ditambah bonus
        // Perhitungan ini bisa bervariasi tergantung interpretasi "total uang yang dimiliki setelah pengeluaran dan bonus"
        // Untuk meniru contoh output, kita akan menghitung saldo akhir setelah 30 hari + bonus.
        double totalUangAkhirSetelahBonus = sisaUang30Hari + bonusTakTerduga;

        // 6) Menampilkan Rangkuman Keuangan
        System.out.println("\n=== LAPORAN KEUANGAN PRIBADI ===");
        System.out.println("Nama: " + nama);
        System.out.println("Usia: " + usia + " tahun");
        System.out.printf("Uang yang dimiliki: Rp%,.0f%n", jumlahUangDimiliki); // Format mata uang
        System.out.printf("Pengeluaran harian rata-rata: Rp%,.0f%n", pengeluaranHarian);
        System.out.printf("Sisa uang dalam 30 hari: Rp%,.0f%n", sisaUang30Hari);
        System.out.printf("Estimasi bulan bertahan: %.1f bulan%n", estimasiBulanBertahan); // Format 1 desimal
        System.out.println("Status Keuangan: " + statusKeuangan);
        System.out.printf("Nilai absolut dari hutang: Rp%,.0f%n", nilaiAbsolutHutang);
        System.out.printf("Pengeluaran harian setelah pembulatan: Rp%,.0f%n", pengeluaranHarianDibulatkan);
        System.out.printf("Bonus tak terduga: Rp%,.0f%n", bonusTakTerduga);
        System.out.printf("Total uang yang dimiliki setelah 30 hari pengeluaran dan bonus: Rp%,.0f%n", totalUangAkhirSetelahBonus);

        input.close();
    }
}