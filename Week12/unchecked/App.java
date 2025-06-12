package Week12.unchecked;

public class App {
    public static void main(String[] args) {
        int[] angka = {1,2,3};

        try{
            System.out.println(angka[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    
    try {
        int hasil = 10 / 0; 
        System.out.println("hasil: " + hasil);
    } catch (ArithmeticException e) {
        System.out.println("Tidak bisa membagi dengan nol: " + e.getMessage());
    }
}
}