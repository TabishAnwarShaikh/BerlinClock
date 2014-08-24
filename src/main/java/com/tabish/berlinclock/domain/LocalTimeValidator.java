package com.tabish.berlinclock.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates the input string.
 * <p/>
 * Expects input string "hh:mm:ss" to be a valid representation of the current time.
 * <p/>
 * Valid string are e.g.
 * <ul>
 * <li>00:00:00</li>
 * <li>23:59:59</li>
 * <li>24:00:00</li>
 * <li>13:01:10</li>
 * </ul>
 */
class LocalTimeValidator {

    /**
     * Regular expression representing a valid input string for anything from 00:00:00 to 23:59:59
     */
    private static final String LOCALTIME_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
    /**
     * Regular expression representing 24 hours i.e. 24:00:00
     */
    private static final String LOCALTIME_24HOURS_PATTERN = "24:00:00";

    /**
     * Validates the input localTime string.
     *
     * @param localTime the input string
     * @return true if valid , false if not valid.
     */
    public boolean validate(String localTime) {
        Matcher matcher;
        matcher = Pattern.compile(LOCALTIME_24HOURS_PATTERN).matcher(localTime);
        if (matcher.matches())
            return true;

        matcher = Pattern.compile(LOCALTIME_PATTERN).matcher(localTime);
        return matcher.matches();
    }

}
