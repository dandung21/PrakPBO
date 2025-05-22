package week10.Posttest;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
            new SoftwareEngineer(),
            new DataScientist(),
            new Intern()
        };

        System.out.println("=== Gaji Tanpa Bonus (Polymorphic) ===");
        for (Employee emp : employees) {
            System.out.println(emp.getClass().getSimpleName() + ": " + emp.calculateSalary());
        }

        System.out.println("\n=== Gaji Dengan Bonus (Langsung lewat objek) ===");
        for (Employee emp : employees) {
            // Downcast untuk akses overload method
            if (emp instanceof SoftwareEngineer) {
                System.out.println("SoftwareEngineer: " + ((SoftwareEngineer) emp).calculateSalary(true));
            } else if (emp instanceof DataScientist) {
                System.out.println("DataScientist: " + ((DataScientist) emp).calculateSalary(true));
            } else if (emp instanceof Intern) {
                System.out.println("Intern: " + ((Intern) emp).calculateSalary(true));
            }
        }
    }
}
