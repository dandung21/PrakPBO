package Latihan;

public class Kucing extends Hewan {
    String Suara = "Meong"; 

    public void tampilkanSuara() {
        System.out.println("Suara milik kelas Kucing: " + this.suara); // Mengakses suara di kelas Kucing
        System.out.println("Suara milik kelas Hewan: " + super.suara); // Mengakses suara di kelas Hewan (superclass)
    }
}