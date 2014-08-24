package com.tabish.berlinclock.domain.lamp.builder;

import com.tabish.berlinclock.domain.LocalTime;
import com.tabish.berlinclock.domain.lamp.Lamp;
import com.tabish.berlinclock.domain.lamp.TwoSecondsLamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Builds a collection representing the two seconds row of the
 * Berlin Clock consisting of a single {@link TwoSecondsLamp}
 */
public class TwoSecondsLampRowBuilder implements LampRowBuilder {

    @Override
    public List<Lamp> build(LocalTime localTime) {

        List<Lamp> collection = new ArrayList<Lamp>();
        Lamp lamp = new TwoSecondsLamp(localTime);
        collection.add(lamp);
        return collection;
    }

}
