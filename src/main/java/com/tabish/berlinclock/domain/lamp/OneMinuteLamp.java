package com.tabish.berlinclock.domain.lamp;

import com.tabish.berlinclock.domain.LocalTime;

/**
 * Lamp representing the one minute duration on the Berlin Clock.
 */
public final class OneMinuteLamp extends AbstractLamp {

    /**
     * Constructs a lamp representing one minute on the Berlin Clock.
     *
     * @param localTime the {@link LocalTime} of the day, not null.
     * @param position  the index of the lamp in its row, greater then 0 and less then 5.
     */
    public OneMinuteLamp(LocalTime localTime, int position) {
        super(localTime, position);
    }

    @Override
    protected void assignColor() {
        this.color = 'Y';
    }

    @Override
    protected void setState(LocalTime localTime) {
        int currentPosition = localTime.getMinute().value() % 5;
        if (currentPosition == 0)
            switchOff();
        if (currentPosition >= position && currentPosition > 0)
            switchOn();
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
        return "OneMinuteLamp [position=" + position + ", on=" + on + ", color=" + color + "]";
    }

}
