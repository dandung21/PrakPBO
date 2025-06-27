package Latihan.Posttest;

import java.text.NumberFormat;
import java.util.Locale;

public class Mobil {
    private String nomorPlat;
    private String merek;
    private double hargaSewaPerHari;
    private boolean isAvailable;

    public Mobil() {
        this("N/A", "N/A", 0.0, true);
        System.out.println("Objek Mobil default dibuat.");
    }

    public Mobil(String nomorPlat, String merek, double hargaSewaPerHari, boolean isAvailable) {
        this.nomorPlat = nomorPlat;
        this.merek = merek;
        this.hargaSewaPerHari = hargaSewaPerHari;
        this.isAvailable = isAvailable;
    }

    public String getNomorPlat() {
        return nomorPlat;
    }

    public String getMerek() {
        return merek;
    }

    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setNomorPlat(String nomorPlat) {
        this.nomorPlat = nomorPlat;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setHargaSewaPerHari(double hargaSewaPerHari) {
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Plat     : " + nomorPlat);
        System.out.println("Merek          : " + merek);
        System.out.println("Harga Sewa/Hari: " + Utility.formatMataUang(hargaSewaPerHari));
        System.out.println("Status         : " + (isAvailable ? "Tersedia" : "Tidak Tersedia"));
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}