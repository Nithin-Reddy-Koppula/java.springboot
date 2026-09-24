package day_2;

public class StringBuilderDemo {

    public static void main(String[] args) {

        String name = "Nithin";
        String course = "Java";
        int duration = 2;

        StringBuilder message = new StringBuilder();

        message.append("Hello ");
        message.append(name);
        message.append(", you are learning ");
        message.append(course);
        message.append(" for ");
        message.append(duration);
        message.append(" months.");

        System.out.println(message);
    }
}