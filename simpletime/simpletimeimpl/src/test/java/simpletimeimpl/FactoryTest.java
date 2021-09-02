package simpletimeimpl;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import simpletimeapi.AbstractAPFactory;
import simpletimeapi.Duration;
import simpletimeapi.Time;
import static org.assertj.core.api.Assertions.*;

public class FactoryTest {

    static AbstractAPFactory factory = ServiceFinder.getFactory();

    @Test
    void t01createTime() {
        Time time = factory.createTime(2, 30);
        assertThat(time).isNotNull();
    }

    @Test
    void t02createDuration() {
        Duration duration1 = factory.createDuration(45);
        Duration duration2 = factory.createDuration(4, 25);

        SoftAssertions.assertSoftly((s -> {
            s.assertThat(duration1).isNotNull();
            s.assertThat(duration2).isNotNull();
        }));
    }


}
