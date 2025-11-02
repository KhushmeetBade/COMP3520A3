// src/test/java/TemperatureConverterTest.java

// Import JUnit 5 classes
// @Test allows us to mark methods as test cases
// assertEquals is used to compare expected and actual results
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    // Define a small tolerance value for floating-point comparisons.
    // Doubles can have rounding errors (e.g., 0.1 + 0.2 != 0.3 exactly),
    // so we allow results to be "close enough" within 1e-6.
    private static final double EPS = 1e-6;

    // ----------------------------------------------------------
    // Test group 1: Celsius → Fahrenheit conversions
    // ----------------------------------------------------------

    @Test
    public void testCelsiusToFahrenheit_typical() {
        // Each test compares the expected value with the method’s output.
        // Formula: F = (C × 9/5) + 32
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0.0), EPS);     // 0°C = 32°F
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100.0), EPS);  // 100°C = 212°F
        assertEquals(98.6, TemperatureConverter.celsiusToFahrenheit(37.0), EPS);    // 37°C ≈ 98.6°F (human body)
    }

    @Test
    public void testCelsiusToFahrenheit_negativeAndDecimal() {
        // Testing negative and fractional temperatures for robustness
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40.0), EPS);  // -40°C = -40°F (special point)
        assertEquals(-4.0, TemperatureConverter.celsiusToFahrenheit(-20.0), EPS);   // -20°C = -4°F
        assertEquals(14.0, TemperatureConverter.celsiusToFahrenheit(-10.0), EPS);   // -10°C = 14°F
    }

    // ----------------------------------------------------------
    // Test group 2: Fahrenheit → Celsius conversions
    // ----------------------------------------------------------

    @Test
    public void testFahrenheitToCelsius_typical() {
        // Formula: C = (F − 32) × 5/9
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32.0), EPS);      // 32°F = 0°C
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212.0), EPS);   // 212°F = 100°C
        assertEquals(37.0, TemperatureConverter.fahrenheitToCelsius(98.6), EPS);     // 98.6°F ≈ 37°C
    }

    @Test
    public void testFahrenheitToCelsius_negativeAndDecimal() {
        // Check cold temperatures (below freezing)
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40.0), EPS);   // -40°F = -40°C
        assertEquals(-10.0, TemperatureConverter.fahrenheitToCelsius(14.0), EPS);    // 14°F = -10°C
    }

    // ----------------------------------------------------------
    // Test group 3: Celsius → Kelvin conversions
    // ----------------------------------------------------------

    @Test
    public void testCelsiusToKelvin_typical() {
        // Formula: K = C + 273.15
        assertEquals(273.15, TemperatureConverter.celsiusToKelvin(0.0), EPS);        // 0°C = 273.15K
        assertEquals(373.15, TemperatureConverter.celsiusToKelvin(100.0), EPS);      // 100°C = 373.15K
    }

    @Test
    public void testCelsiusToKelvin_edgeCase_absoluteZero() {
        // Absolute zero in Celsius is -273.15°C, which equals 0 Kelvin.
        // Testing this ensures correct handling of lower physical limits.
        assertEquals(0.0, TemperatureConverter.celsiusToKelvin(-273.15), EPS);
    }
}
