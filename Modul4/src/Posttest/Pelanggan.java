package Latihan.Posttest;

public class Pelanggan {
    private String nama;
    private String nomorKTP;
    private String nomorHP;

    public Pelanggan(String nama, String nomorKTP, String nomorHP) {
        this.nama = nama;
        this.nomorKTP = nomorKTP;
        this.nomorHP = nomorHP;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorKTP() {
        return nomorKTP;
    }

    public String getNomorHP() {
        return nomorHP;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }

    public void setNomorHP(String nomorHP) {
        this.nomorHP = nomorHP;
    }

    public void tampilkanInfo() {
        System.out.println("Nama       : " + nama);
        System.out.println("Nomor KTP  : " + nomorKTP);
        System.out.println("Nomor HP   : " + nomorHP);
    }
}