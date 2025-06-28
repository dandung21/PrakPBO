package Week08.Posttest;

import java.time.LocalDate;

// Superclass Vehicle
class Vehicle {
    public void startEngine() {
        System.out.println("Mesin Nyala");
    }
}

// Subclass Car
class Car extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Mesin Mobil Nyala");
    }
}

// Subclass Motorcycle
class Motorcycle extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Mesin Motor Nyala");
    }
}

// Class License (Komposisi)
class License {
    private String licenseNumber;
    private LocalDate expirationDate;

    public License(String licenseNumber) {
        this.licenseNumber = licenseNumber;
        // Lisensi berlaku 5 tahun sejak dibuat
        this.expirationDate = LocalDate.now().plusYears(5);
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}

// Class Driver (Agregasi dengan Vehicle, Komposisi dengan License)
class Driver {
    private String name;
    private Vehicle vehicle; // Agregasi (HAS-A)
    private License license; // Komposisi

    public Driver(String name, Vehicle vehicle, String licenseNumber) {
        this.name = name;
        this.vehicle = vehicle;
        // Setiap Driver secara otomatis membuat objek License
        this.license = new License(licenseNumber);
    }

    public String getName() {
        return name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public License getLicense() {
        return license;
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat objek kendaraan
        Car myCar = new Car();
        Motorcycle myMotorcycle = new Motorcycle();

        // Membuat objek Driver dengan kendaraan berbeda
        Driver driver1 = new Driver("Budi Santoso", myCar, "L001-C4R");
        Driver driver2 = new Driver("Ani Rahayu", myMotorcycle, "L002-M0T0");

        // Menampilkan informasi untuk Driver 1
        System.out.println("--- Informasi Pengemudi 1 ---");
        System.out.println("Nama Pengemudi: " + driver1.getName());

        // Menggunakan instanceof untuk menampilkan jenis kendaraan
        if (driver1.getVehicle() instanceof Car) {
            System.out.println("Jenis Kendaraan: Mobil");
        } else if (driver1.getVehicle() instanceof Motorcycle) {
            System.out.println("Jenis Kendaraan: Motor");
        } else {
            System.out.println("Jenis Kendaraan: Kendaraan Umum");
        }

        System.out.print("Status Mesin: ");
        driver1.getVehicle().startEngine(); // Memanggil method startEngine() yang telah dioverride
        System.out.println("Nomor Lisensi: " + driver1.getLicense().getLicenseNumber());
        System.out.println("Tanggal Kadaluarsa Lisensi: " + driver1.getLicense().getExpirationDate());
        System.out.println();

        // Menampilkan informasi untuk Driver 2
        System.out.println("--- Informasi Pengemudi 2 ---");
        System.out.println("Nama Pengemudi: " + driver2.getName());

        // Menggunakan instanceof untuk menampilkan jenis kendaraan
        if (driver2.getVehicle() instanceof Car) {
            System.out.println("Jenis Kendaraan: Mobil");
        } else if (driver2.getVehicle() instanceof Motorcycle) {
            System.out.println("Jenis Kendaraan: Motor");
        } else {
            System.out.println("Jenis Kendaraan: Kendaraan Umum");
        }

        System.out.print("Status Mesin: ");
        driver2.getVehicle().startEngine(); // Memanggil method startEngine() yang telah dioverride
        System.out.println("Nomor Lisensi: " + driver2.getLicense().getLicenseNumber());
        System.out.println("Tanggal Kadaluarsa Lisensi: " + driver2.getLicense().getExpirationDate());
    }
}