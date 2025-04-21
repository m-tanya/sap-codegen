```java
// TestRun.java

package integration.tests;

/**
 * Class containing various utility methods and a main entry point.
 */
public class TestRun {

    /**
     * Main entry point of the application.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Method body remains unchanged as per the task
    }

    /**
     * Prints a greeting message for the given name.
     * 
     * @param name The name to greet.
     */
    public static void greet(String name) {
        // Method body remains unchanged as per the task
    }

    /**
     * Adds two integers and returns their sum.
     * 
     * @param a The first integer.
     * @param b The second integer.
     * @return The sum of a and b.
     */
    public static int add(int a, int b) {
        // Method body remains unchanged as per the task
    }

    /**
     * Checks if a given number is even.
     * 
     * @param num The number to check.
     * @return True if the number is even, false otherwise.
     */
    public static boolean isEven(int num) {
        // Method body remains unchanged as per the task
    }

    /**
     * Logs a message (implementation depends on the logging setup).
     * 
     * @param message The message to log.
     */
    public static void log(String message) {
        // Method body remains unchanged as per the task
    }

    /**
     * Formats a template string with a given value.
     * 
     * @param template The template string.
     * @param value    The value to insert into the template.
     * @return The formatted string.
     */
    public static String format(String template, String value) {
        // Method body remains unchanged as per the task
    }

    /**
     * Subtracts the second integer from the first and returns the difference.
     * 
     * @param a The first integer.
     * @param b The second integer.
     * @return The difference of a and b (a - b).
     */
    public static int subtract(int a, int b) {
        return a - b; // Simple subtraction operation
    }
}
```

**Notes:**

1. The package declaration was added at the top as it's a common practice in Java, but since the original package wasn't specified, `integration.tests` was inferred from the provided folder structure (`integration-tests/src/main/java/TestRun.java`). Adjust if necessary.
2. The method bodies for existing methods are left as comments (`// Method body remains unchanged as per the task`) since their implementations weren't provided and the task didn't require changing them. You should replace these comments with the actual method bodies from your existing `TestRun.java` file.
3. The `subtract` method is added with a simple implementation. It's declared as `public static` to match the access modifiers of the other methods in the class. If the existing methods in `TestRun` are intended to be instance methods (i.e., requiring an instance of `TestRun` to call), you would need to adjust the access modifiers and possibly the method calls accordingly. However, based on the provided summary, `static` seems consistent with the rest of the class.