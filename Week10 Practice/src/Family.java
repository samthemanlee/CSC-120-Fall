public class Family {

    private Person[] people;
    private int numberOfPeople;
    private static final int MAX_PEOPLE = 10;

    public Family () {

        people = new Person[MAX_PEOPLE];
        numberOfPeople = 0;

    } // end of the constructor method

    public void display () {

        int i;

        for (i = 0; i < numberOfPeople; i++) {

            System.out.println(people[i]);

        } // end of the for loop

    } // end of the IO method

    public boolean addPerson (String inputName, int inputAge) {

        if (numberOfPeople > MAX_PEOPLE) {

            return false;

        }
        else {

            people[numberOfPeople] = new Person(inputName, inputAge);
            numberOfPeople ++;
            return true;

        } // end of the if-else statement

    } // end of the addPerson method

    public void birthday (String inputName) {

        int i;

        for (i = 0; i < numberOfPeople; i++) {

            if (people[i].getName().equals(inputName)) {

                people[i].incrementAge();
                break;

            } // end of the if statement

        } // end of the for loop

    } // end of the birthday method

    public int getNumberOfPeople () {

        return numberOfPeople;

    } // end of the getNumberOfPeople method

    public int getTotalAges () {

        int i;
        int totalAges = 0;

        for (i = 0; i < numberOfPeople; i++) {

            totalAges += people[i].getAge();

        } // end of the for loop

        return totalAges;

    } // end of the getTotalAges method

} // end of the Family class