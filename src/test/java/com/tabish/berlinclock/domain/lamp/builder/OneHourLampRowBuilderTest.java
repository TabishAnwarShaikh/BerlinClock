package com.tabish.berlinclock.domain.lamp.builder;

import com.tabish.berlinclock.domain.LocalTime;
import com.tabish.berlinclock.domain.lamp.Lamp;
import com.tabish.berlinclock.domain.lamp.OneHourLamp;
import com.tabish.berlinclock.domain.lamp.builder.LampRowBuilder;
import com.tabish.berlinclock.domain.lamp.builder.OneHourLampRowBuilder;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Test class to test the {@link OneHourLampRowBuilder}
 */
public class OneHourLampRowBuilderTest {

    @Test
    public void testCollectionSize() {
        LocalTime localTime = new LocalTime("00:00:00");
        LampRowBuilder builder = new OneHourLampRowBuilder();
        List<Lamp> collection = builder.build(localTime);
        assertThat("collection size", collection.size(), equalTo(4));
    }

    @Test
    public void testCollectionObjects() {
        LocalTime localTime = new LocalTime("00:00:00");
        LampRowBuilder builder = new OneHourLampRowBuilder();
        List<Lamp> collection = builder.build(localTime);
        for (Lamp lamp : collection) {
            assertThat("collection object type", lamp, instanceOf(OneHourLamp.class));
        }
    }

}
