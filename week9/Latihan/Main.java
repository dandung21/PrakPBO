package week9.Latihan;

import java.util.Date;

class HealthRecord {
    private String doctorName;
    private Date createdDate;

    public HealthRecord(String doctorName, Date createdDate) {
        this.doctorName = doctorName;
        this.createdDate = createdDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}

class Animal {
    protected String name;
    protected HealthRecord record;

    public Animal(String name, String doctorName) {
        this.name = name;
        this.record = new HealthRecord(doctorName, new Date());
    }

    public void makeSound() {
        System.out.println("Some generic animal sound");
    }

    public String getName() {
        return name;
    }

    public HealthRecord getHealthRecord() {
        return record;
    }
}

class Dog extends Animal {
    public Dog(String name, String doctorName) {
        super(name, doctorName);
    }

    @Override
    public void makeSound() {
        System.out.println("Guk-Guk!");
    }
}

class Cat extends Animal {
    public Cat(String name, String doctorName) {
        super(name, doctorName);
    }

    @Override
    public void makeSound() {
        System.out.println("Meong!");
    }
}

class Owner {
    private String name;
    private Animal[] pets;

    public Owner(String name, Animal[] pets) {
        this.name = name;
        this.pets = pets;
    }

    public void showPets() {
        System.out.println("Pemilik: " + name);
        for (Animal pet : pets) {
            System.out.println("Nama Hewan: " + pet.getName());
            if (pet instanceof Dog) {
                System.out.println("Jenis: Dog");
            } else if (pet instanceof Cat) {
                System.out.println("Jenis: Cat");
            } else {
                System.out.println("Jenis: Tidak diketahui");
            }

            System.out.print("Suara: ");
            pet.makeSound();

            System.out.println("Dokter: " + pet.getHealthRecord().getDoctorName());
            System.out.println("Tanggal Rekam Medis: " + pet.getHealthRecord().getCreatedDate());
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Bruno", "Dr. Rina");
        Cat cat = new Cat("Mimi", "Dr. Andi");

        Animal[] hewan = {dog, cat};

        Owner owner = new Owner("Budi", hewan);
        owner.showPets();
    }
}
