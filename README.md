# Temperature Converter Project

Java 21 + Maven project implementing three temperature conversions with JUnit 5 tests.

## Build and Test

```bash
mvn -q -DskipTests=false test
```

## Methods

- `double celsiusToFahrenheit(double celsius)` → `(celsius * 9/5) + 32`
- `double fahrenheitToCelsius(double fahrenheit)` → `(fahrenheit - 32) * 5/9`
- `double celsiusToKelvin(double celsius)` → `celsius + 273.15`

All methods are independent and return `double`.

## TDD Notes

Tests were written first, then the implementation was updated until all tests passed. See
`src/test/java/TemperatureConverterTest.java` for the test cases. This adheres to
the Test‑Driven Development (TDD) workflow described in the assignment【942349079967819†L114-L124】.

## IntelliJ

Right‑click the project → **Maven → Reload Project**. Run tests with the green triangle
in the test file. A green bar indicates all tests passed; a red bar indicates at least
one test failed.