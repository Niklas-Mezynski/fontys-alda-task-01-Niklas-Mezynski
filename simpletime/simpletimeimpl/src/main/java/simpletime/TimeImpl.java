package simpletime;

import simpletimeapi.Duration;
import simpletimeapi.Time;

public class TimeImpl implements Time {

    private int minutes;
    private int hours;

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
        return null;
    }

    @Override
    public int compareTo(Time o) {
        return 0;
    }

    @Override
    public String toString() {
        String mins = String.valueOf(minutes);
        if (this.minutes < 10) {
            mins = "0" + mins;
        }
        return this.hours + ":" + mins;
    }
}
