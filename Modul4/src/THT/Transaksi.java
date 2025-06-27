package Latihan.THT;

public class Transaksi {
    private String idTransaksi;
    private Pelanggan pelanggan;
    private Produk produk;
    private int jumlahBeli;
    private double totalHarga;

    public Transaksi(String idTransaksi, Pelanggan pelanggan, Produk produk, int jumlahBeli) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.produk = produk;
        this.jumlahBeli = jumlahBeli;
        this.totalHarga = produk.getHarga() * jumlahBeli;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Produk getProduk() {
        return produk;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public boolean prosesTransaksi() {
        System.out.println("\n--- Memproses Transaksi " + idTransaksi + " ---");
        if (pelanggan.getSaldo() < totalHarga) {
            System.out.println("Transaksi GAGAL: Saldo pelanggan tidak mencukupi.");
            return false;
        }

        if (produk.getStok() < jumlahBeli) {
            System.out.println("Transaksi GAGAL: Stok produk " + produk.getNamaProduk() + " tidak tersedia atau tidak mencukupi.");
            return false;
        }

        if (pelanggan.kurangiSaldo(totalHarga) && produk.kurangiStok(jumlahBeli)) {
            System.out.println("Transaksi BERHASIL!");
            tampilkanDetailTransaksi();
            return true;
        } else {
            System.out.println("Transaksi GAGAL: Terjadi masalah saat mengurangi saldo atau stok.");
            return false;
        }
    }

    public void tampilkanDetailTransaksi() {
        System.out.println("\n--- Detail Transaksi " + idTransaksi + " ---");
        System.out.println("Pelanggan   : " + pelanggan.getNama() + " (ID: " + pelanggan.getIdPelanggan() + ")");
        System.out.println("Produk      : " + produk.getNamaProduk() + " (Kode: " + produk.getKodeProduk() + ")");
        System.out.println("Jumlah Beli : " + jumlahBeli);
        System.out.println("Total Harga : Rp" + String.format("%.2f", totalHarga));
        System.out.println("----------------------------------");
    }
}