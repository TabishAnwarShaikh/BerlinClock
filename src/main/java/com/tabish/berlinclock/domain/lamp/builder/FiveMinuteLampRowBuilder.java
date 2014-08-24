package com.tabish.berlinclock.domain.lamp.builder;

import com.tabish.berlinclock.domain.LocalTime;
import com.tabish.berlinclock.domain.lamp.FiveMinuteLamp;
import com.tabish.berlinclock.domain.lamp.Lamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Builds a collection representing the five minute row of the
 * Berlin Clock consisting of eleven {@link FiveMinuteLamp}
 */
public class FiveMinuteLampRowBuilder implements LampRowBuilder {

    private static final int numberOfLamps = 11;

    @Override
    public List<Lamp> build(LocalTime localTime) {

        List<Lamp> collection = new ArrayList<Lamp>();
        for (int position = 1; position <= numberOfLamps; position++) {
            Lamp lamp = new FiveMinuteLamp(localTime, position);
            collection.add(lamp);
        }

        return collection;
    }

}
