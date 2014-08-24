package com.tabish.berlinclock.domain.lamp.builder;

import com.tabish.berlinclock.domain.LocalTime;
import com.tabish.berlinclock.domain.lamp.FiveHourLamp;
import com.tabish.berlinclock.domain.lamp.Lamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Builds a collection representing the five hour row of the
 * Berlin Clock consisting of four {@link FiveHourLamp}
 */
public class FiveHourLampRowBuilder implements LampRowBuilder {

    private static final int numberOfLamps = 4;

    @Override
    public List<Lamp> build(LocalTime localTime) {

        List<Lamp> collection = new ArrayList<Lamp>();
        for (int position = 1; position <= numberOfLamps; position++) {
            Lamp lamp = new FiveHourLamp(localTime, position);
            collection.add(lamp);
        }

        return collection;
    }

}
