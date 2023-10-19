class Leap {

    private final int LEAP_YEAR_DIVISOR = 4;
    private final int CENTURY_DIVISOR = 100;
    private final int QUAD_CENTURY_DIVISOR = 400;
    boolean isLeapYear(int year) {
        return year % LEAP_YEAR_DIVISOR == 0 && (year % CENTURY_DIVISOR != 0 || year % QUAD_CENTURY_DIVISOR == 0);
    }

}
