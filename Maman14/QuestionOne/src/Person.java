public class Person {
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
}
