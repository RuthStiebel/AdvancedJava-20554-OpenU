public class DateOfBirth {
    private int day;
    private int month;
    private int year;

    public DateOfBirth(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // this constructor turns a string into a DateOfBirth object
    public DateOfBirth(String date) {
        this(0, 0, 0);
        String[] dates = date.split("\\.");
        if (dates.length != 3) {
            throw new IllegalArgumentException("Wrong number of arguments in date.");
        } else {
            this.day = Integer.parseInt(dates[0]);
            this.month = Integer.parseInt(dates[1]);
            this.year = Integer.parseInt(dates[2]);
        }
    } 

    // getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return (day + "." + month + "." + year);
    }
}
