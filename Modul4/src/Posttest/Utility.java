package Latihan.Posttest;

import java.text.NumberFormat;
import java.util.Locale;

public class Utility {

    public static double hitungDiskon(double totalBiayaDasar, int durasiSewaHari) {
        if (durasiSewaHari > 5) {
            System.out.println("Selamat! Anda mendapatkan diskon 10% karena menyewa lebih dari 5 hari.");
            return totalBiayaDasar * 0.90;
        } else {
            return totalBiayaDasar;
        }
    }

    public static String formatMataUang(double amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return currencyFormat.format(amount);
    }
}