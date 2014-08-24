package com.tabish.berlinclock.domain;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.tabish.berlinclock.domain.BerlinClock;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ValidBerlinClockTest {

    private String input;
    private String expected;


    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{{"00:00:00", "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO"},
                {"23:59:59", "O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY"},
                {"13:17:01", "O\nRROO\nRRRO\nYYROOOOOOOO\nYYOO"},
                {"24:00:00", "Y\nRRRR\nRRRR\nOOOOOOOOOOO\nOOOO"},
        });
    }

    public ValidBerlinClockTest(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testBerlinClock() {
        BerlinClock clock = new BerlinClock(this.input);
        Assert.assertEquals(this.expected, clock.getTimeAsString());
    }

}
