package Latihan;

abstract class PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " in default currency.");
    }

    public void processPayment(double amount, String currency) {
        System.out.println("Processing payment of " + amount + " in currency: " + currency);
    }
}

class CreditCard extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card: Paying " + amount + " in IDR.");
    }

    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("Credit Card: Paying " + amount + " in " + currency);
    }
}

class EWallet extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("E-Wallet: Paying " + amount + " in IDR.");
    }

    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("E-Wallet: Paying " + amount + " in " + currency);
    }
}

class BankTransfer extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Bank Transfer: Paying " + amount + " in IDR.");
    }

    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("Bank Transfer: Paying " + amount + " in " + currency);
    }
}

public class ATM {
    public static void main(String[] args) {
        PaymentMethod[] methods = {
            new CreditCard(),
            new EWallet(),
            new BankTransfer()
        };

        System.out.println("== Pembayaran tanpa menyebut mata uang ==");
        for (PaymentMethod method : methods) {
            method.processPayment(500000);
        }

        System.out.println("\n== Pembayaran dengan mata uang spesifik ==");
        methods[0].processPayment(200, "USD");
        methods[1].processPayment(100000, "IDR");
        methods[2].processPayment(300, "EUR");
    }
}
