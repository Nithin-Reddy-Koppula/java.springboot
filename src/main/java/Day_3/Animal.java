package Day_3;

// The public class name is Animal
// Therefore the file must be named Animal.java
public abstract class Animal {

    // Private variable for encapsulation
    private String name;

    // Constructor
    public Animal(String name) {

        // Store the received name
        this.name = name;
    }

    // Getter method
    public String getName() {

        // Return the animal's name
        return name;
    }

    // Abstract method
    public abstract void sound();

    // Normal method
    public void eat() {

        // Print message
        System.out.println(name + " is eating");
    }
}