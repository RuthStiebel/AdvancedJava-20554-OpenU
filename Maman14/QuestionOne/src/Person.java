import java.time.Year;

public class Person implements Comparable<Person> {
    private String name;
    private int id;
    private int yearOfBirth;

    public Person(String name, int id, int yearOfBirth) {
        this.name = name;
        this.id = id;
        this.yearOfBirth = yearOfBirth;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.id;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    private int getAge() {
        return Year.now().getValue() - this.yearOfBirth;

    }

    @Override
    public int compareTo(Person o) {
        if (o.getAge() == this.getAge())
            return 0;
        else if (o.getAge() > this.getAge())
            return -1;
        else
            return 1;
    }

    @Override
    public String toString () {
        return "Name: " + this.name + "\tID number: " + this.id + "\tBirth year: "+this.yearOfBirth;
    }
}
