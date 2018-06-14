package pt.tiago;

import org.springframework.stereotype.Component;

/**
 * Created by Tiago Vilas Boas on 14/06/2018.
 */
@Component
public class AutoWireTestImpl implements AutoWireTest {
    @Override
    public String alive() {
        return "I'm alive";
    }
}
