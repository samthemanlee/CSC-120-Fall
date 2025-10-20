//=============================================================================

import java.util.Scanner;

public class GasLaw {
    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);

    // The gas constant in Joules/mole/K
    private static double GAS_CONSTANT = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

        //----Variables to hold system values
        double volume;
        double moles;
        double temperature;
        double pressure;

        //----Inputs from user and store into variables
        System.out.println("Enter volume, moles, temperature: ");
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        temperature = keyboard.nextDouble();

        //----Calculation of pressure
        pressure = moles * GAS_CONSTANT * temperature / volume;

        //----Output pressure
        System.out.println("Pressure is: " + pressure);

    } // end of the main method

} // end of the GasLaw class
//-----------------------------------------------------------------------------
//=============================================================================