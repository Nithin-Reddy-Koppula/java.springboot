package day_2;

import java.util.ArrayList;

public class studentdemo {

    // Method to calculate total marks
    static int calculateTotal(int[] marks) {

        int total = 0;

        for (int mark : marks) {

            total = total + mark;

        }

        return total;
    }

    // Method to calculate average
    static double calculateAverage(int[] marks) {

        int total = calculateTotal(marks);

        return (double) total / marks.length;
    }

    public static void main(String[] args) {

        String studentName = "Nithin";

        int[] marks = {80, 75, 90, 85, 70};

        ArrayList<String> subjects = new ArrayList<>();

        subjects.add("Java");
        subjects.add("SQL");
        subjects.add("Python");
        subjects.add("AI");
        subjects.add("Cloud");

        System.out.println("Student: " + studentName);

        System.out.println("Subjects: " + subjects);

        System.out.println("Total: " + calculateTotal(marks));

        System.out.println("Average: " + calculateAverage(marks));
    }
}