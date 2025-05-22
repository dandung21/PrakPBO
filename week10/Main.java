package week10;

public class Main {
    public static void main(String[] args) {
        PaymentMethod[] methods = {
            new CreditCard(),
            new EWallet(),
            new BankTransfer()
        };

        System.out.println("=== Pembayaran Default Currency ===");
        for (PaymentMethod method : methods) {
            method.processPayment(50000);
        }

        System.out.println("\n=== Pembayaran dengan Mata Uang Spesifik ===");
        for (PaymentMethod method : methods) {
            method.processPayment(75000, "USD");
        }
    }
}
