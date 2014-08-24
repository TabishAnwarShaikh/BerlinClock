package com.tabish.berlinclock.domain;

/**
 * Represents the hour part of current hour of the day i.e. from 00 to 24
 */

public class Hour {

    private final int value;

    /**
     * Constructor to create the hour object
     *
     * @param value the hour of the day.
     */
    public Hour(int value) {
        this.value = value;
        validate();
    }

    /**
     * @return the value of the hour
     */
    public int value() {
        return this.value;
    }

    /**
     * Validates the hour
     */
    private void validate() {
        if (this.value < 0 || this.value > 24)
            throw new IllegalArgumentException("Invalid hour, hour needs to be between 0-24");
    }

}
