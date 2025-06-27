package Latihan;

public class Main {
    public static void main(String[] args) {
        
        Mahasiswa mahasiswa1 = new Mahasiswa("Budi Santoso", "M001", "Teknik Informatika", 3.75);

        
        Mahasiswa mahasiswa2 = new Mahasiswa("Siti Aminah", "M002", "Sistem Informasi", 2.80);

        
        System.out.println("Informasi Mahasiswa 1:");
        mahasiswa1.tampilkanInfo();

        System.out.println("\nInformasi Mahasiswa 2:");
        mahasiswa2.tampilkanInfo();

        
        System.out.println("\nStatus Kelulusan Mahasiswa 1:");
        if (mahasiswa1.cekLulus()) {
            System.out.println(mahasiswa1.nama + " dinyatakan LULUS.");
        } else {
            System.out.println(mahasiswa1.nama + " dinyatakan TIDAK LULUS.");
        }

        System.out.println("\nStatus Kelulusan Mahasiswa 2:");
        if (mahasiswa2.cekLulus()) {
            System.out.println(mahasiswa2.nama + " dinyatakan LULUS.");
        } else {
            System.out.println(mahasiswa2.nama + " dinyatakan TIDAK LULUS.");
        }
    }
}