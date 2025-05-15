package week9;

class Animal {
    void eat() {
        System.out.println("aku makan");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("guguk");
    }
}

class Pig extends Animal {
    void sound() {
        System.out.println("babi");
    }
}

public class Cobazz {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.sound();

        Pig pig = new Pig();
        pig.eat();
        pig.sound();
    }
}
