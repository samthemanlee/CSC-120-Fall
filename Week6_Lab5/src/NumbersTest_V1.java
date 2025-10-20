import java.util.Scanner;

public class NumbersTest_V1 {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        // Declare variables and arrays:
        boolean isFibonacci;
        boolean isPrime;
        int [] numberList2;
        int i;

        // form a new array:
        numberList2 = formArray();

        for (i = 0; i <numberList2.length; ++i ) {

            isFibonacci = testFibonacci(numberList2[i]);
            isPrime = testPrime(numberList2[i]);

            if (isFibonacci) {

                if (isPrime) {

                    System.out.println(numberList2[i] + " is Fibonacci and is prime");

                }
                else {

                    System.out.println(numberList2[i] + " is Fibonacci and is not prime");

                }
            }
            else {

                if (isPrime) {

                    System.out.println(numberList2[i] + " is not Fibonacci and is prime");

                }
                else {

                    System.out.println(numberList2[i] + " is not Fibonacci and is not prime");

                }
            }
        }
    } // end of the main method

    private static int[] formArray() {

        // declare variables and arrays:
        int count;
        int num;
        int [] numberList;

        numberList = new int[10];

        System.out.print("Please enter numbers (0 to stop) : ");

        // perform do-while loop:
        count = 0;
        do {

            num = keyboard.nextInt();

            if (num != 0 && count < numberList.length) {

                numberList[count] = num;
                count ++;

            }


        } while (num != 0 && count < numberList.length);

        return numberList;

    } // end of the formArray method

    private static boolean testFibonacci(int number) {

        int first;
        int second;
        int next;

        first = 0;
        second = 1;

        while (first <= number) {

            if (first == number) {

                return true;

            }

            else {

                next = first + second;
                first = second;
                second = next;

            }

        }

        return false;

    } // end of the testFibonacci method

    private static boolean testPrime(int number) {

        int isZero;

        isZero = number % 2;

        if (number <= 1) {

            return false;
        }

        else if (isZero == 0) {

            return false;

        }
        else {

            return true;

        }

    } // end of the testPrime method

} // end of the NumbersTest Class
