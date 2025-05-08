package Week08;

class Kendaraan { // Super Class / Parent Class
    String merek = "Ferrari";

    Kendaraan() {
        System.out.println("ini constructor parent" );
    }
    void jalan() {
        System.out.println("Kendaraan sedang berjalan");
    }

}

class Mobil extends Kendaraan { // Sub Class / Child Class
    String merek = "Toyota";

    Mobil(){
        super();
        System.out.println("ini constructor child");
    }
    void printInfo(){
        System.out.println("Merek mobil child " + merek);
        System.out.println("Merek mobil parent " + super.merek);
        jalan();
    }
    
    void klakson(String merek) {
        System.out.println("Mobil " + super.merek + " Klakson");
    }
}

public class main {
    
    public static void main (String[] args) {
        Mobil Jazz = new Mobil();
        // jazz.jalan();
        Jazz.printInfo();
        Jazz.klakson("Avanza");
    }
}
