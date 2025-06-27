package Latihan.Posttest;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Inisialisasi Mobil ---");
        Mobil mobilA = new Mobil("B 1234 ABC", "Honda Civic", 350000.0, true);
        Mobil mobilB = new Mobil("D 5678 XYZ", "Toyota Avanza", 250000.0, true);
        Mobil mobilC = new Mobil("F 9012 PQR", "Mitsubishi Pajero", 600000.0, true);
        Mobil mobilDefault = new Mobil();

        System.out.println("\n--- Informasi Mobil yang Tersedia ---");
        System.out.println("Mobil A:");
        mobilA.tampilkanInfo();
        System.out.println("\nMobil B:");
        mobilB.tampilkanInfo();
        System.out.println("\nMobil C:");
        mobilC.tampilkanInfo();
        System.out.println("\nMobil Default:");
        mobilDefault.tampilkanInfo();


        System.out.println("\n--- Inisialisasi Pelanggan ---");
        Pelanggan pelanggan1 = new Pelanggan("Andi Wijaya", "31750xxxxxxxxx", "081234567890");
        Pelanggan pelanggan2 = new Pelanggan("Budi Lestari", "31750yyyyyyyyy", "087654321098");

        System.out.println("\n--- Informasi Pelanggan ---");
        System.out.println("Pelanggan 1:");
        pelanggan1.tampilkanInfo();
        System.out.println("\nPelanggan 2:");
        pelanggan2.tampilkanInfo();

        System.out.println("\n===== Skenario 1: Penyewaan Mobil A oleh Andi (3 hari) =====");
        Sewa sewa1 = new Sewa(pelanggan1, mobilA, 3);
        sewa1.prosesPenyewaan();

        System.out.println("\n===== Skenario 2: Penyewaan Mobil B oleh Budi (7 hari) =====");
        Sewa sewa2 = new Sewa(pelanggan2, mobilB, 7);
        sewa2.prosesPenyewaan();

        System.out.println("\n===== Skenario 3: Penyewaan Mobil A lagi oleh Budi (2 hari) =====");
        Sewa sewa3 = new Sewa(pelanggan2, mobilA, 2);
        sewa3.prosesPenyewaan();

        System.out.println("\n--- Daftar Mobil dan Status Terkini ---");
        System.out.println("Mobil A:");
        mobilA.tampilkanInfo();
        System.out.println("\nMobil B:");
        mobilB.tampilkanInfo();
        System.out.println("\nMobil C:");
        mobilC.tampilkanInfo();
        System.out.println("\nMobil Default:");
        mobilDefault.tampilkanInfo();
    }
}