package THT;

import java.util.Scanner;
import java.lang.Math;

public class SistemNilaiMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== SISTEM PENGELOLAAN NILAI MAHASISWA ===");
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = input.nextLine();

        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = input.nextLine();

        System.out.print("Masukkan Usia Mahasiswa: ");
        int usia = input.nextInt();

        System.out.print("Masukkan Jumlah Mata Kuliah yang Diambil: ");
        int jumlahMataKuliah = input.nextInt();

        double totalNilai = 0;
        for (int i = 1; i <= jumlahMataKuliah; i++) {
            System.out.print("Masukkan nilai mata kuliah ke-" + i + ": ");
            double nilaiMataKuliah = input.nextDouble();
            totalNilai += nilaiMataKuliah;
        }

        input.nextLine(); 

        double rataRataNilai = 0;
        if (jumlahMataKuliah > 0) {
            rataRataNilai = totalNilai / jumlahMataKuliah;
        }
        
        double ipk = (rataRataNilai / 100.0) * 4.0;

        System.out.println("\n--- Evaluasi Akademik ---");

        boolean usiaLebihDari22 = usia > 22;
        System.out.println("Apakah usia mahasiswa lebih dari 22 tahun? " + usiaLebihDari22);

        boolean kondisiIpkBaikDanMataKuliahCukup = (ipk >= 3.5) && (jumlahMataKuliah > 4);
        System.out.println("Apakah IPK >= 3.5 DAN jumlah mata kuliah > 4? " + kondisiIpkBaikDanMataKuliahCukup);

        boolean kondisiIpkKurangAtauMataKuliahSedikit = (ipk < 2.5) || (jumlahMataKuliah < 4);
        System.out.println("Apakah IPK < 2.5 ATAU jumlah mata kuliah < 4? " + kondisiIpkKurangAtauMataKuliahSedikit);

        int nomorAntrianKonsultasi = (int) (Math.random() * 100) + 1;

        System.out.println("\n=== LAPORAN AKADEMIK MAHASISWA ===");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Usia: " + usia + " tahun");
        System.out.println("Jumlah Mata Kuliah Diambil: " + jumlahMataKuliah);
        System.out.printf("Rata-rata Nilai: %.2f%n", rataRataNilai);
        System.out.printf("IPK: %.2f%n", ipk);
        System.out.println("Nomor Antrian Konsultasi: " + nomorAntrianKonsultasi);

        String statusAkademik;
        if (ipk >= 3.5) {
            statusAkademik = "Sangat Memuaskan";
        } else if (ipk >= 3.0) {
            statusAkademik = "Memuaskan";
        } else if (ipk >= 2.5) {
            statusAkademik = "Cukup Memuaskan";
        } else {
            statusAkademik = "Perlu Perbaikan";
        }
        System.out.println("Status Akademik: " + statusAkademik);

        input.close();
    }
}