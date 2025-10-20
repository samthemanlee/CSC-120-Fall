import java.util.Scanner;

public class StreetMaintenanceSelfPractice {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        // Declare variables and arrays:
        int numberOfHouses;
        int totalAgesByHouse;
        int i;
        int j;
        int totalAgesByStreet;
        int [] houseNumber;
        // int [] peoplePerHouse;
        int [][] peopleAges;

        // form arrays and initialize variables:
        numberOfHouses = housesOnStreet();
        houseNumber = getHouseNumber(numberOfHouses);
        // peoplePerHouse = getPeoplePerHouse(numberOfHouses, houseNumber);
        peopleAges = getPeopleAgesTwo (houseNumber);
        totalAgesByHouse = 0;
        totalAgesByStreet = 0;

        // Calculate total ages per house:
        for (i = 0; i < peopleAges.length; ++i) {

            for (j = 0; j < peopleAges[j].length; ++j) {

                totalAgesByHouse += peopleAges[i][j];

            } // end of the nested for loop

            System.out.println("House " + houseNumber[i] + " has a total age of " + totalAgesByHouse);
        } // end of the for loop

        // Calculate total ages on the street:
        for (i = 0; i < peopleAges.length; ++i) {

            for (j = 0; j < peopleAges[j].length; ++j) {

                totalAgesByStreet += peopleAges[i][j];

            }

        } // end of the for loop

        System.out.println("The street has a total age of " + totalAgesByStreet);

    } // end of the main method

    public static int housesOnStreet() {

        int numberHouse;

        System.out.println("How many houses in the street?   : ");

        numberHouse = keyboard.nextInt();

        return numberHouse;

    } // end of the housesOnStreet method

    public static int[] getHouseNumber(int inputNumberOfHouse) {

        int index;
        int[] houseNumber = new int[inputNumberOfHouse];

        for (index = 0; index < houseNumber.length; ++index) {

            System.out.println("What is the next house number?   : ");

            houseNumber[index] = keyboard.nextInt();

        } // end of the for loop

        return houseNumber;

    } // end of the getHouseNumber Method

    public static int[] getPeoplePerHouse (int inputNumberOfHouse, int [] houseNumber) {

        int index;
        int [] peoplePerHouse = new int[inputNumberOfHouse];

        for (index = 0; index < peoplePerHouse.length; ++index) {

            System.out.println("How many people live in number " + houseNumber[index] + " : ");

            peoplePerHouse[index] = keyboard.nextInt();

        } // end of the for loop

        return peoplePerHouse;

    } // end of the getPeoplePerHouse method

    /* public static int [] [] getPeopleAges (int inputNumberOfHouse, int inputPeoplePerHouse) {

        int i;
        int j;

        int [] [] peopleAges = new int [inputNumberOfHouse] [inputPeoplePerHouse];

        for (i = 0; i < inputNumberOfHouse; ++i) {

            for (j = 1; j < inputPeoplePerHouse + 1; ++j) {

                System.out.println("What is the age of person " + j + "      : ");
                peopleAges[i] [j-1] = keyboard.nextInt();

            } // end of the nested for loop

        }  // end of the for loop

        return peopleAges;

    } // end of the getPeopleAges method

     */

    public static int [] [] getPeopleAgesTwo (int [] houseNumber) {

        int i;
        int j;
        int peoplePerHouse;
        int [] [] peopleAges = new int [houseNumber.length] []; // how to determine the second length
        for (i = 0; i < houseNumber.length; ++i) {

            System.out.println("How many people live in number " + houseNumber[i] + " : ");

            peoplePerHouse = keyboard.nextInt();

            peopleAges[i] = new int[peoplePerHouse];

            for (j = 0; j < peoplePerHouse; ++j) {

                System.out.println("What is the age of person " + (j+1) + "      : ");
                peopleAges[i][j] = keyboard.nextInt();

            } // end of the nested for loop
        } // end of the for loop

        return peopleAges;



    } // end of the getPeopleAgesTwo method

} // end of the StreetMaintenanceSelfPractice Class
