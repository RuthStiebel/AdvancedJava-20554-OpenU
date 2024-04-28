public class DateOfBirth {
    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // any year
    private final int LEAP_YEAR_MONTH = 2;
    private final int LEAP_YEAR_DAY = 29;
    private static final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /**
     * Constructs a DateOfBirth object from a string representation of the date.
     * 
     * @param date a string representing the date in the format "day.month.year"
     * @throws IllegalArgumentException if the date string is invalid
     */
    public DateOfBirth(String date) {
        String[] dates = date.split("\\.");
        if (dates.length != 3) {
            throw new IllegalArgumentException("Wrong number of arguments in date");
        } else {
            int day = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            int year = Integer.parseInt(dates[2]);
            if (!isValidDate(day, month, year)) {
                throw new IllegalArgumentException("Invalid date");
            } else {
                this.day = day;
                this.month = month;
                this.year = year;
            }
        }
    }

    /**
     * Checks if the given date is valid.
     * 
     * @param day   the day of the month
     * @param month the month (1-12)
     * @param year  the year
     * @return true if the date is valid, false otherwise
     * @throws IllegalArgumentException if the date is invalid
     */
    private boolean isValidDate(int day, int month, int year) {
        // check if month in range
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException(
                    "Month (" + month + ") must be 1-12");
        }

        // check if day in range for month
        if (day <= 0 ||
                (day > daysPerMonth[month] && !(month == LEAP_YEAR_MONTH && day == LEAP_YEAR_DAY))) {
            throw new IllegalArgumentException("Day (" + day +
                    ") out-of-range for the specified month and year");
        }

        // check for leap year if month is 2 and day is 29
        if (month == LEAP_YEAR_MONTH && day == LEAP_YEAR_DAY && !isLeapYear(year)) {
            throw new IllegalArgumentException("Day (" + day +
                    ") out-of-range for the specified month and year");
        }
        return true;
    }

    /**
     * Checks if the given year is a leap year.
     * 
     * @param year the year to check
     * @return true if the year is a leap year, false otherwise
     */
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Returns the day of the month.
     * 
     * @return the day of the month
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the month.
     * 
     * @return the month (1-12)
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the year.
     * 
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns a string representation of the date in the format "day/month/year".
     * 
     * @return a string representing the date
     */
    public String toString() {
        return String.format("%d/%d/%d", day, month, year);
    }
}
