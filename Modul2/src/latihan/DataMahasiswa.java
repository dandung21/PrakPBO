package latihan;

import java.util.Scanner;

public class DataMahasiswa { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Nama Anda: ");
        String nama = input.nextLine();

        System.out.print("Masukkan NIM Anda: ");
        String nim = input.nextLine();

        System.out.print("Masukkan Usia Anda: ");
        int usia = input.nextInt();

        System.out.print("Masukkan Tinggi Badan Anda (cm): ");
        double tinggiBadan = input.nextDouble();

        System.out.println("\n--- Informasi Mahasiswa ---");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Usia: " + usia + " tahun");
        System.out.println("Tinggi Badan: " + tinggiBadan + " cm");

        // ... sisa kode Anda
        input.close();
    }
}