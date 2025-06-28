package Week12.Latihan;
import java.util.Scanner;

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

class InvalidLoanDurationException extends Exception {
    public InvalidLoanDurationException(String message) {
        super(message);
    }
}

public class Main {
    static String[] validBookIDs = {"B001", "B002", "B003"};

    public static void validateBookID(String bookID) throws BookNotFoundException {
        boolean found = false;
        for (String id : validBookIDs) {
            if (id.equalsIgnoreCase(bookID)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new BookNotFoundException("ID buku tidak ditemukan dalam sistem.");
        }
    }

    public static void validateLoanDuration(int days) throws InvalidLoanDurationException {
        if (days < 1 || days > 14) {
            throw new InvalidLoanDurationException("Lama peminjaman harus antara 1 - 14 hari.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan nama Anda: ");
            String name = scanner.nextLine();

            
            System.out.print("Masukkan ID buku: ");
            String bookID = scanner.nextLine();
            validateBookID(bookID); 

            
            System.out.print("Masukkan lama peminjaman (hari): ");
            int days = scanner.nextInt();
            validateLoanDuration(days); 

            System.out.println("Peminjaman berhasil untuk " + name + " selama " + days + " hari.");

        } catch (BookNotFoundException | InvalidLoanDurationException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input. Pastikan format data benar.");
        } finally {
            scanner.close();
            System.out.println("Program selesai.");
        }
    }
}
