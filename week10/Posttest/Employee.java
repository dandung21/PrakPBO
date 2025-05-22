package week10.Posttest;

public class Employee {
    public double calculateSalary() {
        return 0.0;
    }

    public double calculateSalary(boolean withBonus) {
        return withBonus ? calculateSalary() + 1000 : calculateSalary();
    }
}
