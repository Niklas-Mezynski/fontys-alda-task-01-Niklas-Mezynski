/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletimeapi;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class TimeTest {

    class TTime implements Time {

        final int minutesSinceMidnight;

        TTime( int minutesSinceMidnight ) {
            this.minutesSinceMidnight = minutesSinceMidnight;
        }

        @Override
        public Time addTime( Time t ) {
            throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Time addTime( int minutes ) {
            throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getHours() {
            return minutesSinceMidnight / 60;
        }

        @Override
        public int getMinutes() {
            return minutesSinceMidnight % 60;
        }

        @Override
        public Duration until( Time other ) {
            throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int compareTo( Time other ) {
            return this.minutesSinceMidnight - other.asMinutes();
        }
    }

    //@Disabled
    @ParameterizedTest
    @CsvSource( {
        "10,20,<",
        "300,300,=",
        "200,150,>"
    } )
    void comparableTime( int a, int b, char expectedResult ) {
        Time ta = new TTime( a );
        Time tb = new TTime( b );
        switch ( expectedResult ) {
            case '=':
                assertThat( ta ).isEqualByComparingTo( tb );
                break;
            case '<':
                assertThat( ta ).isLessThan( tb );
                break;
            case '>':
                assertThat( ta ).isGreaterThan( tb );
                break;

        }
//        fail( "test comparable time reached it's and. You will know what to do." );
    }

    //@Disabled
    @ParameterizedTest
    @CsvSource( {
        "10,20,<",
        "300,300,=",
        "200,150,>"
    } )
    void before( int a, int b, char expectedResult ) {
        Time ta = new TTime( a );
        Time tb = new TTime( b );
        switch ( expectedResult ) {
            case '=':
                assertThat( ta.isBefore( tb ) ).isFalse();
                break;
            case '<':
                assertThat( ta.isBefore( tb ) ).isTrue();
                break;
            case '>':
                assertThat( ta.isBefore( tb ) ).isFalse();
                break;
        }
//        fail( "test before reached it's and. You will know what to do." );
    }

    //@Disabled
    @ParameterizedTest
    @CsvSource( {
        "10,20,<",
        "300,300,=",
        "200,150,>"
    } )
    void beforeOrEqual( int a, int b, char expectedResult ) {
        Time ta = new TTime( a );
        Time tb = new TTime( b );
        switch ( expectedResult ) {
            case '=':
                assertThat( ta.isBeforeOrEqual( tb ) ).isTrue();
                break;
            case '<':
                assertThat( ta.isBeforeOrEqual( tb ) ).isTrue();
                break;
            case '>':
                assertThat( ta.isBeforeOrEqual( tb ) ).isFalse();
                break;
        }
//        fail( "test beforeOrEqual reached it's and. You will know what to do." );
    }
}
