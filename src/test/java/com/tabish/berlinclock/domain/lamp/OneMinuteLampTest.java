package com.tabish.berlinclock.domain.lamp;

import com.tabish.berlinclock.domain.LocalTime;
import com.tabish.berlinclock.domain.lamp.Lamp;
import com.tabish.berlinclock.domain.lamp.OneMinuteLamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Unit Tests for the {@link com.tabish.berlinclock.domain.lamp.OneMinuteLamp}
 */
@RunWith(value = Parameterized.class)
public class OneMinuteLampTest {

    private String input;
    private int position;
    private char expected;

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{{"00:00:00", 1, 'O'}, {"00:00:00", 2, 'O'}, {"00:00:00", 3, 'O'}, {"00:00:00", 4, 'O'},
                {"23:59:59", 1, 'Y'}, {"23:59:59", 2, 'Y'}, {"23:59:59", 3, 'Y'}, {"23:59:59", 4, 'Y'},
                {"24:00:00", 1, 'O'}, {"24:00:00", 2, 'O'}, {"24:00:00", 3, 'O'}, {"24:00:00", 4, 'O'},
                {"13:17:01", 1, 'Y'}, {"13:17:01", 2, 'Y'}, {"13:17:01", 3, 'O'}, {"13:17:01", 4, 'O'}
        });
    }

    public OneMinuteLampTest(String input, int position, char expected) {
        this.input = input;
        this.position = position;
        this.expected = expected;
    }


    @Test
    public void test() {
        LocalTime localTime = new LocalTime(this.input);
        Lamp lamp = new OneMinuteLamp(localTime, this.position);
        Assert.assertEquals(this.expected, lamp.state());
    }
}
