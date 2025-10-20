import java.util.Scanner;

public class IRS {

    private static final Scanner keyboard = new Scanner(System.in);

    // declare constants:
    private static int STINKING_RICH = 500000;
    private static int QUITE_RICH = 200000;
    private static int MIAMI_POOR = 100000;
    private static int AVERAGE = 50000;
    private static int REALISTIC = 20000;

    private static double HIGH_RATE = 0.25;
    private static double MEDIUM_RATE = 0.1;
    private static double LOW_RATE = 0.03;

    public static void main(String[] args) {

        double income;
        double deduction;
        double taxableIncome;
        double amount;
        double taxOwed;
        char taxGroup;

        income = 0.0;
        deduction = 0.0;

        do {

            System.out.println("Enter next amount : ");

            amount = keyboard.nextDouble();

            if (amount > 0) {

                income += amount;

            }
            else if (amount < 0) {

                deduction -= amount;

            }

        }
        while (amount != 0);

        // call oher methods:
        taxableIncome = computeTaxableIncome(income, deduction);
        taxGroup = computeTaxGroup(taxableIncome);
        taxOwed = computeTax(taxableIncome, taxGroup);

        displayTaxInformation(income, deduction, taxableIncome, taxGroup, taxOwed);


    } // end of the main method

    private static double computeTaxableIncome(double income, double deduction) {


        if (income >= deduction) {

            return(income - deduction);

        }else {

            return 0.0;

        } // end of the if statement

    } // end of the Compute Taxable Income method

    private static char computeTaxGroup(double taxableIncome) {

        char taxGroup;

        if (taxableIncome >= STINKING_RICH) {

            taxGroup = 'S';

        }
        else if (taxableIncome >= QUITE_RICH) {

            taxGroup = 'Q';

        }
        else if (taxableIncome >= MIAMI_POOR) {

            taxGroup = 'M';
        }
        else if (taxableIncome >= AVERAGE) {

            taxGroup = 'A';

        }
        else if (taxableIncome >= REALISTIC) {

            taxGroup = 'R';

        }
        else {

            taxGroup = 'P';

        }

        return taxGroup;

    } // end of the computeTaxGroup method

    private static double computeTax(double taxableIncome, char group) {

        double taxOwed;

        if (group == 'S' || group == 'Q') {

            taxOwed = taxableIncome * HIGH_RATE;

        }
        else if (group == 'M') {

            taxOwed = taxableIncome * MEDIUM_RATE;

        }
        else if (group == 'A' || group == 'R') {

            taxOwed = taxableIncome * LOW_RATE;

        }
        else if (group == 'P') {

            taxOwed = taxableIncome * 0;

        }
        else {

            taxOwed = 0.0;
            System.out.println("Error!");

        }

        return taxOwed;

    } // end of the compute tax method

    private static void displayTaxInformation(double income, double deduction, double taxableIncome, char taxGroup, double taxOwed) {

        System.out.println("Income         = $" + income);
        System.out.println("Deductions     = $" + deduction);
        System.out.println("Taxable income = $" + taxableIncome);
        System.out.println("Tax group      = " + taxGroup);
        System.out.println("Tax owed       = $" + taxOwed);

    } // end of the display tax information method


} // end of the IRS class
