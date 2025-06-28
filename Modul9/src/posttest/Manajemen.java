package posttest;

import java.util.ArrayList;
import java.util.List;

class Employee {
    protected String name;
    protected String employeeId;
    protected double baseSalary;

    public Employee(String name, String employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public double calculateSalary(boolean withBonus) {
        if (withBonus) {
            return baseSalary + (baseSalary * 0.10);
        } else {
            return calculateSalary();
        }
    }

    public void displayData() {
        System.out.println("Nama: " + name);
        System.out.println("ID Karyawan: " + employeeId);
        System.out.println("Gaji Dasar: " + calculateSalary());
    }
}

class SoftwareEngineer extends Employee {
    public SoftwareEngineer(String name, String employeeId) {
        super(name, employeeId, 8000.0);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public double calculateSalary(boolean withBonus) {
        if (withBonus) {
            return baseSalary + (baseSalary * 0.20);
        } else {
            return calculateSalary();
        }
    }

    @Override
    public void displayData() {
        System.out.println("--- Software Engineer ---");
        super.displayData();
    }
}

class DataScientist extends Employee {
    public DataScientist(String name, String employeeId) {
        super(name, employeeId, 9500.0);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public double calculateSalary(boolean withBonus) {
        if (withBonus) {
            return baseSalary + (baseSalary * 0.25);
        } else {
            return calculateSalary();
        }
    }

    @Override
    public void displayData() {
        System.out.println("--- Data Scientist ---");
        super.displayData();
    }
}

class Intern extends Employee {
    public Intern(String name, String employeeId) {
        super(name, employeeId, 3000.0);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public double calculateSalary(boolean withBonus) {
        if (withBonus) {
            return baseSalary + (baseSalary * 0.05);
        } else {
            return calculateSalary();
        }
    }

    @Override
    public void displayData() {
        System.out.println("--- Intern ---");
        super.displayData();
    }
}

public class Manajemen {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new SoftwareEngineer("Alice Smith", "SE001"));
        employees.add(new DataScientist("Bob Johnson", "DS002"));
        employees.add(new Intern("Charlie Brown", "IN003"));
        employees.add(new SoftwareEngineer("Diana Prince", "SE004"));

        System.out.println("=== Data Karyawan dan Gaji Dasar (Polymorphism) ===");
        for (Employee emp : employees) {
            emp.displayData();
            System.out.println("Gaji Bulanan Dasar: $" + emp.calculateSalary());
            System.out.println("---------------------------------");
        }

        System.out.println("\n=== Gaji dengan Bonus (Panggilan Langsung Overload) ===");
        for (Employee emp : employees) {
            System.out.println("Nama: " + emp.name);
            System.out.println("Gaji dengan Bonus: $" + emp.calculateSalary(true));
            System.out.println("---------------------------------");
        }
    }
}