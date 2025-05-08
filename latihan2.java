

class Kendaraan {
    Kendaraan() {
        System.out.println("Konstruktor Kendaraan dipanggil");
    }
}

class Mobil extends Kendaraan {
    Mobil() {
        super();  // Memanggil konstruktor dari superclass (Kendaraan)
        System.out.println("Konstruktor Mobil dipanggil");
    }
}

public class latihan2 {
    public static void main(String[] args) {
        Mobil mobil = new Mobil();
    }
}