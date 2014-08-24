package com.tabish.berlinclock.domain.lamp;

import com.tabish.berlinclock.domain.LocalTime;

/**
 * Abstract Lamp class
 */
abstract class AbstractLamp implements Lamp {

    /**
     * The position of the Lamp within its row on the Berlin Clock.
     */
    final int position;
    /**
     * State of the lamp.
     */
    boolean on = false;
    /**
     * Color of the lamp.
     */
    char color;

    /**
     * Constructs a Lamp instance.
     *
     * @param localTime the {@link LocalTime} , not null
     * @param position  the index of the lamp within a row on the Berlin Clock, not null and greater then 0.
     */
    public AbstractLamp(LocalTime localTime, int position) {
        validate(localTime, position);
        this.position = position;
        assignColor();
        setState(localTime);
    }

    /**
     * Validates the input
     *
     * @param localTime the LocalTime , not null
     * @param position  the index of the lamp in its container, greater then 0.
     */
    private void validate(LocalTime localTime, int position) {
        if (position <= 0)
            throw new IllegalArgumentException("Position of the Lamp need to be > 0");
        if (localTime == null)
            throw new IllegalArgumentException("LocalTime cannot be null");
    }

    /**
     * Assign the lamp with a color
     */
    protected abstract void assignColor();

    /**
     * Assigns a new state to the lamp.
     *
     * @param localTime the new {@link LocalTime}.
     */
    protected abstract void setState(LocalTime localTime);

    /**
     * Switching off the lamp
     */
    protected void switchOff() {
        this.on = false;
    }

    /**
     * Switching on the lamp
     */
    protected void switchOn() {
        this.on = true;
    }


}