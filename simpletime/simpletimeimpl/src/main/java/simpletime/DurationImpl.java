package simpletime;

public class DurationImpl implements simpletimeapi.Duration {

    private int totalMinutes;

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
}
