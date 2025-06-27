package Latihan;

public class Mahasiswa {
    
    String nama;
    String nim;
    String jurusan;
    double ipk;

    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }


    public void tampilkanInfo() {
        System.out.println("--- Informasi Mahasiswa ---");
        System.out.println("Nama    : " + nama);
        System.out.println("NIM     : " + nim);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("IPK     : " + ipk);
        System.out.println("---------------------------");
    }


    public boolean cekLulus() {
        return ipk >= 3.0;
    }
}