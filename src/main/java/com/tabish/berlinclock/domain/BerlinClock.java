package com.tabish.berlinclock.domain;

import com.tabish.berlinclock.domain.lamp.Lamp;
import com.tabish.berlinclock.domain.lamp.builder.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing the The Berlin Uhr (Clock).
 * <p/>
 * The Berlin Uhr (Clock) is a rather strange way to show the time.
 * <p/>
 * On the top of the clock there is a yellow lamp that blinks on/off every two
 * seconds.
 * <p/>
 * The time is calculated by adding rectangular lamps.
 * <p/>
 * The top two rows of lamps are red. These indicate the hours of a day. In the
 * top row there are 4 red lamps. Every lamp represents 5 hours. In the lower
 * row of red lamps every lamp represents 1 hour. So if two lamps of the first
 * row and three of the second row are switched on that indicates 5+5+3=13h or 1
 * pm.
 * <p/>
 * The two rows of lamps at the bottom count the minutes. The first of these
 * rows has 11 lamps, the second 4. In the first row every lamp represents 5
 * minutes. In this first row the 3rd, 6th and 9th lamp are red and indicate the
 * first quarter, half and last quarter of an hour. The other lamps are yellow.
 * In the last row with 4 lamps every lamp represents 1 minute.
 * <p/>
 * <a href="http://uniqueclocks.co.uk/media/berlin~clock.jpg~1.gif">One can be
 * seen here</a><img src="http://uniqueclocks.co.uk/media/berlin~clock.jpg~1.gif">
 */

public final class BerlinClock {

    /**
     * Collection of collection representing the rows of the Berlin Clock.
     */
    private List<List<Lamp>> lampCollection = new ArrayList<List<Lamp>>();

    /**
     * Represents the local time of the day.
     */
    private LocalTime localTime;

    /**
     * Constructs the Berlin Clock
     *
     * @param localTime the input string representing a valid local time of the day in
     *                  the format "hh:mm:ss", not null and not empty.
     */
    public BerlinClock(String localTime) {
        validate(localTime);
        initialize(localTime.trim());
    }

    /**
     * Validates the input for null and empty string
     *
     * @param localTime the input string representing a valid local time of the day.
     */
    private void validate(String localTime) {
        if (localTime == null)
            throw new IllegalArgumentException("Input String cannot be null");
        if (localTime.trim().length() == 0)
            throw new IllegalArgumentException("Input String cannot be empty");
    }


    /**
     * Sets up the Berlin Clock.
     *
     * @param localTime the string representing the local time of the day.
     */
    private void initialize(String localTime) {
        this.localTime = new LocalTime(localTime);
        lampCollection.add(getTwoSecondLampCollection());
        lampCollection.add(getFiveHourLampCollection());
        lampCollection.add(getOneHourLampCollection());
        lampCollection.add(getFiveMinuteLampCollection());
        lampCollection.add(getOneMinuteLampCollection());
    }

    /**
     * Builds the Two Seconds row of the Berlin Clock.
     *
     * @return the list consisting of a single lamp representing 2 seconds.
     */
    private List<Lamp> getTwoSecondLampCollection() {
        LampRowBuilder builder = new TwoSecondsLampRowBuilder();
        return builder.build(this.localTime);
    }

    /**
     * Builds the Five Hour row of the Berlin Clock.
     *
     * @return the list consisting of a four lamps each representing 5 hours.
     */
    private List<Lamp> getFiveHourLampCollection() {
        LampRowBuilder builder = new FiveHourLampRowBuilder();
        return builder.build(this.localTime);
    }

    /**
     * Builds the One Hour row of the Berlin Clock.
     *
     * @return the list consisting of a four lamps each representing 1 hour.
     */
    private List<Lamp> getOneHourLampCollection() {
        LampRowBuilder builder = new OneHourLampRowBuilder();
        return builder.build(this.localTime);
    }

    /**
     * Builds the Five Minute row of the Berlin Clock.
     *
     * @return the list consisting of a eleven lamps each representing 5
     *         minutes.
     */
    private List<Lamp> getFiveMinuteLampCollection() {
        LampRowBuilder builder = new FiveMinuteLampRowBuilder();
        return builder.build(this.localTime);
    }

    /**
     * Builds the One Minute row of the Berlin Clock.
     *
     * @return the list consisting of a eleven lamps each representing 1
     *         minutes.
     */
    private List<Lamp> getOneMinuteLampCollection() {
        LampRowBuilder builder = new OneMinuteLampRowBuilder();
        return builder.build(this.localTime);
    }

    /**
     * Gets the time of the Berlin clock by reading the state of the lamps.
     * e.g. for local time "00:00:00" following string will be returned.
     * <p/>
     * Y<br>OOOO<br>OOOO<br>OOOOOOOOOOO<br>OOOO
     * <p/>
     *
     * @return the string representation of the Berlin Clock
     */
    public String getTimeAsString() {
        char newLineChar = '\n';
        StringBuilder stringBuilder = new StringBuilder();

        for (List<Lamp> lamps : lampCollection) {
            for (Lamp lamp : lamps)
                stringBuilder.append(lamp.state());

            stringBuilder.append(newLineChar);
        }

        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    @Override
    public String toString() {
        return "BerlinClock{" +
                "localTime=" + localTime + '\n' +
                "state=" + getTimeAsString() +
                '}';
    }
}
