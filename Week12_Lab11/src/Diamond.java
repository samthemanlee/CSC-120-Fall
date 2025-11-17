public class Diamond {

    private static int carat;
    private static int value;

    public Diamond(int carat, int value) {

        this.carat = carat;
        this.value = value;

    } // end of the constructor

    // Beginning of the setters and getters:
    public static int getCarat() {

        return carat;

    }

    public static void setCarat(int carat) {

        Diamond.carat = carat;

    }

    public static int getValue() {

        return value;

    }

    public static void setValue(int value) {

        Diamond.value = value;

    } // end of the setters and getters


} // end of the Diamond class
