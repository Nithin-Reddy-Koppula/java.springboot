// Main class
public class Main_1 {

    // Program execution starts here
    public static void main(String[] args) {

        // Create Customer object
        User user1 = new Customer("Nithin");

        // Get customer name using getter
        System.out.println(user1.getName());

        // Call overridden method
        user1.showRole();


        // Create Admin object
        User user2 = new Admin("Rahul");

        // Get admin name
        System.out.println(user2.getName());

        // Call overridden method
        user2.showRole();


        // Create UPI payment object
        Payment payment = new UPI();

        // Call payment method
        payment.pay();
    }
}
