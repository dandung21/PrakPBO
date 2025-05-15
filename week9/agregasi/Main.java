package week9.agregasi;

import java.util.List;
import java.util.ArrayList;

class Mahasiswa{
    String nama;

    Mahasiswa(String nama){
        this.nama = nama;
    }
}

class Universitas{
    String namaUniv;
    ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    
    Universitas(String namaUniv){
        this.namaUniv = namaUniv;
    }

    void tambahMahasiswa(Mahasiswa mhs){
        daftarMahasiswa.add(mhs);
    }

    void tampilkanMahasiswa(){
        for(Mahasiswa mahasiswa : daftarMahasiswa){
            System.out.println(mahasiswa.nama);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa("Sugeng");
        Mahasiswa mhs2 = new Mahasiswa("Asep");

        Universitas uper = new Universitas ("Universitas Indonesia");
        uper.tambahMahasiswa(mhs1);
        uper.tambahMahasiswa(mhs2);
        uper.tampilkanMahasiswa();
        
        
    }
    
}