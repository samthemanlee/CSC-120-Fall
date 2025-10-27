import java.util.Scanner;
//=================================================================================================
/**
 * Perform certain tasks related to teeth record of a Florida family
 * @author Zecheng (Sam) Li
 */
public class FloridaFamily {
//-------------------------------------------------------------------------------------------------
    /**
     * Global Scanner object to use keyboard
     */
    private static final Scanner keyboard = new Scanner(System.in);
//-------------------------------------------------------------------------------------------------
    /**
     * the main method
     * @param args Passed in from the command line
     */
    public static void main(String[] args) {

        // Declare variables and arrays:
        int numberInFamily;
        String[] FamilyMembersNames;
        String[] TeethLayers;
        char[][][] FamilyMembersTeethTypes;

        // Display welcome message:
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");

        // Take inputs and form the 3D array:
        TeethLayers = new String[] {"Uppers", "Lowers"};
        numberInFamily = getFamilyNumbers();
        FamilyMembersNames = new String[numberInFamily];
        FamilyMembersTeethTypes = new char[numberInFamily][TeethLayers.length][];

        // Now collect each member’s name and teeth right after:
        for (int i = 0; i < numberInFamily; i++) {
            System.out.println("Please enter the name for family member " + (i + 1) + "   : ");
            FamilyMembersNames[i] = keyboard.next();
            getTeethForMember(FamilyMembersNames[i], TeethLayers, FamilyMembersTeethTypes, i);
        }

        // Process menu options and output results:
        MenuOptions(FamilyMembersNames, TeethLayers, FamilyMembersTeethTypes);

    } // end of the main method
//-------------------------------------------------------------------------------------------------
    /**
     * Prompt user to input the number of family members
     * @return the number of family members
     */
    public static int getFamilyNumbers() {

        int numberInFamily;

        System.out.println("Please enter number of people in the family : ");
        numberInFamily = keyboard.nextInt();

        while (numberInFamily < 1 || numberInFamily > 6) {

            System.out.println("Invalid number of people, try again         : ");
            numberInFamily = keyboard.nextInt();

        } // end of the while loop

        return numberInFamily;

    } // end of the getFamilyNumbers Method
//-------------------------------------------------------------------------------------------------
    /**
     * Prompt user to input teeth types for one family member
     * @param memberName name of the family member
     * @param inputTeethLayers layers (Uppers, Lowers)
     * @param inputFamilyMembersTeethTypes the 3D array of all teeth records
     * @param memberIndex index of this member
     */
    public static void getTeethForMember(String memberName, String[] inputTeethLayers, char[][][] inputFamilyMembersTeethTypes, int memberIndex) {

        int layer, type;
        String teethTypesString;

        for (layer = 0; layer < inputTeethLayers.length; layer++) {

            System.out.println("Please enter the " + inputTeethLayers[layer] + " for " + memberName + "       : ");
            teethTypesString = keyboard.next();
            teethTypesString = teethTypesString.toUpperCase();

            while (teethTypesString.length() > 8 || !teethTypesString.matches("[IBM]+")) {

                if (teethTypesString.length() > 8) {

                    System.out.println("Too many teeth, try again                   : ");
                    teethTypesString = keyboard.next().toUpperCase();

                } else {

                    System.out.println("Invalid teeth types, try again              : ");
                    teethTypesString = keyboard.next().toUpperCase();

                } // end of the if-else statements

            } // end of the while loop

            // Initialize the third dimension of the 3D array:
            inputFamilyMembersTeethTypes[memberIndex][layer] = new char[teethTypesString.length()];

            for (type = 0; type < teethTypesString.length(); type++) {

                inputFamilyMembersTeethTypes[memberIndex][layer][type] = teethTypesString.charAt(type);

            } // end of the for loop

        } // end of the first layer nested loop

    } // end of getTeethForMember method
//-------------------------------------------------------------------------------------------------
    /**
     * Prompt user to choose one task to perform and output the result of the performance
     * @param inputFamilyMembersNames
     * @param inputTeethLayers
     * @param inputFamilyMembersTeethTypes
     */
    public static void MenuOptions(String[] inputFamilyMembersNames, String[] inputTeethLayers, char[][][] inputFamilyMembersTeethTypes) {

        String userOption;
        System.out.println("(P)rint, (E)xtract, (R)oot, e(X)it          : ");
        userOption = keyboard.next().toUpperCase();

        while (!userOption.equals("P") && !userOption.equals("E") && !userOption.equals("R") && !userOption.equals("X")) {

            System.out.println("Invalid menu option, try again              : ");
            userOption = keyboard.next().toUpperCase();

        } // end of the while loop

        while (!userOption.equals("X")) {

            if (userOption.equals("P")) {

                PrintRecords(inputFamilyMembersNames, inputTeethLayers, inputFamilyMembersTeethTypes);

            } else if (userOption.equals("E")) {

                ExtractTooth(inputFamilyMembersNames, inputTeethLayers, inputFamilyMembersTeethTypes);

            } else if (userOption.equals("R")) {

                ReportRoots(inputFamilyMembersNames, inputTeethLayers, inputFamilyMembersTeethTypes);

            }

            System.out.println("(P)rint, (E)xtract, (R)oot, e(X)it          : ");
            userOption = keyboard.next().toUpperCase();

        } // end of the while loop

        if (userOption.equals("X")) {

            ExitProgram();

        } // end of the if-else statements

    } // end of the MenuOptions method
//-------------------------------------------------------------------------------------------------
    /**
     * Print teeth records of the family
     * @param inputFamilyMembersNames
     * @param inputTeethLayers
     * @param inputFamilyMembersTeethTypes
     */
    public static void PrintRecords (String[] inputFamilyMembersNames, String[] inputTeethLayers, char [][][] inputFamilyMembersTeethTypes) {

        int name, layer, type;

        for (name = 0; name < inputFamilyMembersNames.length; name++) {

            System.out.println(inputFamilyMembersNames[name]);

            for (layer = 0; layer < inputTeethLayers.length; layer++) {
                System.out.print("  " + inputTeethLayers[layer] + ":  ");

                for (type = 0; type < inputFamilyMembersTeethTypes[name][layer].length; type++) {
                    if (type < inputFamilyMembersTeethTypes[name][layer].length -1) {
                        System.out.print((type + 1) + ":" + inputFamilyMembersTeethTypes[name][layer][type] + "  ");
                    } else {
                        System.out.println((type + 1) + ":" + inputFamilyMembersTeethTypes[name][layer][type]);
                    }
                }
            }
            System.out.println();
        }
    } // end of the PrintRecords method
//-------------------------------------------------------------------------------------------------
    /**
     * Extract a certain tooth's type
     * @param inputFamilyMembersNames
     * @param inputTeethLayers
     * @param inputFamilyMembersTeethTypes
     */
    public static void ExtractTooth (String[] inputFamilyMembersNames, String[] inputTeethLayers, char [][][] inputFamilyMembersTeethTypes) {

        //declare variables:
        String userChoiceOfFamilyMember;
        String userChoiceOfTeethLayer;
        int userChoiceOfToothNumber;
        int name, layer;
        int nameIndex, layerIndex, typeIndex;
        boolean foundName;
        boolean foundLayer;

        // prompt a user input of family member:
        System.out.print("Which family member                         : ");
        userChoiceOfFamilyMember = keyboard.next();
        foundName = false;

        do {
            for (name = 0; name < inputFamilyMembersNames.length; name++) {
                if (userChoiceOfFamilyMember.equalsIgnoreCase(inputFamilyMembersNames[name])) {
                    foundName = true;
                    break;
                }
            }

            if (!foundName) {
                System.out.print("Invalid family member, try again            : ");
                userChoiceOfFamilyMember = keyboard.next();
            }
        } while (!foundName);
        // end of the do while loop

        // prompt a user input of teeth layer:
        System.out.print("Which tooth layer (U)pper or (L)ower        : ");
        userChoiceOfTeethLayer = keyboard.next();
        foundLayer = false;

        do {
            for (layer = 0; layer < inputTeethLayers.length; layer++) {
                if(userChoiceOfTeethLayer.equalsIgnoreCase(String.valueOf(inputTeethLayers[layer].charAt(0)))) {
                    foundLayer = true;
                    break;
                }
            }

            if(!foundLayer) {
                System.out.print("Invalid layer, try again                    : ");
                userChoiceOfTeethLayer = keyboard.next();
            }
        } while(!foundLayer);
        // end of the do while loop

        // get the index of the chosen name:
        nameIndex = 0;
        for (name = 0; name < inputFamilyMembersNames.length; name++) {
            if(inputFamilyMembersNames[name].equalsIgnoreCase(userChoiceOfFamilyMember)) {
                nameIndex = name;
                break;
            }
        }

        // get the index of the chosen layer:
        layerIndex = 0;
        for (layer = 0; layer < inputTeethLayers.length; layer++) {
            if (Character.toUpperCase(inputTeethLayers[layer].charAt(0)) == Character.toUpperCase(userChoiceOfTeethLayer.charAt(0))) {
                layerIndex = layer;
                break;
            }
        }

        // prompt a user input of tooth number:
        System.out.print("Which tooth number                          : ");
        userChoiceOfToothNumber = keyboard.nextInt();

        // keep asking until valid and not missing, then mark as missing (extracted)
        while (true) {

            if (userChoiceOfToothNumber < 1 || userChoiceOfToothNumber > inputFamilyMembersTeethTypes[nameIndex][layerIndex].length) {
                System.out.print("Invalid tooth number, try again             : ");
                userChoiceOfToothNumber = keyboard.nextInt();
                continue;
            }

            typeIndex = userChoiceOfToothNumber - 1;

            // check for missing tooth
            if (inputFamilyMembersTeethTypes[nameIndex][layerIndex][typeIndex] == 'M') {
                System.out.print("Missing tooth, try again                    : ");
                userChoiceOfToothNumber = keyboard.nextInt();
                continue;
            }

            // MARK THE TOOTH AS EXTRACTED (set to 'M')
            inputFamilyMembersTeethTypes[nameIndex][layerIndex][typeIndex] = 'M';
            // do NOT print the tooth here — the sample shows the change only when printing records
            break;
        }

    } // end of the ExtractTooth method
//-------------------------------------------------------------------------------------------------
    /**
     * Calculate the root canal(s) of the family
     * @param inputFamilyMembersNames
     * @param inputTeethLayers
     * @param inputFamilyMembersTeethTypes
     */
    public static void ReportRoots (String[] inputFamilyMembersNames, String[] inputTeethLayers, char [][][] inputFamilyMembersTeethTypes) {

        int numberOfIncisors = 0, numberOfBicuspids = 0, numberOfMissingTeeth = 0;
        int name, layer, type;
        double discriminant, firstRoot, secondRoot, commonRoot, linearRoot;

        for (name = 0; name < inputFamilyMembersNames.length; name++) {
            for (layer = 0; layer < inputTeethLayers.length; layer++) {
                for (type = 0; type < inputFamilyMembersTeethTypes[name][layer].length; type++) {
                    if (inputFamilyMembersTeethTypes[name][layer][type] == 'I') numberOfIncisors++;
                    else if(inputFamilyMembersTeethTypes[name][layer][type] == 'B') numberOfBicuspids++;
                    else if(inputFamilyMembersTeethTypes[name][layer][type] == 'M') numberOfMissingTeeth++;
                }
            }
        }

        if (numberOfIncisors == 0) {
            if (numberOfBicuspids == 0) {
                System.out.println("The root does not exist.");
            } else {
                linearRoot = (numberOfMissingTeeth * 1.0) / (numberOfBicuspids * 1.0);
                System.out.printf("One and only root canal at %.2f%n", linearRoot);
            }
        } else {
            discriminant = Math.pow(numberOfBicuspids, 2) - 4 * numberOfIncisors * numberOfMissingTeeth;
            if (discriminant > 0) {
                firstRoot = (1.0 / (2.0 * numberOfIncisors)) * (-numberOfBicuspids + Math.sqrt(discriminant));
                secondRoot = (1.0 / (2.0 * numberOfIncisors)) * (-numberOfBicuspids - Math.sqrt(discriminant));
                System.out.printf("One root canal at     %.2f%n", firstRoot);
                System.out.printf("Another root canal at %.2f%n", secondRoot);
            } else if (discriminant == 0) {
                commonRoot = (1.0 / (2.0 * numberOfIncisors)) * (-numberOfBicuspids);
                System.out.printf("One and only root canal at %.2f%n", commonRoot);
            } else {
                System.out.println("Complex Roots");
            }
        }
    } // end of the ReportRoots method
//-------------------------------------------------------------------------------------------------
    /**
     * Exit the program
     */
    public static void ExitProgram () {
        System.out.println();
        System.out.println("Exiting the Floridian Tooth Records :-)");
    } // end of the ExitProgram method

} // end of the Florida Family class
