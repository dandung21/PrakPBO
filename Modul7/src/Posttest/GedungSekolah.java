package Posttest;

public class GedungSekolah extends Bangunan {
    String nama = "Gedung Sekolah ABC";

    public void tampilkanInfo() {
        System.out.println("Nilai nama milik subclass: " + this.nama);
        System.out.println("Nilai nama milik superclass: " + super.nama);
    }
}