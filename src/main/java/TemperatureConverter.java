/**
 * A utility class providing methods to convert temperatures between different units.
 *
 * <p>This class contains three independent conversion methods. Each method
 * performs its conversion using the standard formula provided in the
 * assignment specification【942349079967819†L29-L57】. The methods do not call
 * one another and simply return the computed double value.</p>
 */
public class TemperatureConverter {

    /**
     * Converts Celsius to Fahrenheit.
     *
     * <p>Formula: F = (C × 9/5) + 32【942349079967819†L35-L37】.</p>
     *
     * @param celsius the temperature in Celsius
     * @return the equivalent temperature in Fahrenheit
     */
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    /**
     * Converts Fahrenheit to Celsius.
     *
     * <p>Formula: C = (F − 32) × 5/9【942349079967819†L45-L47】.</p>
     *
     * @param fahrenheit the temperature in Fahrenheit
     * @return the equivalent temperature in Celsius
     */
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    /**
     * Converts Celsius to Kelvin.
     *
     * <p>Formula: K = C + 273.15【942349079967819†L54-L56】.</p>
     *
     * @param celsius the temperature in Celsius
     * @return the equivalent temperature in Kelvin
     */
    public double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
}