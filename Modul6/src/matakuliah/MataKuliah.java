package matakuliah;

import dosen.Dosen;
import mahasiswa.Mahasiswa;

import java.util.ArrayList;

public class MataKuliah { // Pastikan hanya ada SATU public class di file ini
    private String nama;
    private String KodeMK;
    private ArrayList<Dosen> pengampu;
    private ArrayList<Mahasiswa> daftarMahasiswa;

    public MataKuliah(String nama, String KodeMK) {
        this.nama = nama;
        this.KodeMK = KodeMK;
        this.pengampu = new ArrayList<>(); // Inisialisasi ArrayList kosong
        this.daftarMahasiswa = new ArrayList<>(); // Inisialisasi ArrayList kosong
    }

    public void setPengampu(ArrayList<Dosen> pengampu) {
        this.pengampu = pengampu;
    }
    
    public void addPengampu(Dosen dosen) { // Metode pembantu untuk menambah satu dosen
        if (dosen != null) {
            this.pengampu.add(dosen);
        }
    }

    public void setDaftarMahasiswa(ArrayList<Mahasiswa> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }

    public void addMahasiswa(Mahasiswa mahasiswa) { // Metode pembantu untuk menambah satu mahasiswa
        if (mahasiswa != null) {
            this.daftarMahasiswa.add(mahasiswa);
        }
    }

    public String getNama() {
        return nama;
    }

    public String getKodeMK() {
        return KodeMK;
    }

    public ArrayList<Dosen> getPengampu() {
        return pengampu;
    }

    public ArrayList<Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }
}