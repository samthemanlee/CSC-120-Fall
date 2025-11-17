import java.util.Scanner;

public class Diamond {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the name of the girl : ");
        String girlName = keyboard.next();

        Girl myGirl = new Girl(girlName, 0, 0);
        System.out.println(myGirl.getGirlName() + " has no best friend");

        int newCarat = 0;
        int newValue = 0;

        do {

            System.out.print("Enter carats and value     : ");
            newCarat = keyboard.nextInt();
            newValue = keyboard.nextInt();

            if (newCarat > myGirl.getDiamondCarat() && newCarat != 0) {

                System.out.println("Woohoo, the girl took the diamond");

                myGirl.setDiamondCarat(newCarat);
                myGirl.setDiamondValue(newValue);

                System.out.println(myGirl);

            }
            else if (newCarat <= myGirl.getDiamondCarat() && newCarat != 0) {

                System.out.println("Aaargh, the diamond was rejected");

                System.out.println(myGirl);

            }
            else {

                break;

            } // end of the if-else statement

        } while (newCarat != 0);

    } // end of the main method

} // end of the Diamond class
