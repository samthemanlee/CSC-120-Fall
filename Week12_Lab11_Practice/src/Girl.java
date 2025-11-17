public class Girl {

    private static String girlName;
    private static int diamondCarat;
    private static int diamondValue;

    public Girl (String girlName, int diamondCarat, int diamondValue) {

        this.girlName = girlName;
        this.diamondCarat = diamondCarat;
        this.diamondValue = diamondValue;

    } // end of the constructor method

    public static void setGirlName(String girlName) {

        Girl.girlName = girlName;

    } // end of the name setter

    public static void setDiamondCarat(int diamondCarat) {

        Girl.diamondCarat = diamondCarat;

    } // end of the carat setter

    public static void setDiamondValue(int diamondValue) {

        Girl.diamondValue = diamondValue;

    } // end of the value setter

    public static String getGirlName() {

        return girlName;

    } // end of the name getter

    public static int getDiamondCarat() {

        return diamondCarat;

    } // end of the carat getter

    public static int getDiamondValue() {

        return diamondValue;

    } // end of the value getter

    public String toString() {

        return ("Marilyn has a diamond, " + diamondCarat + " carats, worth $" + diamondValue);

    } // end of the toString method


} // end of the Girl class
