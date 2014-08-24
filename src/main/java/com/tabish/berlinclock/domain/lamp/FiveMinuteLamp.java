package com.tabish.berlinclock.domain.lamp;

import com.tabish.berlinclock.domain.LocalTime;

/**
 * Lamp representing the five minute duration on the Berlin Clock.
 */
public final class FiveMinuteLamp extends AbstractLamp {

    /**
     * Constructs a lamp representing five minutes on the Berlin Clock.
     *
     * @param localTime the {@link LocalTime} of the day, not null.
     * @param position  the index of the lamp in its row, greater then 0 and less then 12
     */
    public FiveMinuteLamp(LocalTime localTime, int position) {
        super(localTime, position);
    }

    /**
     * If the position of the lamp is 3rd,6th or 9th then the color of the lamp is 'R' else 'Y'.
     */
    @Override
    protected void assignColor() {
        if (this.position % 3 == 0)
            this.color = 'R';
        else
            this.color = 'Y';
    }

    @Override
    protected void setState(LocalTime localTime) {
        int minutes = localTime.getMinute().value();
        int currentPosition = minutes / 5;
        if (minutes == 60 || minutes == 0)
            switchOff();
        if (currentPosition >= position)
            switchOn();
    }

    /**
     * Gets the color character code of the lamp, depending on its state.
     * <p/>
     *
     * @return 'O' if the lamp is off, if on - for lamps in 3rd, 6th or 9th position 'R' else 'Y'.
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
        return "FiveMinuteLamp [position=" + position + ", on=" + on + ", color=" + color + "]";
    }

}
