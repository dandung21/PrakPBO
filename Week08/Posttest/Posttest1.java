package Week08.Posttest;

class Bangunan{
    String nama = "Bangunan umum";
}

class GedungSekolah extends Bangunan{
    String nama = "Gedung Sekolah ABC";
    
    void tampilkaninfo() {
        System.out.println("Nilai nama milik subclass " + nama);
        System.out.println("Nilai nama milik superclass "+ super.nama);
    }
    
}


public class Posttest1 {
    public static void main(String[] args) {
        GedungSekolah g = new GedungSekolah();
        g.tampilkaninfo();
    }
}
