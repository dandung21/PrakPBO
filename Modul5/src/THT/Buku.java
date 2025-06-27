package THT;


public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private boolean statusDipinjam;
    public static int jumlahBukuTersedia;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.statusDipinjam = false;
        jumlahBukuTersedia++;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public boolean isStatusDipinjam() {
        return statusDipinjam;
    }

    protected void setStatusDipinjam(boolean statusDipinjam) {
        this.statusDipinjam = statusDipinjam;
    }

    public void pinjamBuku() {
        if (!this.statusDipinjam) {
            this.statusDipinjam = true;
            String pesan = "Buku '" + this.judul + "' berhasil dipinjam.";
            System.out.println(pesan);
        } else {
            System.out.println("Buku '" + this.judul + "' sedang tidak tersedia (sudah dipinjam).");
        }
    }

    public void kembalikanBuku() {
        if (this.statusDipinjam) {
            this.statusDipinjam = false;
            System.out.println("Buku '" + this.judul + "' berhasil dikembalikan.");
        } else {
            System.out.println("Buku '" + this.judul + "' tidak sedang dipinjam.");
        }
    }
}