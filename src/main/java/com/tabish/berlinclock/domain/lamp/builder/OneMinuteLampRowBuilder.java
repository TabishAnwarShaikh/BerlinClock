package com.tabish.berlinclock.domain.lamp.builder;

import com.tabish.berlinclock.domain.LocalTime;
import com.tabish.berlinclock.domain.lamp.Lamp;
import com.tabish.berlinclock.domain.lamp.OneMinuteLamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Builds a collection representing the one minute row of the
 * Berlin Clock consisting of four {@link OneMinuteLamp}
 */
public class OneMinuteLampRowBuilder implements LampRowBuilder {

    private static final int numberOfLamps = 4;

    @Override
    public List<Lamp> build(LocalTime localTime) {

        List<Lamp> collection = new ArrayList<Lamp>();
        for (int position = 1; position <= numberOfLamps; position++) {
            Lamp lamp = new OneMinuteLamp(localTime, position);
            collection.add(lamp);
        }

        return collection;
    }

}
