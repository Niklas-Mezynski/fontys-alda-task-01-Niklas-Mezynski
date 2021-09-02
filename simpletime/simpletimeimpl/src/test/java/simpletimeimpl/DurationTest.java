package simpletimeimpl;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import simpletimeapi.AbstractAPFactory;
import simpletimeapi.Duration;

import static org.assertj.core.api.Assertions.*;

public class DurationTest {

    static AbstractAPFactory factory = ServiceFinder.getFactory();

    @ParameterizedTest
    @CsvSource({
            "120, 2, 0, 120",
            "69, 1, 9, 69"
    })
    void t01TestGetters(int durationInMins, int hours, int minutes, int totalMinutes) {
        Duration duration = factory.createDuration(durationInMins);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(duration.getHours()).isEqualTo(hours);
            s.assertThat(duration.getMinutes()).isEqualTo(minutes);
            s.assertThat(duration.asMinutes()).isEqualTo(totalMinutes);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "2, 30, 2, 30, 150",
            "1, 75, 2, 15, 135"
    })
    void t02TestGettersWithOtherConstructor(int durationInputMin, int durationInputHours, int hours, int minutes, int totalMinutes) {
        Duration duration = factory.createDuration(durationInputHours, durationInputMin);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(duration.getHours()).isEqualTo(hours);
            s.assertThat(duration.getMinutes()).isEqualTo(minutes);
            s.assertThat(duration.asMinutes()).isEqualTo(totalMinutes);
        });
    }

}
