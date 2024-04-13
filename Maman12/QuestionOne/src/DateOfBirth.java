public class DateOfBirth {
    private int day;
    private int month;
    private int year;

    public DateOfBirth (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //this constructor turns a string into a DateOfBirth object
    public DateOfBirth (String date) {
        int index = date.indexOf(".");
        this.day = Integer.parseInt(date.substring(0, index));
        date = date.substring(index);
        index = date.indexOf(".");
        this.month = Integer.parseInt(date.substring(0, index));
        date = date.substring(index);
        index = date.indexOf(".");
        this.year = Integer.parseInt(date.substring(0, index));
    }

    //getters
    public int getDay () {return day;}
    
    public int getMonth () {return month;}

    public int getYear () {return year;}

    public String toString () {
        return (day + "." + month + "." + year);
    }
}
