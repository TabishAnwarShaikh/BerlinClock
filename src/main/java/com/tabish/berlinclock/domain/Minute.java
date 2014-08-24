package com.tabish.berlinclock.domain;

/**
 * Represents the minute part of current hour of the day i.e. from 00 to 59
 */
public class Minute {

    private final int value;

    /**
     * Constructor to create the minute object
     *
     * @param value the minute within the current hour of the day.
     */
    public Minute(int value) {
        this.value = value;
        validate();
    }

    /**
     * @return the value of the minute
     */
    public int value() {
        return this.value;
    }

    /**
     * Validates the minute
     */
    private void validate() {
        if (this.value < 0 || this.value > 59)
            throw new IllegalArgumentException("Invalid minute, minute needs to be between 0-59");
    }

}
