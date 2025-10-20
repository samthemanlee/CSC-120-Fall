import java.util.Scanner;

public class StreetMaintenance {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        //Declare variables and arrays:
        int numberOfHouses;
        int[] houseNumbers;
        int[][] peopleAges;
        int row;
        int column;
        int totalAgesPerHouse;
        int totalAgesOnStreet;

        //Fill variables and arrays:
        numberOfHouses = getNumberOfHouses();
        houseNumbers = new int[numberOfHouses];
        fillHouseNumbers(houseNumbers);
        peopleAges = new int[numberOfHouses][];
        fillPeopleAges(houseNumbers, peopleAges);
        totalAgesOnStreet = 0;

        //Calculate total ages per house:
        for (row = 0; row < peopleAges.length; row++) {

            totalAgesPerHouse = 0;

            for (column = 0; column < peopleAges[row].length; column++) {
                totalAgesPerHouse += peopleAges[row][column];
            }

            System.out.println("House " + houseNumbers[row] + " has a total age of " + totalAgesPerHouse);
        }

        //Calculate total ages on street:
        for (row = 0; row < peopleAges.length; row++) {
            for (column = 0; column < peopleAges[row].length; column++) {

                totalAgesOnStreet += peopleAges[row][column];

            }
        }

        System.out.println("The street has a total age of " + totalAgesOnStreet);
    }

    public static int getNumberOfHouses() {

        int numberOfHouses;
        System.out.print("How many houses in the street? : ");
        numberOfHouses = keyboard.nextInt();
        return numberOfHouses;

    } // end of the getNumberOfHouses method

    public static void fillHouseNumbers(int[] inputHouseNumbers) {

        int index;

        for (index = 0; index < inputHouseNumbers.length; ++index) {
            System.out.print("What is the next house number? : ");
            inputHouseNumbers[index] = keyboard.nextInt();

        } // end of the for loop

    } // end of the fillHouseNumbers method

    public static void fillPeopleAges(int[] inputHouseNumbers, int[][] inputPeopleAges) {

        int row, column, numberOfPeople;

        for (row = 0; row < inputPeopleAges.length; row++) {

            System.out.print("How many people live in number " + inputHouseNumbers[row] + " : ");
            numberOfPeople = keyboard.nextInt();
            inputPeopleAges[row] = new int[numberOfPeople];

            for (column = 0; column < inputPeopleAges[row].length; column++) {
                System.out.print("What is the age of person " + (column + 1) + " : ");
                inputPeopleAges[row][column] = keyboard.nextInt();

            } // end of the nested for loop

        } // end of the for loop

    } // end of the fillPeopleAges method

} // end of the StreetMaintenance class
