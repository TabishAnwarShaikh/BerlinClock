package com.tabish.berlinclock.domain.lamp;

import com.tabish.berlinclock.domain.LocalTime;

/**
 * Lamp representing the two seconds duration on the Berlin Clock.
 */
public final class TwoSecondsLamp extends AbstractLamp {

    /**
     * Single two seconds lamp on the Berlin clock.
     */
    private static final int position = 1;

    /**
     * Constructs a lamp representing two seconds on the Berlin Clock.
     *
     * @param localTime the {@link LocalTime} of the day, not null.
     */
    public TwoSecondsLamp(LocalTime localTime) {
        super(localTime, position);
    }

    @Override
    protected void assignColor() {
        this.color = 'Y';
    }

    @Override
    protected void setState(LocalTime localTime) {
        if (localTime.getSecond().value() % 2 == 0)
            on = !on;
    }

    /**
     * Gets the color character code of the lamp, depending on its state.
     *
     * @return 'O' if the lamp is off, 'Y' if the lamp is on.
     */
    @Override
    public char state() {
        if (on)
            return color;
        else
            return 'O';
    }

    @Override
    public String toString() {
        return "TwoSecondsLamp [on=" + on + ", color=" + color + "]";
    }

}
