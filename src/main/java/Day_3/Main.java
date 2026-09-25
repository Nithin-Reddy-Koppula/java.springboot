package Day_3;

// Main class
public class Main {

    // Program starts here
    public static void main(String[] args) {

        // Create a Dog object
        Dog dog = new Dog("Tommy");

        // Get dog's name
        System.out.println("Name: " + dog.getName());

        // Call inherited method
        dog.eat();

        // Call overridden method
        dog.sound();
    }
}