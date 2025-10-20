import java.util.Scanner;

public class KangrooKills {

    private static Scanner keyboard = new Scanner(System.in);

    // Road kill constant:
    private static double ROAD_KILL = 1.47;

    public static void main(String[] args) {

        // declare variables:
        double sideSquare;
        double areaLand;
        double roadLength;
        double areaRoad;
        double densityKangaroo;
        int numberOfKangaroo;
        int numberOfKill;
        int numberOfInjury;

        // Call user inputs:
        System.out.println("Enter side of square in km  : ");
        sideSquare = keyboard.nextDouble();

        System.out.println("Enter roads length in km    : ");
        roadLength = keyboard.nextDouble();

        System.out.println("Enter number of 'roos       : ");
        numberOfKangaroo = keyboard.nextInt();

        // Calculation of the ratios:
        areaLand = sideSquare * sideSquare;
        densityKangaroo = numberOfKangaroo / areaLand;
        areaRoad = roadLength * 0.01;
        numberOfKill = (int) Math.floor(areaRoad * densityKangaroo * ROAD_KILL);
        numberOfInjury = ((int) (areaRoad * densityKangaroo * ROAD_KILL * 10)) % 10;

        // Output the results:
        System.out.println("Expected number of kills is : " + numberOfKill);
        System.out.println("Expected number of injuries : " + numberOfInjury);
    } // end of main method
} // end of the KangarooKills Class
