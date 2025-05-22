package week10.Posttest;

public class Intern extends Employee {
    @Override
    public double calculateSalary() {
        return 3000.0;
    }

    @Override
    public double calculateSalary(boolean withBonus) {
        return withBonus ? calculateSalary() + 500 : calculateSalary();
    }
}
