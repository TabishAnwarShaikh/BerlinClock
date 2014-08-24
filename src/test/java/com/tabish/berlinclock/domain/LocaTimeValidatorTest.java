package com.tabish.berlinclock.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.tabish.berlinclock.domain.LocalTimeValidator;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class LocaTimeValidatorTest {

    private boolean expected;
    private String localTime;

    private LocalTimeValidator localTimeValidator;

    @Before
    public void initData() {
        localTimeValidator = new LocalTimeValidator();
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{{true, "00:00:00"}, {true, "23:59:59"}, {true, "01:00:00"},
                {true, "13:00:00"}, {true, "23:00:00"}, {true, "01:01:01"}, {true, "24:00:00"},
                {false, "00:60:00"}, {false, "00:00:60"}, {false, "aa:£$:)("}, {false, "123:123:123"},
                {false, "!¬£$%^&*()@:~#';:!¬£$%^&*()@:~#';:!¬£$%^&*()@:~#';"}});
    }

    public LocaTimeValidatorTest(boolean expected, String input) {
        this.expected = expected;
        this.localTime = input;

    }

    @Test
    public void testLocalTimeValidator() {
        Assert.assertEquals(expected, this.localTimeValidator.validate(localTime));
    }

}
