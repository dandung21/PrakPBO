package THT;

import java.text.NumberFormat;
import java.util.Locale;

class Transportasi {
    private String nama;
    private int jumlahKursi;
    private String tujuan;
    protected double hargaDefault = 100000.0;

    public Transportasi(String nama, int jumlahKursi, String tujuan) {
        this.nama = nama;
        this.jumlahKursi = jumlahKursi;
        this.tujuan = tujuan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public double hitungHargaTiket() {
        return hargaDefault;
    }

    public double hitungHargaTiket(String kelasLayanan) {
        return hitungHargaTiket();
    }

    public void tampilkanInfo() {
        System.out.println("Nama Transportasi: " + nama);
        System.out.println("Jumlah Kursi: " + jumlahKursi);
        System.out.println("Tujuan: " + tujuan);
    }
}

class Bus extends Transportasi {
    public Bus(String nama, int jumlahKursi, String tujuan) {
        super(nama, jumlahKursi, tujuan);
    }

    @Override
    public double hitungHargaTiket() {
        return super.hitungHargaTiket() * 1.10; // Tambah 10% dari default
    }

    @Override
    public double hitungHargaTiket(String kelasLayanan) {
        double hargaDasarBus = hitungHargaTiket();
        switch (kelasLayanan.toLowerCase()) {
            case "ekonomi":
                return hargaDasarBus; // +0%
            case "bisnis":
                return hargaDasarBus * 1.25; // +25%
            case "vip":
                return hargaDasarBus * 1.50; // +50%
            default:
                System.out.println("Kelas layanan tidak dikenal, menggunakan harga default.");
                return hargaDasarBus;
        }
    }
}

class Kereta extends Transportasi {
    public Kereta(String nama, int jumlahKursi, String tujuan) {
        super(nama, jumlahKursi, tujuan);
    }

    @Override
    public double hitungHargaTiket() {
        return super.hitungHargaTiket() * 1.20; // Tambah 20% dari default
    }

    @Override
    public double hitungHargaTiket(String kelasLayanan) {
        double hargaDasarKereta = hitungHargaTiket();
        switch (kelasLayanan.toLowerCase()) {
            case "ekonomi":
                return hargaDasarKereta; // +0%
            case "bisnis":
                return hargaDasarKereta * 1.25; // +25%
            case "vip":
                return hargaDasarKereta * 1.50; // +50%
            default:
                System.out.println("Kelas layanan tidak dikenal, menggunakan harga default.");
                return hargaDasarKereta;
        }
    }
}

class Pesawat extends Transportasi {
    public Pesawat(String nama, int jumlahKursi, String tujuan) {
        super(nama, jumlahKursi, tujuan);
    }

    @Override
    public double hitungHargaTiket() {
        return super.hitungHargaTiket() * 1.50; // Tambah 50% dari default
    }

    @Override
    public double hitungHargaTiket(String kelasLayanan) {
        double hargaDasarPesawat = hitungHargaTiket();
        switch (kelasLayanan.toLowerCase()) {
            case "ekonomi":
                return hargaDasarPesawat; // +0%
            case "bisnis":
                return hargaDasarPesawat * 1.25; // +25%
            case "vip":
                return hargaDasarPesawat * 1.50; // +50%
            default:
                System.out.println("Kelas layanan tidak dikenal, menggunakan harga default.");
                return hargaDasarPesawat;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NumberFormat currencyFormatter = NumberFormat.getNumberInstance(Locale.US);
        currencyFormatter.setMinimumFractionDigits(1);
        currencyFormatter.setMaximumFractionDigits(1);

        Transportasi[] daftarTransportasi = new Transportasi[3];
        daftarTransportasi[0] = new Bus("Bus Harapan Jaya", 40, "Bandung");
        daftarTransportasi[1] = new Kereta("Kereta Api Senja", 60, "Surabaya");
        daftarTransportasi[2] = new Pesawat("Garuda Indonesia", 150, "Medan");

        for (Transportasi t : daftarTransportasi) {
            String namaTransportasi = t.getNama().split(" ")[0]; // Ambil nama pertama (Bus, Kereta, Pesawat)
            System.out.println(namaTransportasi + " ke " + t.getTujuan() + " - Harga tiket (default): " + currencyFormatter.format(t.hitungHargaTiket()));

            // Memanggil method overload secara langsung dari objek spesifik
            if (t instanceof Bus) {
                Bus bus = (Bus) t;
                System.out.println(namaTransportasi + " ke " + bus.getTujuan() + " - Harga tiket (Bisnis): " + currencyFormatter.format(bus.hitungHargaTiket("bisnis")));
            } else if (t instanceof Kereta) {
                Kereta kereta = (Kereta) t;
                System.out.println(namaTransportasi + " ke " + kereta.getTujuan() + " - Harga tiket (VIP): " + currencyFormatter.format(kereta.hitungHargaTiket("vip")));
            } else if (t instanceof Pesawat) {
                Pesawat pesawat = (Pesawat) t;
                System.out.println(namaTransportasi + " ke " + pesawat.getTujuan() + " - Harga tiket (Ekonomi): " + currencyFormatter.format(pesawat.hitungHargaTiket("ekonomi")));
            }
            System.out.println();
        }
    }
}