/*import java.util.Scanner;

public class PracticeArray {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("WEEK 8 - LAB 6 PRACTICE ARRAY");

        System.out.println("Enter the number of rows: ");
        int numberOfRow = keyboard.nextInt();

        int [] [] myArray = new int[numberOfRow][];

        int row;
        for (row = 0; row < myArray.length; ++row) {

            System.out.println("At row " + row + "Enter the number of columns: ");
            int numberOfColumn = keyboard.nextInt();

            myArray[row] = new int[numberOfColumn];

            int column;
            for (column = 0; column < myArray[row].length; ++column) {

                System.out.println("At index [" + row + ", " + column + "], enter the value to be stored: ");
                myArray[row][column] = keyboard.nextInt();

            } // end of the inner loop

        } // end of the outer for loop

        // Display the 2D irregular arrays
        for (row = 0; row < myArray.length; ++row) {

            for (int column = 0; column < myArray[row].length; ++column) {

                System.out.println("At row [" + row + ", " + column + "], the value was stored: " + myArray[row]][column]);

            }
        }
    }// end of the main method

    public static void fillTheArray(int [] givenArray) {

        int index;

        for (index = 0; index < givenArray.length; ++index) {

            System.out.print("Enter the value to store at the index " + index + ": ");
            givenArray[index] = keyboard.nextInt();

        } // end of the for loop

        for (index = 0; index < givenArray.length; ++index) {

            System.out.println("The value stored at the index " + index + " is " + givenArray[index]);

        } // end of the for loop

    } // end of the fillTheArray method

} // end of the PracticeArray

 */
