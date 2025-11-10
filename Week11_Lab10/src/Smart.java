import java.util.ArrayList;

public class Smart {

    public static void main(String[] args) {

        int index;

        ArrayList<Integer> integerList = new ArrayList<>();

        for (String arg : args) {

            try {

                Integer myInteger = converter(arg);

                integerList.add(myInteger);

            } catch (NumberFormatException e){

                System.out.println("Catch block says the argument \"" + arg + "\" is ignored because " + arg);

            } // end of the try-catch construct

        } // end of the for loop

        System.out.println("The ArrayList contents are:");

        for (index = 0; index < integerList.size(); index++) {

            System.out.println("Item " + index + " is " + integerList.get(index));

        } // end of the for loop

    } // end of the main method

    public static Integer converter(String inputString) throws NumberFormatException {

        int myInteger = Integer.parseInt(inputString);

        System.out.println("Converter method says integer OK - " + myInteger);

        return Integer.valueOf(myInteger);

    } // end of the converter method

} // end of the Smart class