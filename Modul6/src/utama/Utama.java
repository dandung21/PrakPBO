package utama;

import dosen.Dosen;
import mahasiswa.Mahasiswa;
import matakuliah.MataKuliah;



public class Utama {

    public static void tampilkanData(MataKuliah matakuliah) {
        System.out.println("-------------------------------------");
        System.out.println("Mata Kuliah: " + matakuliah.getNama());
        System.out.println("Kode MK: " + matakuliah.getKodeMK());

        System.out.print("Pengampu: ");
        if (matakuliah.getPengampu().isEmpty()) {
            System.out.println("Tidak ada pengampu.");
        } else {
            for (int i = 0; i < matakuliah.getPengampu().size(); i++) {
                System.out.print(matakuliah.getPengampu().get(i).getNama());
                if (i < matakuliah.getPengampu().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        System.out.print("Daftar Mahasiswa: ");
        if (matakuliah.getDaftarMahasiswa().isEmpty()) {
            System.out.println("Tidak ada mahasiswa.");
        } else {
            for (int i = 0; i < matakuliah.getDaftarMahasiswa().size(); i++) {
                System.out.print(matakuliah.getDaftarMahasiswa().get(i).getNama());
                if (i < matakuliah.getDaftarMahasiswa().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        // Membuat objek Dosen
        Dosen dCahya = new Dosen("Cahya", "D001");
        Dosen dTiara = new Dosen("Tiara", "D002");
        Dosen dDiana = new Dosen("Diana", "D003");
   

        // Membuat objek Mahasiswa
        Mahasiswa mKompar = new Mahasiswa("Kompar", "M001");
        Mahasiswa mBudi = new Mahasiswa("Budi", "M002");
        Mahasiswa mTiara = new Mahasiswa("Tiara", "M003");

        // Membuat objek MataKuliah
        MataKuliah mkPBO = new MataKuliah("PBO", "123");
        MataKuliah mkKompar = new MataKuliah("Kompar", "124");
        MataKuliah mkMetnum = new MataKuliah("Metnum", "125");

        // Set pengampu dan daftar mahasiswa untuk tiap mata kuliah

        // Mata Kuliah: PBO (123)
        mkPBO.addPengampu(dCahya);
        mkPBO.addMahasiswa(mKompar);

        // Mata Kuliah: Kompar (124)
        mkKompar.addPengampu(dTiara);
        mkKompar.addPengampu(dDiana);
        mkKompar.addMahasiswa(mBudi);

        // Mata Kuliah: Metnum (125)
        mkMetnum.addPengampu(dTiara);
        mkMetnum.addPengampu(dDiana);
        mkMetnum.addMahasiswa(mBudi);
        mkMetnum.addMahasiswa(mTiara);

        // Memanggil method tampilkanData untuk setiap mata kuliah
        tampilkanData(mkPBO);
        tampilkanData(mkKompar);
        tampilkanData(mkMetnum);
    }
}