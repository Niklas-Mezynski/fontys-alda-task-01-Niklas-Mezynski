package simpletimeimpl;

import org.junit.jupiter.api.Test;
import simpletimeapi.AbstractAPFactory;
import simpletimeapi.Time;
import static org.assertj.core.api.Assertions.*;

public class TimeTest {

    static AbstractAPFactory factory = ServiceFinder.getFactory();

    @Test
    void t01TooManyMinutesThrowException() {
        assertThatCode(() -> factory.createTime(25, -30)).isInstanceOf(IllegalArgumentException.class);
    }

}
