package THT;

import librarysystem.Buku;
import librarysystem.Perpustakaan;
import librarysystem.User;

public class Main {
    public static void main(String[] args) {
        Perpustakaan perpustakaanKota = new Perpustakaan("Perpustakaan Kota");

        Buku buku1 = new Buku("Pemrograman Java", "Budi Santoso", 2023);
        Buku buku2 = new Buku("Algoritma Data", "Citra Dewi", 2022);
        Buku buku3 = new Buku("Sejarah Dunia", "Agus Salim", 2020);
        Buku buku4 = new Buku("Fisika Kuantum", "Dewi Puspita", 2021);
        
        System.out.println("\nTotal buku yang dibuat (melalui static variable): " + Buku.jumlahBukuTersedia);

        perpustakaanKota.tambahBuku(buku1);
        perpustakaanKota.tambahBuku(buku2);
        perpustakaanKota.tambahBuku(buku3);
        perpustakaanKota.tambahBuku(buku4);

        perpustakaanKota.tampilkanBuku();

        User user1 = new User("Alice", "U001");
        User user2 = new User("Bob", "U002");

        System.out.println("\n--- Simulasi Peminjaman dan Pengembalian ---");

        user1.pinjamBuku(buku1);
        perpustakaanKota.tampilkanBuku();

        user2.pinjamBuku(buku1);

        user2.pinjamBuku(buku2);
        perpustakaanKota.tampilkanBuku();

        user1.kembalikanBuku(buku1);
        perpustakaanKota.tampilkanBuku();

        user2.kembalikanBuku(buku2);
        perpustakaanKota.tampilkanBuku();
        
        user1.kembalikanBuku(buku3);
    }
}