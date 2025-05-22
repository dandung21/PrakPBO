package week10.Posttest;

public class DataScientist extends Employee {
    @Override
    public double calculateSalary() {
        return 9000.0;
    }

    @Override
    public double calculateSalary(boolean withBonus) {
        return withBonus ? calculateSalary() + 2500 : calculateSalary();
    }
}
