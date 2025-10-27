import java.util.Scanner;

/**
 * FloridaFamily
 *
 * Records a family's teeth (uppers / lowers) using a 3-D char array:
 *   family[personIndex][layerIndex][toothIndex]
 * where layerIndex 0 = Uppers, 1 = Lowers.
 *
 * Supports:
 *  - Accept up to 6 family members
 *  - Each layer up to 8 teeth (characters 'I', 'B', 'M' only)
 *  - Print records
 *  - Extract a tooth (mark it 'M'), with full validation & re-prompting
 *  - Report the family's root canal indices as roots of Ix^2 + Bx - M
 *
 * All prompts are case-insensitive where appropriate, and input is validated.
 *
 * @author Zecheng (Sam) Li (adapted)
 */
public class FloridaFamily {

    /** Global Scanner object to use keyboard */
    private static final Scanner keyboard = new Scanner(System.in);

    /** Maximum family size and max teeth per layer */
    private static final int MAX_FAMILY = 6;
    private static final int MAX_TEETH_PER_LAYER = 8;

    /* ---------------------- main ---------------------- */
    public static void main(String[] args) {

        // Display welcome message:
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");

        // 1) How many people?
        int numberInFamily = getFamilyNumbers();

        // 2) Prepare storage
        String[] familyNames = new String[numberInFamily];
        String[] layers = new String[] {"Uppers", "Lowers"};
        char[][][] familyTeeth = new char[numberInFamily][layers.length][];

        // 3) For each person: name then immediate collection of uppers and lowers
        for (int i = 0; i < numberInFamily; i++) {
            System.out.print("Please enter the name for family member " + (i + 1) + "   : ");
            familyNames[i] = keyboard.next();
            // collect uppers and lowers for this member now
            getTeethForMember(familyNames[i], layers, familyTeeth, i);
        }

        // 4) Menu loop
        menuLoop(familyNames, layers, familyTeeth);
    }

    /* ---------------------- getFamilyNumbers ---------------------- */
    /**
     * Prompt and validate number of family members (1..MAX_FAMILY)
     */
    public static int getFamilyNumbers() {
        System.out.print("Please enter number of people in the family : ");
        int n = keyboard.nextInt();

        while (n < 1 || n > MAX_FAMILY) {
            System.out.print("Invalid number of people, try again         : ");
            n = keyboard.nextInt();
        }
        return n;
    }

    /* ---------------------- getTeethForMember ---------------------- */
    /**
     * For a single member, prompt for each layer (Uppers, Lowers) and validate
     * letters (I, B, M) and length (<= MAX_TEETH_PER_LAYER).
     */
    public static void getTeethForMember(String memberName, String[] layers, char[][][] familyTeeth, int memberIndex) {
        for (int layer = 0; layer < layers.length; layer++) {
            System.out.print("Please enter the " + layers[layer] + " for " + memberName + "       : ");
            String s = keyboard.next();
            s = s.toUpperCase();

            while (s.length() > MAX_TEETH_PER_LAYER || !s.matches("[IBM]+")) {
                if (s.length() > MAX_TEETH_PER_LAYER) {
                    System.out.print("Too many teeth, try again                   : ");
                } else {
                    System.out.print("Invalid teeth types, try again              : ");
                }
                s = keyboard.next().toUpperCase();
            }

            familyTeeth[memberIndex][layer] = s.toCharArray();
        }
    }

    /* ---------------------- menuLoop ---------------------- */
    /**
     * Main menu loop that accepts P/E/R/X in any case and repeats until X.
     */
    public static void menuLoop(String[] familyNames, String[] layers, char[][][] familyTeeth) {
        String option;
        System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it          : ");
        option = keyboard.next();
        option = option.toUpperCase();

        // Validate first entry
        while (!option.equals("P") && !option.equals("E") && !option.equals("R") && !option.equals("X")) {
            System.out.print("Invalid menu option, try again              : ");
            option = keyboard.next().toUpperCase();
        }

        while (!option.equals("X")) {
            if (option.equals("P")) {
                System.out.println();
                printRecords(familyNames, layers, familyTeeth);
            } else if (option.equals("E")) {
                extractTooth(familyNames, layers, familyTeeth);
            } else if (option.equals("R")) {
                reportRoots(familyNames, layers, familyTeeth);
            }

            System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it          : ");
            option = keyboard.next().toUpperCase();

            while (!option.equals("P") && !option.equals("E") && !option.equals("R") && !option.equals("X")) {
                System.out.print("Invalid menu option, try again              : ");
                option = keyboard.next().toUpperCase();
            }
        }

        // exit
        System.out.println();
        System.out.println("Exiting the Floridian Tooth Records :-)");
    }

    /* ---------------------- printRecords ---------------------- */
    /**
     * Print family records in the requested format.
     */
    public static void printRecords(String[] familyNames, String[] layers, char[][][] familyTeeth) {
        for (int p = 0; p < familyNames.length; p++) {
            System.out.println(familyNames[p]);

            // Uppers (layer 0) then Lowers (layer 1)
            for (int layer = 0; layer < layers.length; layer++) {
                System.out.print("  " + layers[layer] + ":  ");
                char[] row = familyTeeth[p][layer];
                for (int t = 0; t < row.length; t++) {
                    // print with two spaces between entries as in sample
                    System.out.print((t + 1) + ":" + row[t]);
                    if (t < row.length - 1) System.out.print("  ");
                }
                System.out.println();
            }
        }
    }

    /* ---------------------- extractTooth ---------------------- */
    /**
     * Prompt which family member, which layer (U/L), and which tooth number.
     * Validate all inputs and, if the chosen tooth is not missing, mark it 'M'.
     */
    public static void extractTooth(String[] familyNames, String[] layers, char[][][] familyTeeth) {
        // Which family member
        System.out.print("\nWhich family member                         : ");
        String nameInput = keyboard.next();
        int personIndex = -1;
        for (int i = 0; i < familyNames.length; i++) {
            if (familyNames[i].equalsIgnoreCase(nameInput)) {
                personIndex = i;
                break;
            }
        }
        while (personIndex == -1) {
            System.out.print("Invalid family member, try again            : ");
            nameInput = keyboard.next();
            for (int i = 0; i < familyNames.length; i++) {
                if (familyNames[i].equalsIgnoreCase(nameInput)) {
                    personIndex = i;
                    break;
                }
            }
        }

        // Which layer: accept first char U or L (case-insensitive)
        System.out.print("Which tooth layer (U)pper or (L)ower        : ");
        String layerInput = keyboard.next();
        while (layerInput.length() == 0) {
            System.out.print("Invalid layer, try again                    : ");
            layerInput = keyboard.next();
        }
        char lch = Character.toUpperCase(layerInput.charAt(0));
        while (lch != 'U' && lch != 'L') {
            System.out.print("Invalid layer, try again                    : ");
            layerInput = keyboard.next();
            lch = Character.toUpperCase(layerInput.charAt(0));
        }
        int layerIndex = (lch == 'U') ? 0 : 1;

        // Which tooth number
        System.out.print("Which tooth number                          : ");
        int toothNumber = keyboard.nextInt();

        // Loop until valid number and not already missing
        while (true) {
            if (toothNumber < 1 || toothNumber > familyTeeth[personIndex][layerIndex].length) {
                System.out.print("Invalid tooth number, try again             : ");
                toothNumber = keyboard.nextInt();
                continue;
            }
            int tIndex = toothNumber - 1;
            if (familyTeeth[personIndex][layerIndex][tIndex] == 'M') {
                System.out.print("Missing tooth, try again                    : ");
                toothNumber = keyboard.nextInt();
                continue;
            }
            // valid and not missing -> extract (mark as 'M') and return
            familyTeeth[personIndex][layerIndex][tIndex] = 'M';
            break;
        }
    }

    /* ---------------------- reportRoots ---------------------- */
    /**
     * Compute counts I, B, M across whole family and report roots of:
     *     I*x^2 + B*x - M = 0
     *
     * Behavior:
     *  - If I == 0 and B == 0 -> "The root does not exist."
     *  - If I == 0 and B != 0 -> linear root: x = M / B
     *  - Else compute discriminant = B^2 - 4 * I * (-M) = B^2 + 4*I*M,
     *    then two real roots (if discriminant > 0), one repeated root (==0), or "Complex Roots".
     */
    public static void reportRoots(String[] familyNames, String[] layers, char[][][] familyTeeth) {

        int countI = 0, countB = 0, countM = 0;

        for (int p = 0; p < familyNames.length; p++) {
            for (int layer = 0; layer < layers.length; layer++) {
                for (int t = 0; t < familyTeeth[p][layer].length; t++) {
                    char ch = familyTeeth[p][layer][t];
                    if (ch == 'I') countI++;
                    else if (ch == 'B') countB++;
                    else if (ch == 'M') countM++;
                }
            }
        }

        // Handle special cases
        if (countI == 0) {
            if (countB == 0) {
                System.out.println("The root does not exist.");
                return;
            } else {
                // B*x - M = 0 -> x = M / B
                double linearRoot = (double) countM / (double) countB;
                System.out.printf("One and only root canal at %.2f%n", linearRoot);
                return;
            }
        }

        // Quadratic: I*x^2 + B*x - M = 0
        // a = I, b = B, c = -M  => discriminant = b^2 - 4*a*c = B^2 + 4*I*M
        double a = countI;
        double b = countB;
        double c = -countM;
        double discriminant = Math.pow(b, 2) - 4.0 * a * c; // equals B^2 + 4*I*M

        if (discriminant > 0.0) {
            double sqrtD = Math.sqrt(discriminant);
            double r1 = (-b + sqrtD) / (2.0 * a);
            double r2 = (-b - sqrtD) / (2.0 * a);
            System.out.printf("One root canal at     %.2f%n", r1);
            System.out.printf("Another root canal at %.2f%n", r2);
        } else if (Math.abs(discriminant) < 1e-12) { // treat as zero
            double r = (-b) / (2.0 * a);
            System.out.printf("One and only root canal at %.2f%n", r);
        } else {
            System.out.println("Complex Roots");
        }
    }
}