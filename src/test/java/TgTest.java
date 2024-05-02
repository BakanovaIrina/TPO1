import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import task1.Tg;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TgTest {
    @ParameterizedTest(name = "tan({0})")
    @ValueSource(doubles = {-Math.PI / 3, -Math.PI / 4, -Math.PI / 6, 0, Math.PI / 6, Math.PI / 4, Math.PI / 3})
    void checkTableValues(double param) {
        assertAll(
                () -> assertEquals(Math.tan(param), Tg.calc(param), 0.01)
        );
    }

    @ParameterizedTest(name = "tan({0})")
    @ValueSource(doubles = {-Math.PI / 2, Math.PI / 2})
    void checkUndefinedValues(double param) {
        assertAll(
                () -> assertEquals(Double.NaN, Tg.calc(param))
        );
    }

    @ParameterizedTest(name = "tan({0})")
    @ValueSource(doubles = {0.9, 0.6, 0.25, 0, -0.25, -0.6, -0.9})
    void checkBetweenTableValues(double param) {
        assertAll(
                () -> assertEquals(Math.tan(param), Tg.calc(param), 0.01)
        );
    }
}
