package Week08.Posttest;

class Orang {
    Orang() {
        System.out.println("Orang dibuat");
    }
}

class Dosen extends Orang {
    Dosen() {
        super(); // Panggil constructor Orang
        System.out.println("Dosen dibuat");
    }
}

public class Posttest2 {
    public static void main(String[] args) {
        Dosen d = new Dosen();
    }
}