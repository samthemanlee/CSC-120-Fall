import java.util.Scanner;

/**
 * the FascinatingNumber class tests if numbers in a given array are fibonacci or prime numbers
 * @ Sam Li
 */

public class FascinatingNumber {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        int[] givenArray = new int[10];
        int numberOfIntegerEntered;
        int index;
        boolean isFibonacci;
        boolean isPrime;

        numberOfIntegerEntered = fillTheGivenArray(givenArray);

        for (index = 0; index < numberOfIntegerEntered; index++) {

            isFibonacci = isFibonacci(givenArray[index]);
            isPrime = isPrime(givenArray[index]);

            if (isFibonacci && isPrime) {

                System.out.println(givenArray[index] + " is Fibonacci and is prime");
            }
            else if (isFibonacci && !isPrime) {

                System.out.println(givenArray[index] + " is Fibonacci and is not prime");
            }
            else if (!isFibonacci && isPrime) {

                System.out.println(givenArray[index] + " is not Fibonacci and is prime");

            }
            else if (!isFibonacci && !isPrime) {

                System.out.println(givenArray[index] + " is not Fibonacci and is not prime");

            }
        } // end of the for loop
    } // end of the main method

    /**
     * the main method
     * @param givenArray
     * @return the test result of whether or not each number is fibonacci or prime
     */

    public static int fillTheGivenArray(int [] givenArray) {

        int index = 0;
        int numberOfIntegerEntered = 0;

        System.out.println("Please enter numbers (0 to stop) : ");

        do {

            givenArray[index] = keyboard.nextInt();

            index++;
            numberOfIntegerEntered++;

        } while (givenArray[index - 1] != 0 && index < givenArray.length);

        return numberOfIntegerEntered;

    } // end of the FillTheGivenArray method
    

    public static boolean isPrime(int givenNumber) {

        long divisor = 2;

        while (divisor <= Math.sqrt(givenNumber)) {
            if (givenNumber % divisor == 0) {
                //System.out.println(givenNumber + " is divisible by " + divisor);
                return (false);
            }
            divisor++;
        }
        return (true);

    } // end of the isPrime method

    public static boolean isFibonacci(int givenNumber) {

        int previous = 0;
        int current = 1;

        int index;
        int next;

        for (index = 0; index < givenNumber; index++) {

            next = previous + current;

            if (next == givenNumber) {
                return true;
            }

            previous = current;
            current = next;

        } // end of the for loop

        return false;

    } // end of the isFibonacci method

} // end of the FascinatingNumber class
