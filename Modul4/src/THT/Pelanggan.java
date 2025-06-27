package Latihan.THT;

public class Pelanggan {
    private String idPelanggan;
    private String nama;
    private String email;
    private double saldo;

    public Pelanggan(String idPelanggan, String nama, String email, double saldo) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.email = email;
        this.saldo = saldo;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void tampilkanInfoPelanggan() {
        System.out.println("--- Informasi Pelanggan ---");
        System.out.println("ID Pelanggan: " + idPelanggan);
        System.out.println("Nama        : " + nama);
        System.out.println("Email       : " + email);
        System.out.println("Saldo Akun  : Rp" + String.format("%.2f", saldo));
        System.out.println("---------------------------");
    }

    public void topUpSaldo(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            System.out.println("Top-up saldo sebesar Rp" + String.format("%.2f", jumlah) + " berhasil. Saldo baru: Rp" + String.format("%.2f", saldo));
        } else {
            System.out.println("Jumlah top-up harus positif.");
        }
    }

    public boolean kurangiSaldo(double jumlah) {
        if (this.saldo >= jumlah) {
            this.saldo -= jumlah;
            return true;
        } else {
            System.out.println("Saldo tidak mencukupi. Saldo saat ini: Rp" + String.format("%.2f", saldo));
            return false;
        }
    }
}