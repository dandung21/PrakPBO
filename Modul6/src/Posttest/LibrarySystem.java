package Posttest;

import java.util.ArrayList;

public class LibrarySystem {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        System.out.println("Sistem Perpustakaan telah diinisialisasi.");
    }

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
            System.out.println("Buku '" + book.getTitle() + "' berhasil ditambahkan.");
        } else {
            System.out.println("Tidak dapat menambahkan buku null.");
        }
    }

    public void addMember(Member member) {
        if (member != null) {
            members.add(member);
            System.out.println("Anggota '" + member.getName() + "' dengan ID '" + member.getMemberId() + "' berhasil ditambahkan.");
        } else {
            System.out.println("Tidak dapat menambahkan anggota null.");
        }
    }

    public void displayBooks() {
        System.out.println("\n--- Daftar Buku ---");
        if (books.isEmpty()) {
            System.out.println("Belum ada buku dalam sistem.");
            return;
        }
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public void displayMembers() {
        System.out.println("\n--- Daftar Anggota ---");
        if (members.isEmpty()) {
            System.out.println("Belum ada anggota dalam sistem.");
            return;
        }
        for (Member member : members) {
            System.out.println(member.toString());
        }
    }

    public static void main(String[] args) {
        LibrarySystem myLibrary = new LibrarySystem();

        System.out.println("\nMenambahkan Buku:");
        Book book1 = new Book("Algoritma Pemrograman", "Rinaldi Munir", 2018);
        Book book2 = new Book("Dasar-Dasar Java", "Abdul Kadir", 2020);
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(new Book("Struktur Data", "Rosa A.S.", 2019));

        System.out.println("\nMenambahkan Anggota:");
        Member member1 = new Member("Budi Santoso", "M001");
        Member member2 = new Member("Citra Dewi", "M002");
        myLibrary.addMember(member1);
        myLibrary.addMember(member2);
        myLibrary.addMember(new Member("Dedi Kusuma", "M003"));

        myLibrary.displayBooks();
        myLibrary.displayMembers();
    }
}