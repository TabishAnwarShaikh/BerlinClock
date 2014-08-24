package com.tabish.berlinclock.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.tabish.berlinclock.domain.BerlinClock;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class InValidBerlinClockTest {

    private String input;

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{{"24:01:01"}, {" "}, {null}});
    }

    public InValidBerlinClockTest(String input) {
        this.input = input;

    }

    @Test(expected = IllegalArgumentException.class)
    public void testBerlinClock() {
        BerlinClock clock = new BerlinClock(this.input);
    }

}
