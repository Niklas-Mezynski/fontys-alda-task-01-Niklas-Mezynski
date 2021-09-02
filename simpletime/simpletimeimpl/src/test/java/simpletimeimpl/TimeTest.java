package simpletimeimpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import simpletimeapi.AbstractAPFactory;
import simpletimeapi.Time;
import static org.assertj.core.api.Assertions.*;

public class TimeTest {

    static AbstractAPFactory factory = ServiceFinder.getFactory();

    @Test
    void t01TooManyMinutesThrowException() {
        assertThatCode(() -> factory.createTime(25, -30)).isInstanceOf(IllegalArgumentException.class);
        assertThatCode(() -> factory.createTime(0, -2)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource( {
            "10,20,10:20",
            "0,90,1:30",
            "1,120,3:00",
            "25,-61,23:59"
    } )
    void t02toString(int hours, int minutes, String expectedResult) {
        Time time = factory.createTime(hours, minutes);
        assertThat(time.toString()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource( {
            "10,20,30,10:50",
            "0,90,45,2:15",
            "13,30,-20,13:10",
            "23,00,120,1:00"
    } )
    void t03addMinutes(int hours, int minutes, int toAdd, String expectedRes) {
        Time time = factory.createTime(hours, minutes);
        assertThat(time.addTime(toAdd).toString()).isEqualTo(expectedRes);
    }

    @ParameterizedTest
    @CsvSource( {
            "1,30,2,30,4:00",
            "22,30,10,45,9:15"
    } )
    void t04addAnotherTime(int hours1, int minutes1, int hours2, int minutes2, String expectedRes) {
        Time time1 = factory.createTime(hours1, minutes1);
        Time time2 = factory.createTime(hours2, minutes2);
        assertThat(time1.addTime(time2).toString()).isEqualTo(expectedRes);
    }

    @ParameterizedTest
    @CsvSource( {
            "1,30,2,30,-1",
            "2,0,0,120,0",
            "0,91,1,30,1"
    } )
    void t05compareTo(int hours1, int minutes1, int hours2, int minutes2, int compareResult) {
        Time time1 = factory.createTime(hours1, minutes1);
        Time time2 = factory.createTime(hours2, minutes2);
        assertThat(Integer.signum(time1.compareTo(time2))).isEqualTo(compareResult);
    }

}
