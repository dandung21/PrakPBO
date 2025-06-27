package Latihan.Posttest;

import java.text.NumberFormat;
import java.util.Locale;

import java.text.NumberFormat;
import java.util.Locale;

public class Sewa {
    private Pelanggan pelanggan;
    private Mobil mobil;
    private int durasiSewaHari;
    private double totalBiaya;
    private boolean transaksiBerhasil;

    public Sewa(Pelanggan pelanggan, Mobil mobil, int durasiSewaHari) {
        this.pelanggan = pelanggan;
        this.mobil = mobil;
        this.durasiSewaHari = durasiSewaHari;
        this.totalBiaya = 0.0;
        this.transaksiBerhasil = false;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public int getDurasiSewaHari() {
        return durasiSewaHari;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public boolean isTransaksiBerhasil() {
        return transaksiBerhasil;
    }

    public void prosesPenyewaan() {
        if (mobil.isAvailable()) {
            double biayaDasar = mobil.getHargaSewaPerHari() * durasiSewaHari;
            this.totalBiaya = Utility.hitungDiskon(biayaDasar, durasiSewaHari);
            mobil.setAvailable(false);
            this.transaksiBerhasil = true;
            System.out.println("\n--- Proses Penyewaan Berhasil ---");
            tampilkanStruk();
        } else {
            this.transaksiBerhasil = false;
            System.out.println("\n--- Transaksi Gagal ---");
            System.out.println("Maaf, mobil " + mobil.getMerek() + " (" + mobil.getNomorPlat() + ") tidak tersedia.");
        }
    }

    public void tampilkanStruk() {
        System.out.println("\n========== STRUK PENYEWAAN ==========");
        System.out.println(">> Informasi Pelanggan:");
        pelanggan.tampilkanInfo();
        System.out.println("\n>> Informasi Mobil Disewa:");
        mobil.tampilkanInfo();
        System.out.println("-------------------------------------");
        System.out.println("Lama Sewa      : " + durasiSewaHari + " hari");
        System.out.println("Total Biaya    : " + Utility.formatMataUang(totalBiaya));
        System.out.println("Status Transaksi: " + (transaksiBerhasil ? "Berhasil" : "Gagal"));
        System.out.println("=====================================");
    }
}