import java.util.Scanner;

public class Practice {

    private static Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("hello world...");

        // Declare three variables
        String studentName;
        int age;
        double gpa;

        System.out.println("Enter your name:");
        studentName = keyboard.nextLine();

        System.out.println("Enter your age:");
        age = keyboard.nextInt();

        System.out.println("Enter your GPA:");
        gpa = keyboard.nextDouble();

        // Now display the results
        System.out.println("Hello " + studentName + ". You are " + age + " years old, and your GPA is " + gpa + ".");
        System.out.println("Have a good day.");

    } // end of the main method


} // end of the practice class
