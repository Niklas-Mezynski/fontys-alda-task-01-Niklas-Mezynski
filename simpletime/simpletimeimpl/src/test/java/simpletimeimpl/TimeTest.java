package simpletimeimpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import simpletime.TimeImpl;
import simpletimeapi.AbstractAPFactory;
import simpletimeapi.Time;
import static org.assertj.core.api.Assertions.*;

public class TimeTest {

    static AbstractAPFactory factory = ServiceFinder.getFactory();

    @Test
    void t01TooManyMinutesThrowException() {
        assertThatCode(() -> factory.createTime(25, -30)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource( {
            "10,20,10:20",
            "0,90,1:30",
            "1,120,3:00",
            "25,-61,23:59"
    } )
    void t02toString(int hours, int minutes, String expectedResult) {
        TimeImpl time = new TimeImpl(hours, minutes);
        assertThat(time.toString()).isEqualTo(expectedResult);
    }

}
