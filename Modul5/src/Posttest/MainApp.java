package Posttest;

class Person {
    private String name;
    private int age;

    public Person(String n, int a) {
        this.name = n; // Menggunakan 'this' untuk merujuk ke atribut kelas
        this.age = a;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Employee extends Person {
    private double salary;

    public Employee(String n, int a, double s) {
        super(n, a); // Memanggil konstruktor kelas induk (Person)
        this.salary = s;
    }

    public void showSalary() {
        System.out.println("Salary: " + salary); // Menghapus koma yang salah di akhir baris
    }

    @Override // Anotasi opsional untuk menunjukkan bahwa metode ini meng-override metode induk
    public void display() {
        super.display(); // Memanggil metode display() dari kelas Person
        showSalary();    // Memanggil metode showSalary() dari kelas Employee
    }
}

public class MainApp {
    public static void main(String[] args) {
        
        
        Employee emp = new Employee("Alice", 25, 5000.00); 
        emp.display();
    }
}