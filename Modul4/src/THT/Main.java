package Latihan.THT;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== MANAJEMEN PRODUK =====");
        Produk pensil = new Produk("P001", "Pensil 2B", 3500.0, 50);
        Produk bukuTulis = new Produk("B002", "Buku Tulis A5", 7000.0, 30);
        Produk penghapus = new Produk("H003", "Penghapus Faber", 2000.0, 10);

        pensil.tampilkanInfoProduk();
        bukuTulis.tampilkanInfoProduk();
        penghapus.tampilkanInfoProduk();

        System.out.println("\n--- Memperbarui Stok Pensil ---");
        pensil.setStok(60);
        pensil.tampilkanInfoProduk();

        System.out.println("\n===== MANAJEMEN PELANGGAN =====");
        Pelanggan pelanggan1 = new Pelanggan("CST001", "Budi Santoso", "budi.s@example.com", 15000.0);
        Pelanggan pelanggan2 = new Pelanggan("CST002", "Siti Aminah", "siti.a@example.com", 5000.0);

        pelanggan1.tampilkanInfoPelanggan();
        pelanggan2.tampilkanInfoPelanggan();

        System.out.println("\n--- Top-up Saldo Pelanggan 1 ---");
        pelanggan1.topUpSaldo(10000.0);
        pelanggan1.tampilkanInfoPelanggan();

        System.out.println("\n===== MANAJEMEN TRANSAKSI =====");

        Transaksi tr1 = new Transaksi("TRX001", pelanggan1, pensil, 3);
        tr1.prosesTransaksi();
        System.out.println("\n--- Info Terbaru Setelah Transaksi TRX001 ---");
        pelanggan1.tampilkanInfoPelanggan();
        pensil.tampilkanInfoProduk();

        Transaksi tr2 = new Transaksi("TRX002", pelanggan2, bukuTulis, 5);
        tr2.prosesTransaksi();
        System.out.println("\n--- Info Terbaru Setelah Transaksi TRX002 (Gagal) ---");
        pelanggan2.tampilkanInfoPelanggan();
        bukuTulis.tampilkanInfoProduk();

        Transaksi tr3 = new Transaksi("TRX003", pelanggan1, penghapus, 15);
        tr3.prosesTransaksi();
        System.out.println("\n--- Info Terbaru Setelah Transaksi TRX003 (Gagal) ---");
        pelanggan1.tampilkanInfoPelanggan();
        penghapus.tampilkanInfoProduk();

        System.out.println("\n--- Top-up Saldo Pelanggan 2 untuk mencoba lagi ---");
        pelanggan2.topUpSaldo(50000.0);
        Transaksi tr4 = new Transaksi("TRX004", pelanggan2, penghapus, 8);
        tr4.prosesTransaksi();
        System.out.println("\n--- Info Terbaru Setelah Transaksi TRX004 ---");
        pelanggan2.tampilkanInfoPelanggan();
        penghapus.tampilkanInfoProduk();
    }
}