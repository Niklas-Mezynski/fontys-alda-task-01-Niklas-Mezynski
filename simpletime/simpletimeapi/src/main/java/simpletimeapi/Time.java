/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package simpletimeapi;

/**
 * The unit of points in Time (instant; like java.time.Instant) and duration (as
 * used in this appointment planner application).
 *
 * All Time instances are ALWAYS normalized. Normalizing results in: <ul>
 * <li>The range for the hours field is {@code [0, 24)} </li>
 * <li>The range for the minutes field is {@code [0, 60)} </li>
 * </ul>
 *
 * Hints to implementer:
 * <ul>
 * <li>Assuming that you have a constructor or a factory method that takes an
 * hours and a minutes parameter, compute the total number of minutes. If this
 * total is less than 0 or greater equal than 24 * 60, an
 * IllegalArgumentException with an appropriate message should be thrown.
 * Otherwise, compute the number of hours and minutes from this total. This
 * implies that negative minutes as parameter value might be allowed.</li>
 * <li>It might be useful to have a method {@code int asMinutes()} that returns
 * the number of minutes since midnight.</li>
 * <li>Override the methods toString(), equals() and hashCode(). toString
 * returns Time in hh:mm format. </li>
 * </ul>
 *
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public interface Time extends Comparable<Time> {

    /**
     * A given time is added to this time. The result is returned as a new Time
     * object. If you had 2 hours to a time of 23:00, the result should be 01:00
     *
     * @param t The time that will be added to this time.
     * @return The Time object as a result of adding t to this time.
     */
    Time addTime( Time t );

    /**
     * Add number of minutes to this time. The result is returned as a new Time
     * object.
     *
     * @param minutes The amount to add to this time.
     * @return The new Time object
     */
    Time addTime( int minutes );

    /**
     * Getter for hours of this Time.
     *
     * @return hour value of this Time object.
     */
    int getHours();

    /**
     * Getter for minutes of this Time.
     *
     * @return minutes value of this Time object.
     */
    int getMinutes();

    /**
     * This method tests if this time is before the given other time.
     *
     * @param other The Time object to compare with.
     * @return true if this time is before other.
     */
    default boolean isBefore( Time other ) {
        return this.compareTo( other ) < 0;
    }

    /**
     * This method tests if this time is before or equal to the given other
     * time.
     *
     * @param other The Time object to compare with.
     * @return true if this time is before or equal to other.
     */
    default boolean isBeforeOrEqual( Time other ) {
        return this.compareTo( other ) <= 0;
    }

    /**
     * Return the number of minutes since midnight.
     *
     * @return the minutes
     */
    default int asMinutes() {
        return getHours() * 60 + getMinutes();
    }

    /**
     * Compute the distance to a point in the future from this time, expressed
     * as duration.
     *
     * @param other time after this time
     * @return the time difference as duration.
     */
    Duration until( Time other );

}
