package com.tabish.berlinclock.domain.lamp;

import com.tabish.berlinclock.domain.LocalTime;
import com.tabish.berlinclock.domain.lamp.FiveMinuteLamp;
import com.tabish.berlinclock.domain.lamp.Lamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Unit Tests for the {@link com.tabish.berlinclock.domain.lamp.FiveMinuteLamp}
 */
@RunWith(value = Parameterized.class)
public class FiveMinuteLampTest {

    private String input;
    private int position;
    private char expected;

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"00:00:00", 1, 'O'}, {"00:00:00", 2, 'O'}, {"00:00:00", 3, 'O'}, {"00:00:00", 4, 'O'},
                {"00:00:00", 5, 'O'}, {"00:00:00", 6, 'O'}, {"00:00:00", 7, 'O'}, {"00:00:00", 8, 'O'},
                {"00:00:00", 9, 'O'}, {"00:00:00", 10, 'O'}, {"00:00:00", 11, 'O'},

                {"23:59:59", 1, 'Y'}, {"23:59:59", 2, 'Y'}, {"23:59:59", 3, 'R'}, {"23:59:59", 4, 'Y'},
                {"23:59:59", 5, 'Y'}, {"23:59:59", 6, 'R'}, {"23:59:59", 7, 'Y'}, {"23:59:59", 8, 'Y'},
                {"23:59:59", 9, 'R'}, {"23:59:59", 10, 'Y'}, {"23:59:59", 11, 'Y'},

                {"24:00:00", 1, 'O'}, {"24:00:00", 2, 'O'}, {"24:00:00", 3, 'O'}, {"24:00:00", 4, 'O'},
                {"24:00:00", 5, 'O'}, {"24:00:00", 6, 'O'}, {"24:00:00", 7, 'O'}, {"24:00:00", 8, 'O'},
                {"24:00:00", 9, 'O'}, {"24:00:00", 10, 'O'}, {"24:00:00", 11, 'O'},

                {"13:17:01", 1, 'Y'}, {"13:17:01", 2, 'Y'}, {"13:17:01", 3, 'R'}, {"13:17:01", 4, 'O'},
                {"13:17:01", 5, 'O'}, {"13:17:01", 6, 'O'}, {"13:17:01", 7, 'O'}, {"13:17:01", 8, 'O'},
                {"13:17:01", 9, 'O'}, {"13:17:01", 10, 'O'}, {"13:17:01", 11, 'O'}
        });
    }

    public FiveMinuteLampTest(String input, int position, char expected) {
        this.input = input;
        this.position = position;
        this.expected = expected;
    }


    @Test
    public void test() {
        LocalTime localTime = new LocalTime(this.input);
        Lamp lamp = new FiveMinuteLamp(localTime, this.position);
        Assert.assertEquals(this.expected, lamp.state());
    }
}
