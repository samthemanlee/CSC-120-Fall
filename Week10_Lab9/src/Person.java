public class Person {

    private String name;
    private int age;

    public Person() {
        this.name = "NO NAME YET";
        this.age = 0;
    } // end of the constructor method

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    } // end of the constructor method

    @Override
    public String toString() {

        return (name + " is " + age +  "years old");

    } // end of the toString method

    public void incrementAge () {

        age += 1;

    } // end of the incrementAge method

    public String getName() {
        return name;
    } // end of the name-getter method

    public int getAge() {
        return age;
    } // end of the age-getter method

} // end of the Person class
