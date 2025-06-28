package Week12.error;

public class Main {
    public static void main(String[] args) {
        try {
            long[] data = new long[integer.MAX_VALUE];
        }catch (OutOfMemoryError e) {
            System.out.println("Memori tiidak cukup: " + e.getMessage());
        }
    
}
