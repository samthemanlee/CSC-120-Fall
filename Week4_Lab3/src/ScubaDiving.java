import java.util.Scanner;
public class ScubaDiving {

    private static Scanner keyboard = new Scanner(System.in);

    // Feet per Atmosphere Constant:
    private static int FEET_PER_ATMOSPHERE = 33;

    public static void main(String[] args) {

        // Declare variables:
        int diveDepth;
        int oxygenPercent;
        double ambientPressure;
        double partialOxygen;
        boolean exceedMaximal;
        boolean exceedContingency;
        char oxygenGroup;

        // Call user inputs of Depth of dive and Oxygen Percentage:
        System.out.print("Enter depth and percentage O2   : ");
        diveDepth = keyboard.nextInt();
        oxygenPercent = keyboard.nextInt();

        // Calculate Ambient Pressure & Partial Pressure of Oxygen:
        ambientPressure = (double) diveDepth / (double) FEET_PER_ATMOSPHERE + 1;
        partialOxygen = (double) oxygenPercent / 100.0 * ambientPressure;

        System.out.println("Ambient pressure                : " + ambientPressure);
        System.out.println("O2 pressure                     : " + partialOxygen);

        // Create Oxygen Pressure Group:
        oxygenGroup = (char) ((int) (partialOxygen * 10.0) + (char) 'A');
        System.out.println("O2 group                        : " + oxygenGroup);

        // Evaluate if the partial Oxygen Pressure is close too strong:
        exceedMaximal = partialOxygen > 1.4 && partialOxygen <= 1.6;
        exceedContingency = partialOxygen > 1.6;

        System.out.println("Exceeds maximal O2 pressure     : " + exceedMaximal);
        System.out.println("Exceeds contingency O2 pressure : " + exceedContingency);

    } // end of the main method

} // end of the ScubaDiving Class
