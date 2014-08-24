package com.tabish.berlinclock.domain.lamp;

import com.tabish.berlinclock.domain.LocalTime;
import com.tabish.berlinclock.domain.lamp.Lamp;
import com.tabish.berlinclock.domain.lamp.TwoSecondsLamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Unit Tests for the {@link com.tabish.berlinclock.domain.lamp.TwoSecondsLamp}
 */
@RunWith(value = Parameterized.class)
public class TwoSecondsLampTest {

    private String input;
    private char expected;

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{{"00:00:00", 'Y'},
                {"00:00:01", 'O'}, {"00:00:02", 'Y'}, {"00:00:30", 'Y'}, {"00:00:59", 'O'}
        });
    }

    public TwoSecondsLampTest(String input, char expected) {
        this.input = input;
        this.expected = expected;
    }


    @Test
    public void test() {
        LocalTime localTime = new LocalTime(this.input);
        Lamp lamp = new TwoSecondsLamp(localTime);
        Assert.assertEquals(this.expected, lamp.state());
    }
}
