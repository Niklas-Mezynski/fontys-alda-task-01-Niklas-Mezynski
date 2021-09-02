package simpletimeimpl;

import java.util.ServiceLoader;
import simpletimeapi.AbstractAPFactory;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class ServiceFinder {

    static AbstractAPFactory getFactory() {
        return ServiceLoader.load( AbstractAPFactory.class )
                .findFirst()
                .orElseThrow( () -> new NullPointerException( "no factory found" ) );
    }
}
