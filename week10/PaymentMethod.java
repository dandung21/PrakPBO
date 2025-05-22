package week10;

public class PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " in default currency.");
    }

    public void processPayment(double amount, String currency) {
        System.out.println("Processing payment of " + amount + " in currency: " + currency);
    }
}
