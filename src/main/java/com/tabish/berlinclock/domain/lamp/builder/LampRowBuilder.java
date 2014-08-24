package com.tabish.berlinclock.domain.lamp.builder;

import com.tabish.berlinclock.domain.LocalTime;
import com.tabish.berlinclock.domain.lamp.Lamp;

import java.util.List;

/**
 * A builder that builds a row of {@link Lamp} objects on the Berlin Clock.
 */
public interface LampRowBuilder {

    /**
     * Builds a row of {@link Lamp} objects.
     *
     * @param localTime the {@link LocalTime} of the day.
     * @return the list(row) of Lamp objects.
     */
    public List<Lamp> build(LocalTime localTime);

}
