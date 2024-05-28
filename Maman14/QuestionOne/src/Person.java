import java.time.Year;

public class Person implements Comparable<Person> {
    private String name;
    private int id;
    private int yearOfBirth;

    /**
     * Constructs a person with the specified name, ID, and year of birth.
     * 
     * @param name        The name of the person.
     * @param id          The ID number of the person.
     * @param yearOfBirth The year of birth of the person.
     */
    public Person(String name, int id, int yearOfBirth) {
        this.name = name;
        this.id = id;
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * Gets the name of the person.
     * 
     * @return The name of the person.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the ID number of the person.
     * 
     * @return The ID number of the person.
     */
    public int getID() {
        return this.id;
    }

    /**
     * Gets the year of birth of the person.
     * 
     * @return The year of birth of the person.
     */
    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    /**
     * Calculates and returns the age of the person.
     * 
     * @return The age of the person.
     */
    private int getAge() {
        return Year.now().getValue() - this.yearOfBirth;
    }

    /**
     * Compares this person's age to another person's age for sorting purposes.
     * 
     * @param o The other person to compare with.
     * @return A negative integer, zero, or a positive integer as this person's age
     *         is less than, equal to, or greater than the specified person's age.
     */
    @Override
    public int compareTo(Person o) {
        if (o.getAge() == this.getAge())
            return 0;
        else if (o.getAge() > this.getAge())
            return -1;
        else
            return 1;
    }

    /**
     * Returns a string representation of the person.
     * 
     * @return A string containing the person's name, ID number, and year of birth.
     */
    @Override
    public String toString() {
        return "Name: " + this.name + "\nID number: " + this.id + "\nBirth year: " + this.yearOfBirth + "\n\n";
    }
}
