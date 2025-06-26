package latihan;

import java.util.Scanner;

public class VokalAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan sebuah kalimat: ");
        String sentence = scanner.nextLine();

        int vowelCount = 0;
        // Menghitung jumlah huruf vokal menggunakan if-else
        for (char character : sentence.toLowerCase().toCharArray()) {
            if (character == 'a' || character == 'i' || character == 'u' || character == 'e' || character == 'o') {
                vowelCount++;
            }
        }

        System.out.println("Jumlah huruf vokal: " + vowelCount);

        // Menentukan apakah jumlah huruf vokal ganjil atau genap menggunakan switch-case
        switch (vowelCount % 2) {
            case 0:
                System.out.println("Jumlah vokal genap");
                break;
            case 1:
                System.out.println("Jumlah vokal ganjil");
                break;
            default:
                // Ini tidak akan tercapai untuk bilangan bulat positif, tapi baik untuk praktik yang baik
                System.out.println("Terjadi kesalahan.");
                break;
        }

        System.out.print("Karakter dalam kalimat secara terbalik: ");
        // Menampilkan setiap karakter dalam string secara terbalik menggunakan foreach
        char[] charArray = sentence.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            System.out.print(charArray[i]);
        }
        System.out.println(); // Untuk baris baru setelah menampilkan karakter terbalik

        scanner.close();
    }
}