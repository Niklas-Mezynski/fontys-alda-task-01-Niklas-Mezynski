/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package simpletimeapi;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public interface AbstractAPFactory {

    /**
     * Factory method to create an object of type Time.
     *
     * @param hours the number of hours
     * @param minutes the number of minutes, might be negative.
     * @return Time object
     */
    Time createTime( int hours, int minutes );

    /**
     * Factory method to create an object of type Duration. The Duration
     * implementation should have a constructor with two arguments: hours and
     * minutes.
     *
     * @param hours hours part of the duration.
     * @param minutes minutes part of the duration.
     * @return Duration object.
     */
    Duration createDuration( int hours, int minutes );

    /**
     * Factory method to create an object of type Duration.
     *
     * @param lengthInMinutes e.g. 105 minutes
     * @return Duration object.
     */
    Duration createDuration( int lengthInMinutes );

}
