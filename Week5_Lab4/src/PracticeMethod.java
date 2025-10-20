import java.util.Scanner;

public class PracticeMethod {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the first number: ");
        double userInputFirstNumber = keyboard.nextDouble();

        System.out.println("Enter the first number: ");
        double userInputSecondNumber = keyboard.nextDouble();

        double result = calculateSum(userInputFirstNumber, userInputSecondNumber);
        System.out.println("The sum of " + userInputFirstNumber + " and " + userInputSecondNumber + " is " + result);

    } // end of the main method

    public static double calculateSum(double firstNumber, double secondNumber) {

        double total = firstNumber + secondNumber;
        return total;

    } // end



}
