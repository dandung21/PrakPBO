package week9.Posttest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Vehicle {
    public String startEngine() {
        return "Mesin Nyala";
    }
}

class Car extends Vehicle {
    @Override
    public String startEngine() {
        return "Mesin Mobil Nyala";
    }
}

class Motorcycle extends Vehicle {
    @Override
    public String startEngine() {
        return "Mesin Motor Nyala";
    }
}

class License {
    private String licenseNumber;
    private LocalDate validUntil;

    public License(String licenseNumber) {
        this.licenseNumber = licenseNumber;
        this.validUntil = LocalDate.now().plusYears(5);
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getValidUntil() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return validUntil.format(formatter);
    }
}

class Driver {
    private String name;
    private Vehicle vehicle;
    private License license;

    public Driver(String name, Vehicle vehicle, String licenseNumber) {
        this.name = name;
        this.vehicle = vehicle;
        this.license = new License(licenseNumber);
    }

    public void showInfo() {
        System.out.println("Nama Pengemudi: " + name);
        if (vehicle instanceof Car) {
            System.out.println("Jenis Kendaraan: Mobil");
        } else if (vehicle instanceof Motorcycle) {
            System.out.println("Jenis Kendaraan: Motor");
        }
        System.out.println("Status Mesin: " + vehicle.startEngine());
        System.out.println("Nomor Lisensi: " + license.getLicenseNumber());
        System.out.println("Tanggal Berlaku Lisensi: " + license.getValidUntil());
        System.out.println("----------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Driver driver1 = new Driver("Andi", new Car(), "CAR12345");
        Driver driver2 = new Driver("Budi", new Motorcycle(), "MOTO67890");

        driver1.showInfo();
        driver2.showInfo();
    }
}