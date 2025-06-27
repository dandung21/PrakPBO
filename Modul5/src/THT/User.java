package THT;

public class User {
    private String nama;
    private String idUser;

    public User(String nama, String idUser) {
        this.nama = nama;
        this.idUser = idUser;
        System.out.println("Pengguna '" + this.nama + "' dengan ID '" + this.idUser + "' telah terdaftar.");
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void pinjamBuku(Buku buku) {
        if (buku != null) {
            if (!buku.isStatusDipinjam()) {
                buku.pinjamBuku();
                System.out.println(this.nama + " berhasil meminjam buku: " + buku.getJudul());
            } else {
                System.out.println(this.nama + " tidak bisa meminjam buku '" + buku.getJudul() + "' karena sedang dipinjam.");
            }
        } else {
            System.out.println(this.nama + " mencoba meminjam buku yang tidak valid.");
        }
    }

    public void kembalikanBuku(Buku buku) {
        if (buku != null) {
            if (buku.isStatusDipinjam()) {
                buku.kembalikanBuku();
                System.out.println(this.nama + " berhasil mengembalikan buku: " + buku.getJudul());
            } else {
                System.out.println(this.nama + " tidak bisa mengembalikan buku '" + buku.getJudul() + "' karena tidak sedang dipinjam.");
            }
        } else {
            System.out.println(this.nama + " mencoba mengembalikan buku yang tidak valid.");
        }
    }
}