package week9;

class Animal {

}

class Mammal extends Animal {

}

class Dog extends Mammal {

}

public class Main{

    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Mammal mammal1 = new Mammal();
        Dog dog1 = new Dog();
        
        System.out.println(mammal1 instanceof Animal);
        System.out.println(dog1 instanceof Animal);
        System.out.println(dog1 instanceof Mammal);
    }
}
