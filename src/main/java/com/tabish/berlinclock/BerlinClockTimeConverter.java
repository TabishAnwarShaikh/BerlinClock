package com.tabish.berlinclock;

import com.tabish.berlinclock.domain.BerlinClock;

/**
 * A {@link BerlinClock} time converter.
 * <p/>
 */
public class BerlinClockTimeConverter implements TimeConverter {

    /**
     * @param aTime the string representing the time of the day in "hh:mm:ss" format.
     *              <br>Example of valid string are -
     *              <ul>
     *              <li>00:00:00</li>
     *              <li>23:59:59</li>
     *              <li>24:00:00</li>
     *              <li>13:01:10</li>
     *              </ul>
     */
    @Override
    public String convertTime(String aTime) {
        BerlinClock berlinClock = new BerlinClock(aTime);
        return berlinClock.getTimeAsString();
    }

}
