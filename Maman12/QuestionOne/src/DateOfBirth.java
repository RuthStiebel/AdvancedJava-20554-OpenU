public class DateOfBirth {
    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // any year
    private final int LEAP_YEAR_MONTH = 2;
    private final int LEAP_YEAR_DAY = 29;
    private static final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public DateOfBirth(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public DateOfBirth(String date) {
        String[] dates = date.split("\\.");
        if (dates.length != 3) {
            throw new IllegalArgumentException("Wrong number of arguments in date");
        } else {
            int month = Integer.parseInt(dates[0]);
            int day = Integer.parseInt(dates[1]);
            int year = Integer.parseInt(dates[2]);
            if (!isValidDate(month, day, year)) {
                throw new IllegalArgumentException("Invalid date");
            } else {
                this.month = month;
                this.day = day;
                this.year = year;
            }
        }
    }

    private boolean isValidDate(int day, int month, int year) {
        // check if month in range
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException(
                    "month (" + month + ") must be 1-12");
        }

        // check if day in range for month
        if (day <= 0 ||
                (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException("day (" + day +
                    ") out-of-range for the specified month and year");
        }

        // check for leap year if month is 2 and day is 29
        if (month == LEAP_YEAR_MONTH && day == LEAP_YEAR_DAY && !isLeapYear(year)) {
            throw new IllegalArgumentException("day (" + day +
                    ") out-of-range for the specified month and year");
        }
        return true;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
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

    // return a String of the form month/day/year
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}
