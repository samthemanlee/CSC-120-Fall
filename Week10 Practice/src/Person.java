public class Person {


    private String name;
    private int age;

    // Default constructor:
    public Person () {

        this.name = "NO NAME YET";
        this.age = 0;

    } // end of the default constructor method


    // constructor:
    public Person(String name, int age) {

        this.name = name;
        this.age = age;

    } // end of the constructor

    public String toString() {

        return(name + " is " + age + " years old");

    } // end of the toString method

    public void incrementAge() {

        age += 1;

    } // end of the incrementAge method

    public String getName () {

        return name;

    } // end of the getName method

    public int getAge () {

        return age;

    } // end of the getAge method

} // end of the Person class