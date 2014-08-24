package com.tabish.berlinclock.domain;

/**
 * Represents the second part of current minute of the day i.e. from 00 to 59
 */
public class Second {

    private final int value;

    /**
     * Constructor to create the second object
     *
     * @param value the second within the current minute of the day.
     */
    public Second(int value) {
        this.value = value;
        validate();
    }

    /**
     * @return the value of the second
     */
    public int value() {
        return this.value;
    }

    /**
     * Validates the second
     */
    private void validate() {
        if (this.value < 0 || this.value > 59)
            throw new IllegalArgumentException("Invalid second, second needs to be between 0-59");
    }

    @Override
    public String toString() {
        return "Second [value=" + value + "]";
    }

}
