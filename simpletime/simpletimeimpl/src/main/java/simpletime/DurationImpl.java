package simpletime;

import java.util.Objects;

public class DurationImpl implements simpletimeapi.Duration {

    private final int totalMinutes;

    public DurationImpl(int hours, int minutes) {
        this.totalMinutes = hours * 60 + minutes;
    }

    public DurationImpl(int lengthInMinutes) {
        this.totalMinutes = lengthInMinutes;
    }

    @Override
    public simpletimeapi.Duration plus(simpletimeapi.Duration duration) {
        return new DurationImpl(this.asMinutes() + duration.asMinutes());
    }

    @Override
    public int getHours() {
        return this.totalMinutes / 60;
    }

    @Override
    public int getMinutes() {
        return this.totalMinutes % 60;
    }

    @Override
    public int asMinutes() {
        return this.totalMinutes;
    }

    @Override
    public int compareTo(simpletimeapi.Duration o) {
        return this.asMinutes() - o.asMinutes();
    }

    @Override
    public String toString() {
        return this.totalMinutes + " minutes";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DurationImpl duration = (DurationImpl) o;
        return totalMinutes == duration.totalMinutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalMinutes);
    }
}
