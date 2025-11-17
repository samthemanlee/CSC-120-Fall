import java.util.Scanner;

public class Driver {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter the name of the girl : ");
        String name = keyboard.next();

        Girl myGirl = new Girl(name);

        System.out.println(myGirl.getStatus());

        int carat = 0;
        int value = 0;

        do {

            System.out.print("Enter carats and value     : ");
            carat = keyboard.nextInt();
            value = keyboard.nextInt();

            Diamond myDiamond = new Diamond(carat, value);

            if (myGirl.receiveDiamond(myDiamond)) {

                System.out.println("Woohoo, the girl took the diamond");
                System.out.println(myGirl.getStatus());

            }
            else if(!myGirl.receiveDiamond(myDiamond)) {

                System.out.println("Aaargh, the diamond was rejected");
                System.out.println(myGirl.getStatus());

            } // end of the if-else statement

        } while (carat != 0);

    } // end of the main method

} // end of the Driver class
