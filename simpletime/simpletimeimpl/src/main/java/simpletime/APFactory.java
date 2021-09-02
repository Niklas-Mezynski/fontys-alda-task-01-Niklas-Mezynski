/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package simpletime;

import simpletimeapi.AbstractAPFactory;
import simpletimeapi.Duration;
import simpletimeapi.Time;
//TODO adapt imports if required


/**
 * Abstract factory to separate student implementations from teachers tests. The
 * instance created by this factory will be black-box tested by the teachers
 * tests.
 *
 * Richard van den Ham {@code r.vandenham@fontys.nl} Pieter van den Hombergh
 * {@code p.vandenhombergh@fontys.nl}
 */
public class APFactory implements AbstractAPFactory {

    /**
     * Required for service loader.
     */
    public APFactory() {
    }

    /**
     * Factory method to create an object of type Time.
     *
     * @param hours the number of hours
     * @param minutes the number of minutes, might be negative.
     * @return Time object
     */
    @Override
    public Time createTime( int hours, int minutes ) {
        //TODO
        return null;
    }

    /**
     * Factory method to create an object of type Duration. The Duration
     * implementation should have a constructor with two arguments: hours and
     * minutes.
     *
     * @param hours hours part of the duration.
     * @param minutes minutes part of the duration.
     * @return Duration object.
     */
    @Override
    public Duration createDuration( int hours, int minutes ) {
        //TODO
        return null;
    }

    /**
     * Factory method to create an object of type Duration.
     *
     * @param lengthInMinutes e.g. 105 minutes
     * @return Duration object.
     */
    @Override
    public Duration createDuration( int lengthInMinutes ) {
        //TODO
        return null;
    }

}
