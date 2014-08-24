package com.tabish.berlinclock.domain.lamp.builder;

import com.tabish.berlinclock.domain.LocalTime;
import com.tabish.berlinclock.domain.lamp.FiveHourLamp;
import com.tabish.berlinclock.domain.lamp.Lamp;
import com.tabish.berlinclock.domain.lamp.builder.FiveHourLampRowBuilder;
import com.tabish.berlinclock.domain.lamp.builder.LampRowBuilder;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Test class to test the {@link FiveHourLampRowBuilder}
 */
public class FiveHourLampRowBuilderTest {

    @Test
    public void testCollectionSize() {
        LocalTime localTime = new LocalTime("00:00:00");
        LampRowBuilder builder = new FiveHourLampRowBuilder();
        List<Lamp> collection = builder.build(localTime);
        assertThat("collection size", collection.size(), equalTo(4));
    }

    @Test
    public void testCollectionObjects() {
        LocalTime localTime = new LocalTime("00:00:00");
        LampRowBuilder builder = new FiveHourLampRowBuilder();
        List<Lamp> collection = builder.build(localTime);
        for (Lamp lamp : collection) {
            assertThat("collection object type", lamp, instanceOf(FiveHourLamp.class));
        }
    }

}
