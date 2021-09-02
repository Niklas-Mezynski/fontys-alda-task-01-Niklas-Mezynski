/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package simpletimeapi;

/**
 * Length between two Times.
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public interface Duration extends Comparable<Duration> {

    /**
     * Adds a duration to this duration.
     *
     * @param duration˙to add
     * @return a new Duration object
     */
    Duration plus( Duration duration );

    /**
     * Just a getter. For a duration of 2:45, it returns 2.
     *
     * @return the amount of hours in this duration.
     */
    int getHours();

    /**
     * Just a getter. For a duration of 1:45, it returns 45.
     *
     * @return the amount of minutes in this duration.
     */
    int getMinutes();

    /**
     * Get this duration as a number of minutes. For a duration of 1:45, it
     * returns 60+45=105.
     *
     * @return minutes
     */
    int asMinutes();

}
