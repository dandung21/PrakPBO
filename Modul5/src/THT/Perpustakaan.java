package THT;

import java.util.ArrayList;

public class Perpustakaan {
    private ArrayList<Buku> koleksiBuku; 
    
    private String namaPerpustakaan;

    public Perpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;
        this.koleksiBuku = new ArrayList<>();
        System.out.println("Perpustakaan '" + this.namaPerpustakaan + "' telah dibuat.");
    }

    public String getNamaPerpustakaan() {
        return namaPerpustakaan;
    }
    
    public ArrayList<Buku> getKoleksiBuku() {
        return koleksiBuku;
    }

    public void tambahBuku(Buku buku) {
        if (buku != null) {
            koleksiBuku.add(buku);
            String infoPenambahan = "Buku '" + buku.getJudul() + "' berhasil ditambahkan ke perpustakaan.";
            System.out.println(infoPenambahan);
        } else {
            System.out.println("Tidak dapat menambahkan buku kosong.");
        }
    }

    public void tampilkanBuku() {
        System.out.println("\n--- Koleksi Buku di " + namaPerpustakaan + " ---");
        if (koleksiBuku.isEmpty()) {
            System.out.println("Tidak ada buku dalam koleksi saat ini.");
            return;
        }
        for (int i = 0; i < koleksiBuku.size(); i++) {
            Buku buku = koleksiBuku.get(i);
            String status = buku.isStatusDipinjam() ? "Dipinjam" : "Tersedia";
            System.out.println((i + 1) + ". Judul: " + buku.getJudul() +
                               ", Penulis: " + buku.getPenulis() +
                               ", Tahun: " + buku.getTahunTerbit() +
                               ", Status: " + status);
        }
        System.out.println("Total buku di perpustakaan: " + koleksiBuku.size());
        System.out.println("Total buku yang tersedia (static): " + Buku.jumlahBukuTersedia);
    }
}