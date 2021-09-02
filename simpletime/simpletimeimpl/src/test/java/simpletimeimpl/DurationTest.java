package simpletimeimpl;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import simpletimeapi.AbstractAPFactory;
import simpletimeapi.Duration;
import simpletimeapi.Time;

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
    void t02TestGettersWithOtherConstructor(int durationInputHours, int durationInputMin, int hours, int minutes, int totalMinutes) {
        Duration duration = factory.createDuration(durationInputHours, durationInputMin);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(duration.getHours()).isEqualTo(hours);
            s.assertThat(duration.getMinutes()).isEqualTo(minutes);
            s.assertThat(duration.asMinutes()).isEqualTo(totalMinutes);
        });
    }

    @ParameterizedTest
    @CsvSource( {
            "1,2,-1",
            "3,3,0",
            "420,69,1"
    } )
    void t03compareTo(int minutes1, int minutes2, int compareResult) {
        Duration d1 = factory.createDuration(minutes1);
        Duration d2 = factory.createDuration(minutes2);
        assertThat(Integer.signum(d1.compareTo(d2))).isEqualTo(compareResult);
    }

    @ParameterizedTest
    @CsvSource( {
            "1,2,3",
            "3,3,6",
            "420,69,489"
    } )
    void t04addDurations(int minutes1, int minutes2, int newDurationLength) {
        Duration d1 = factory.createDuration(minutes1);
        Duration d2 = factory.createDuration(minutes2);
        assertThat(d1.plus(d2).asMinutes()).isEqualTo(newDurationLength);
    }

    @ParameterizedTest
    @CsvSource( {
            "1, 1",
            "69, 69"
    } )
    void t05toString(int minutes, String expected) {
        Duration d1 = factory.createDuration(minutes);
        assertThat(d1.toString()).contains(expected, "minutes");
    }

    @Test
    void t06equalsAndHash() {
        Duration d1 = factory.createDuration(90);
        Duration d2 = factory.createDuration(90);
        Duration d3 = factory.createDuration(69);
        Helper.verifyEqualsAndHashCode(d1, d2, d3);
    }

}
