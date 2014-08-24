package com.tabish.berlinclock.domain;

import java.util.StringTokenizer;

/**
 * A time object without a timezone.
 * <p/>
 * LocalTime is an immutable time object which represents the time of the day in
 * hour-minute-second.
 * <p/>
 * It does not store date or a timezone. It describes the time of the day as seen on a
 * clock.
 */
public class LocalTime {

    /**
     * The hour part of the time of the day.
     */
    private Hour hour;
    /**
     * The minute part of time of the day.
     */
    private Minute minute;
    /**
     * The second part of time of the day.
     */
    private Second second;

    /**
     * Constructs a LocalTime
     *
     * @param localTime the string representing the time of the day in "hh:mm:ss" format.
     *                  <br>Example Valid string are -
     *                  <ul>
     *                  <li>00:00:00</li>
     *                  <li>23:59:59</li>
     *                  <li>24:00:00</li>
     *                  <li>13:01:10</li>
     *                  </ul>
     */
    public LocalTime(String localTime) {
        validate(localTime);
        initialize(localTime);
    }

    /**
     * Validates the input string.
     *
     * @param localTime the string to validate
     */
    private void validate(String localTime) {
        LocalTimeValidator validator = new LocalTimeValidator();
        if (!validator.validate(localTime))
            throw new IllegalArgumentException(
                    "Incorrect input string");
    }

    /**
     * Initializes the LocalTime.
     *
     * @param localTime the input localTime string.
     */
    private void initialize(String localTime) {
        StringTokenizer stringTokenizer = new StringTokenizer(localTime, ":");
        this.hour = new Hour(Integer.parseInt(stringTokenizer.nextToken()));
        this.minute = new Minute(Integer.parseInt(stringTokenizer.nextToken()));
        this.second = new Second(Integer.parseInt(stringTokenizer.nextToken()));
    }

    /**
     * @return the hour component of the LocalTime
     */
    public Hour getHour() {
        return hour;
    }

    /**
     * @return the minute component of the LocalTime
     */
    public Minute getMinute() {
        return minute;
    }

    /**
     * @return the second component of the LocalTime
     */
    public Second getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "LocalTime [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
    }

}
