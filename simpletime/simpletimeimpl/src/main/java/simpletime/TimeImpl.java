package simpletime;

import simpletimeapi.Duration;
import simpletimeapi.Time;

import java.util.Objects;

public class TimeImpl implements Time {

    private final int minutes;

    private final int hours;

    public TimeImpl(int hours, int minutes) {
        int totalMins = hours * 60 + minutes;
        if (totalMins < 0 || totalMins >= 60*24)
            throw new IllegalArgumentException("Invalid time");

        this.hours = totalMins / 60;
        this.minutes = totalMins - (this.hours * 60);
    }

    @Override
    public Time addTime(Time t) {
        return this.addTime(t.asMinutes());
    }

    @Override
    public Time addTime(int minutes) {
        int totalMins = this.asMinutes() + minutes;
        int totalHours = totalMins / 60;
        int hours = totalHours % 24;
        int mins = totalMins - (totalHours * 60);
        return new TimeImpl(hours, mins);
    }

    @Override
    public int getHours() {
        return this.hours;
    }

    @Override
    public int getMinutes() {
        return this.minutes;
    }

    @Override
    public Duration until(Time other) {
        return new DurationImpl(other.asMinutes() - this.asMinutes());
    }

    @Override
    public int compareTo(Time o) {
        return this.asMinutes() - o.asMinutes();
    }

    @Override
    public String toString() {
        String mins = String.valueOf(this.minutes);
        String hours = String.valueOf(this.hours);
        if (this.minutes < 10) {
            mins = "0" + mins;
        }
        if (this.hours < 10) {
            hours = "0" + hours;
        }
        return hours + ":" + mins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeImpl time = (TimeImpl) o;
        return minutes == time.minutes && hours == time.hours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutes, hours);
    }
}
