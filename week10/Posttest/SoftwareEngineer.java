package week10.Posttest;

public class SoftwareEngineer extends Employee {
    @Override
    public double calculateSalary() {
        return 8000.0;
    }

    @Override
    public double calculateSalary(boolean withBonus) {
        return withBonus ? calculateSalary() + 2000 : calculateSalary();
    }
}
