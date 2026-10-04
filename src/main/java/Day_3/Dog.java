package Day_3;

// Dog inherits from Animal
public class Dog extends Animal {

    // Dog constructor
    public Dog(String name) {

        // Call Animal constructor
        super(name);
    }

    // Implement Animal's abstract sound() method
    @Override
    public void sound() {

        // Print dog's sound
        System.out.println(getName() + " says Woof!");
    }
}