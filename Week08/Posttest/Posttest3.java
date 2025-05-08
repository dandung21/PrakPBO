package Week08.Posttest;

class Produk {
    int harga = 10000;
}

class Buku extends Produk {
    int harga = 25000;

    void bandingkanHarga() {
        System.out.println("Harga di subclass: " + harga);
        System.out.println("Harga di superclass: " + super.harga);
    }
}

public class Posttest3 {
    public static void main(String[] args) {
        Buku b = new Buku();
        b.bandingkanHarga();
    }
}