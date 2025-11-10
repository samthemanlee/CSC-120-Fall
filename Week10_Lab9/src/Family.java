public class Family {

    private static final int MAX_PEOPLE = 10;

    private Person [] people;
    private int numberOfPeople;

    public Family () {

        people = new Person[MAX_PEOPLE];
        numberOfPeople = 0;

    } // end of the default constructor method

    public void display () {

        int index;

        for (index = 0; index < numberOfPeople; numberOfPeople++) {

            System.out.println(people[index]);

        } // end of the for loop

    } // end of the display method

    public boolean addPerson(String name, int age) {

        if (numberOfPeople > MAX_PEOPLE) {

            return false;

        }
        else {

            people[numberOfPeople] = new Person(name, age);
            numberOfPeople++;
            return true;

        } // end of the if-else statement

    } // end of the addPerson method

    public void birthday (String name) {

        int index;

        for (index = 0; index < numberOfPeople; index++) {

            if (people[index].getName().equals(name)) {

                people[index].incrementAge();
                break;

            } // end of the if statement

        } // end of the for loop

    } // end of the birthday method

    public int getNumberOfPeople () {

        return numberOfPeople;

    } // end of the getNumberOfPeople method

    public int getTotalAge () {

        int index;
        int totalAge = 0;

        for (index = 0; index < numberOfPeople; index++) {

            totalAge += people[index].getAge();

        } // end of the for loop

        return totalAge;

    } // end of the getTotalAge method




} // end of the Family class
