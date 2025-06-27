package Posttest;

public class Buku extends Produk {
    int harga = 25000;

    public void bandingkanHarga() {
        System.out.println("Harga di subclass (Buku): " + this.harga);
        System.out.println("Harga di superclass (Produk): " + super.harga);
    }
}