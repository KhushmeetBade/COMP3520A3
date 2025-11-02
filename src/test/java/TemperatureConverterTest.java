import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for the {@link TemperatureConverter} class.
 *
 * <p>Each test exercises a different conversion method using representative and
 * edge‑case values. A small delta is supplied to {@code assertEquals} to
 * accommodate floating‑point rounding errors. The tests are written first,
 * then the implementation is written to satisfy them, following the TDD
 * workflow【942349079967819†L120-L124】.</p>
 */
class TemperatureConverterTest {

    /** Acceptable error for floating‑point comparisons. */
    private static final double EPS = 1e-9;

    @Test
    @DisplayName("Precision check: fractional chain")
    void precisionFractionalChain() {
        TemperatureConverter tc = new TemperatureConverter();
        double c = 12.345678;
        double f = tc.celsiusToFahrenheit(c);
        double cBack = tc.fahrenheitToCelsius(f);
        // fractional inputs should round-trip within tiny epsilon
        assertEquals(c, cBack, 1e-8, "Fractional precision round-trip failed");
    }

    @Test
    @DisplayName("Known identity: -40 is same in C and F")
    void testMinusFortyIdentity() {
        TemperatureConverter tc = new TemperatureConverter();
        double f = tc.celsiusToFahrenheit(-40.0);
        assertEquals(-40.0, f, EPS);
        double c = tc.fahrenheitToCelsius(-40.0);
        assertEquals(-40.0, c, EPS);
    }

    @Test
    @DisplayName("NaN passes through conversions (should remain NaN)")
    void testNaNBehavior() {
        TemperatureConverter tc = new TemperatureConverter();
        assertTrue(Double.isNaN(tc.celsiusToFahrenheit(Double.NaN)), "C->F should return NaN for NaN input");
        assertTrue(Double.isNaN(tc.fahrenheitToCelsius(Double.NaN)), "F->C should return NaN for NaN input");
        assertTrue(Double.isNaN(tc.celsiusToKelvin(Double.NaN)), "C->K should return NaN for NaN input");
    }
    @Test
    @DisplayName("Infinity behavior: arithmetic propagation")
    void testInfinityBehavior() {
        TemperatureConverter tc = new TemperatureConverter();
        // Positive infinity inputs should lead to positive infinity outputs (per IEEE arithmetic + finite offsets)
        assertTrue(Double.isInfinite(tc.celsiusToFahrenheit(Double.POSITIVE_INFINITY)));
        assertTrue(Double.isInfinite(tc.fahrenheitToCelsius(Double.POSITIVE_INFINITY)));
        assertTrue(Double.isInfinite(tc.celsiusToKelvin(Double.POSITIVE_INFINITY)));

        // Negative infinity propagation
        assertTrue(Double.isInfinite(tc.celsiusToFahrenheit(Double.NEGATIVE_INFINITY)));
        assertTrue(Double.isInfinite(tc.fahrenheitToCelsius(Double.NEGATIVE_INFINITY)));
        assertTrue(Double.isInfinite(tc.celsiusToKelvin(Double.NEGATIVE_INFINITY)));
    }





}