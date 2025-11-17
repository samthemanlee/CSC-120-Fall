public class Girl {


    private static String name;
    private Diamond diamond;

    public Girl(String name) {

        this.name = name;
        this.diamond = null;

    } // end of the constructor

    public boolean receiveDiamond (Diamond newDiamond) {

        if (diamond == null) {

            diamond = newDiamond;
            return true;

        }
        else if (diamond.getValue() < newDiamond.getValue()) {

            diamond = newDiamond;
            return true;

        }
        else {

            return false;

        }

    } // end of the receiveDiamond method

    public String getStatus () {

        if (diamond == null) {

            return (name + " has no best friend");
        }
        else {

            return (name + " has a diamond, " + diamond.getCarat() + " carats, worth $" + diamond.getValue());

        }

    }
} // end of the Girl class
