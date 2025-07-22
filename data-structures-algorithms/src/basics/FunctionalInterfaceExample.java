// Functional Interface demonstration (Java 8+)

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b); // Single abstract method
    
    // Can have default methods
    default void printResult(int result) {
        System.out.println("Result: " + result);
    }
    
    // Can have static methods
    static void info() {
        System.out.println("This is a Calculator functional interface");
    }
}

@FunctionalInterface
interface StringProcessor {
    String process(String input); // Single abstract method
    
    default String processWithPrefix(String input, String prefix) {
        return prefix + process(input);
    }
}

@FunctionalInterface
interface NumberChecker {
    boolean check(int number); // Single abstract method
}

// Regular interface for comparison (not functional)
interface MultiMethodInterface {
    void method1();
    void method2(); // More than one abstract method - not functional
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        System.out.println("=== Functional Interface Demo ===\n");
        
        // 1. Lambda expressions with Calculator
        System.out.println("1. Calculator with Lambda Expressions:");
        Calculator.info(); // Static method call
        
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator subtract = (a, b) -> a - b;
        
        int sum = add.calculate(10, 5);
        int product = multiply.calculate(10, 5);
        int difference = subtract.calculate(10, 5);
        
        add.printResult(sum);
        multiply.printResult(product);
        subtract.printResult(difference);
        
        // 2. Method references
        System.out.println("\n2. Method References:");
        Calculator max = Integer::max; // Method reference
        Calculator min = Integer::min; // Method reference
        
        System.out.println("Max(15, 8): " + max.calculate(15, 8));
        System.out.println("Min(15, 8): " + min.calculate(15, 8));
        
        // 3. StringProcessor examples
        System.out.println("\n3. String Processing:");
        
        StringProcessor uppercase = String::toUpperCase;
        StringProcessor lowercase = String::toLowerCase;
        StringProcessor reverse = input -> new StringBuilder(input).reverse().toString();
        
        String text = "Hello World";
        System.out.println("Original: " + text);
        System.out.println("Uppercase: " + uppercase.process(text));
        System.out.println("Lowercase: " + lowercase.process(text));
        System.out.println("Reversed: " + reverse.process(text));
        
        // Using default method
        System.out.println("With prefix: " + uppercase.processWithPrefix(text, ">>> "));
        
        // 4. NumberChecker examples
        System.out.println("\n4. Number Checking:");
        
        NumberChecker isEven = n -> n % 2 == 0;
        NumberChecker isPositive = n -> n > 0;
        NumberChecker isGreaterThan10 = n -> n > 10;
        
        int[] numbers = {-5, 0, 3, 8, 12, 15};
        
        for (int num : numbers) {
            System.out.println(num + " -> Even: " + isEven.check(num) + 
                             ", Positive: " + isPositive.check(num) + 
                             ", >10: " + isGreaterThan10.check(num));
        }
        
        // 5. Passing functional interfaces as parameters
        System.out.println("\n5. Passing Functions as Parameters:");
        processNumbers(numbers, isEven, "even");
        processNumbers(numbers, isPositive, "positive");
        processNumbers(numbers, n -> n > 5, "greater than 5");
        
        // 6. Built-in functional interfaces examples
        System.out.println("\n6. Built-in Functional Interfaces:");
        demonstrateBuiltInFunctionalInterfaces();
        
        System.out.println("\nKey Points about Functional Interfaces:");
        System.out.println("- Must have exactly ONE abstract method");
        System.out.println("- Can have default and static methods");
        System.out.println("- Enable lambda expressions and method references");
        System.out.println("- @FunctionalInterface annotation is optional but recommended");
        System.out.println("- Foundation for Stream API and functional programming");
    }
    
    // Method that accepts functional interface as parameter
    public static void processNumbers(int[] numbers, NumberChecker checker, String description) {
        System.out.print("Numbers that are " + description + ": ");
        for (int num : numbers) {
            if (checker.check(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
    
    public static void demonstrateBuiltInFunctionalInterfaces() {
        // Predicate<T> - takes T, returns boolean
        java.util.function.Predicate<String> isEmpty = String::isEmpty;
        System.out.println("Is empty string empty? " + isEmpty.test(""));
        System.out.println("Is 'hello' empty? " + isEmpty.test("hello"));
        
        // Function<T,R> - takes T, returns R
        java.util.function.Function<String, Integer> stringLength = String::length;
        System.out.println("Length of 'Java': " + stringLength.apply("Java"));
        
        // Consumer<T> - takes T, returns void
        java.util.function.Consumer<String> printer = System.out::println;
        printer.accept("This is printed by Consumer");
        
        // Supplier<T> - takes nothing, returns T
        java.util.function.Supplier<String> greeting = () -> "Hello from Supplier!";
        System.out.println(greeting.get());
    }
}
