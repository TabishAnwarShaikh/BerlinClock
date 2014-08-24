package com.tabish.berlinclock.domain.lamp.builder;

import com.tabish.berlinclock.domain.LocalTime;
import com.tabish.berlinclock.domain.lamp.FiveMinuteLamp;
import com.tabish.berlinclock.domain.lamp.Lamp;
import com.tabish.berlinclock.domain.lamp.builder.FiveMinuteLampRowBuilder;
import com.tabish.berlinclock.domain.lamp.builder.LampRowBuilder;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Test class to test the {@link FiveMinuteLampRowBuilder}
 */
public class FiveMinuteLampRowBuilderTest {

    @Test
    public void testCollectionSize() {
        LocalTime localTime = new LocalTime("00:00:00");
        LampRowBuilder builder = new FiveMinuteLampRowBuilder();
        List<Lamp> collection = builder.build(localTime);
        assertThat("collection size", collection.size(), equalTo(11));
    }

    @Test
    public void testCollectionObjects() {
        LocalTime localTime = new LocalTime("00:00:00");
        LampRowBuilder builder = new FiveMinuteLampRowBuilder();
        List<Lamp> collection = builder.build(localTime);
        for (Lamp lamp : collection) {
            assertThat("collection object type", lamp, instanceOf(FiveMinuteLamp.class));
        }
    }
}
