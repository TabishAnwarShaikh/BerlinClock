package com.tabish.berlinclock.domain.lamp;

import com.tabish.berlinclock.domain.LocalTime;

/**
 * Lamp representing the one hour duration on the Berlin Clock.
 */
public final class OneHourLamp extends AbstractLamp {

    /**
     * Constructs a lamp representing one hour on the Berlin Clock.
     *
     * @param localTime the {@link LocalTime} of the day, not null.
     * @param position  the index of the lamp in its row, greater then 0 and less then 5.
     */
    public OneHourLamp(LocalTime localTime, int position) {
        super(localTime, position);
    }

    @Override
    protected void assignColor() {
        this.color = 'R';
    }

    @Override
    protected void setState(LocalTime localTime) {
        int currentPosition = localTime.getHour().value() % 5;
        if (currentPosition == 0)
            switchOff();
        if (currentPosition >= position)
            switchOn();
    }

    /**
     * Gets the color character code of the lamp, depending on its state.
     *
     * @return 'O' if the lamp is off, 'R' if the lamp is on.
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
        return "OneHourLamp [position=" + position + ", on=" + on + ", color=" + color + "]";
    }

}
