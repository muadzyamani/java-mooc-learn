## **Part 1**

These notes cover the foundational concepts of Java programming, including setting up, printing, reading input, using variables, performing calculations, and implementing conditional logic.

### **Part 1.1: Starting Programming**

#### **1. Core Concepts**
*   **Programming:** The act of giving precise, step-by-step instructions to a computer. Computers are "dumb" and only do exactly what they are told.
*   **Source Code:** The human-readable instructions written by a programmer (e.g., in a `.java` file).
*   **Compiler:** A program that translates source code into a format the computer can understand. In Java, the compiler (`javac`) transforms source code into **bytecode**.
*   **Bytecode:** An intermediate, platform-independent representation of the program (e.g., in a `.class` file).
*   **Java Virtual Machine (JVM):** A program that reads and executes bytecode. The JVM is specific to the operating system (Windows, Mac, Linux), allowing the same bytecode to run anywhere. This is the **"Write Once, Run Anywhere"** principle.

**The Compilation & Execution Flow:**
`Source Code (.java)` → `Compiler (javac)` → `Bytecode (.class)` → `JVM` → `Program Execution`

#### **2. Anatomy of a Basic Java Program**
A minimal Java program has a `class` and a `main` method.

```java
// A class is a container for the program.
// The class name must match the file name (e.g., MyProgram.java).
public class MyProgram {

    // The main method is the entry point of the program.
    // Execution always starts here.
    public static void main(String[] args) {
        // Program statements go inside this block.
    }
}
```

#### **3. Key Terminology**
*   **Class:** A blueprint or container for program code. `public class MyProgram` defines a class named `MyProgram`.
*   **Method:** A named block of code that performs a specific task. `main` is a special method where the program starts.
*   **Statement:** A single command or action in a program. Every statement in Java must end with a semicolon `;`.
*   **Comment:** Text ignored by the compiler, used by programmers to explain the code.
    *   Single-line comment: `// This is a comment`
    *   Multi-line comment: `/* This is a multi-line comment */`

### **Part 1.2: Printing**

#### **1. The `System.out.println()` Command**
*   This is the primary command for printing output to the console.
*   `println` stands for "print line". It prints the specified text and then moves the cursor to a new line.
*   Text to be printed (a **String literal**) must be enclosed in double quotes `" "`.

**Example:**
```java
public class Greeter {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println("Let's start programming!");
    }
}
```
**Output:**
```
Hello, world!
Let's start programming!
```

#### **2. `println` vs. `print`**
*   `System.out.println()`: Prints text and adds a newline.
*   `System.out.print()`: Prints text but **does not** add a newline. The next print command will continue on the same line.

**Example:**
```java
System.out.print("Hello");
System.out.print(" ");
System.out.println("World!");
// Output: Hello World!
```

#### **3. String Concatenation**
*   The `+` operator is used to join (concatenate) strings with other strings or values.

**Example:**
```java
System.out.println("There are " + 5 + " chickens.");
// Output: There are 5 chickens.

String message = "The count is: ";
int count = 100;
System.out.println(message + count);
// Output: The count is: 100
```
**Note:** Java automatically converts the number to a string for printing.



### **Part 1.3: Reading Input**

#### **1. The `Scanner` Class**
*   To read input from the user, we use the built-in `Scanner` class.
*   It is located in the `java.util` package and must be **imported** at the top of the file.

#### **2. Steps to Read User Input**
1.  **Import:** Add `import java.util.Scanner;` at the very beginning of your `.java` file.
2.  **Create a Scanner Object:** Inside your `main` method, create an instance of the `Scanner` to read from the standard input stream (`System.in`).
    `Scanner scanner = new Scanner(System.in);`
3.  **Use Scanner Methods:** Call methods on the `scanner` object to get input. The most common method is `nextLine()`.
    `String userInput = scanner.nextLine();`

**Complete Example:**
```java
import java.util.Scanner; // 1. Import

public class EchoProgram {
    public static void main(String[] args) {
        // 2. Create a Scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write a message:");

        // 3. Read the entire line of input from the user
        String message = scanner.nextLine();

        System.out.println("You wrote: " + message);
    }
}
```



### **Part 1.4: Variables**

#### **1. What is a Variable?**
*   A variable is a named location in memory used to store a piece of data. Think of it as a labeled box where you can put information.
*   It has a **type**, a **name**, and a **value**.
*   **Declaration:** `type variableName;` (e.g., `int number;`)
*   **Initialization:** `variableName = value;` (e.g., `number = 10;`)
*   **Combined:** `type variableName = value;` (e.g., `int number = 10;`)

#### **2. Fundamental Data Types**
*   `String`: For storing text. The value is enclosed in double quotes.
    `String greeting = "Hello there";`
*   `int`: For storing whole numbers (integers).
    `int age = 25;`
*   `double`: For storing floating-point (decimal) numbers.
    `double price = 19.99;`
*   `boolean`: For storing a truth value, either `true` or `false`.
    `boolean isLoggedIn = true;`

#### **3. Variable Naming Conventions**
*   Use **camelCase**: Start with a lowercase letter, and capitalize the first letter of each subsequent word (e.g., `numberOfMessages`, `userName`).
*   Names should be descriptive.

#### **4. Reading and Converting Input for Variables**
*   The `scanner.nextLine()` method always returns a `String`.
*   To use this input as a number, you must **convert (or parse)** it.

*   **String to Integer:** `Integer.valueOf()`
*   **String to Double:** `Double.valueOf()`

**Example:**
```java
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your year of birth?");
        String input = scanner.nextLine(); // Read as String
        int yearOfBirth = Integer.valueOf(input); // Convert to int

        int age = 2023 - yearOfBirth;
        System.out.println("You are approximately " + age + " years old.");
    }
}
```



### **Part 1.5: Calculating**

#### **1. Arithmetic Operators**
*   `+` (Addition)
*   `-` (Subtraction)
*   `*` (Multiplication)
*   `/` (Division)

#### **2. The Pitfall of Integer Division**
*   When you divide an `int` by an `int`, the result is **always an `int`**. The decimal part is truncated (cut off), not rounded.
*   **Example:** `int result = 5 / 2;` will store `2` in the `result` variable, not `2.5`.

#### **3. Performing Correct Division**
To get a precise decimal result from division, at least one of the numbers must be a `double`.
*   **Method 1: Use `double` variables.**
    ```java
    double numerator = 5.0;
    int denominator = 2;
    double result = numerator / denominator; // result is 2.5
    ```
*   **Method 2: Type Casting.** Temporarily treat a variable as a different type for one operation.
    ```java
    int numerator = 5;
    int denominator = 2;
    double result = (double) numerator / denominator; // result is 2.5
    ```

#### **4. Order of Operations**
Java follows standard mathematical order (PEMDAS/BODMAS). Use parentheses `()` to control the order of calculation.
`int result = (5 + 3) * 2; // result is 16`



### **Part 1.6: Conditional Statements**

#### **1. `if` Statements**
*   Conditional statements allow the program to execute different code blocks based on whether a condition is `true` or `false`.
*   The basic structure is `if (condition) { ... }`. The code inside the `{}` block only runs if the `condition` is true.

#### **2. Comparison Operators**
Used inside the `if` condition to compare values:
*   `==` : Equal to
*   `!=` : Not equal to
*   `>` : Greater than
*   `<` : Less than
*   `>=` : Greater than or equal to
*   `<=` : Less than or equal to

#### **3. `else` and `else if`**
*   `else`: Provides an alternative block of code to run if the `if` condition is `false`.
*   `else if`: Allows for checking multiple conditions in sequence.

**Full Structure:**
```java
int number = 10;

if (number > 100) {
    System.out.println("The number is large!");
} else if (number > 0) {
    System.out.println("The number is positive.");
} else {
    System.out.println("The number is zero or negative.");
}
// Output: The number is positive.
```

#### **4. Logical Operators**
Combine multiple boolean conditions:
*   `&&` (AND): True only if **both** conditions are true.
    `if (age >= 18 && hasLicense == true) { ... }`
*   `||` (OR): True if **at least one** condition is true.
    `if (isWeekend || isHoliday) { ... }`
*   `!` (NOT): Inverts a boolean value (true becomes false, false becomes true).
    `if (!isLoggedIn) { System.out.println("Please log in."); }`

#### **5. CRITICAL: Comparing Strings**
*   **DO NOT** use `==` to compare the content of strings. The `==` operator checks if two variables point to the exact same object in memory.
*   **ALWAYS** use the `.equals()` method to compare the actual character content of strings.

**Example:**
```java
String password = "secret";
System.out.println("Enter the password:");
String input = scanner.nextLine();

// CORRECT WAY
if (input.equals(password)) {
    System.out.println("Access granted.");
} else {
    System.out.println("Access denied.");
}

// WRONG WAY - This might fail unpredictably!
// if (input == password) { ... }
```



### **Part 1.7: Programming in Our Society**

This section moves from technical skills to the broader context and responsibility of programming.

#### **1. The Role of the Programmer**
*   A programmer is not just a coder but a **problem-solver**.
*   The job requires **lifelong learning** as technologies and paradigms constantly evolve.
*   It emphasizes **computational thinking**: breaking down complex problems into logical, automatable steps.

#### **2. Algorithms in Daily Life**
*   An **algorithm** is a set of rules or steps for solving a problem.
*   They are ubiquitous and invisible, influencing many aspects of modern life:
    *   **Social Media Feeds:** Algorithms decide what content you see.
    *   **Recommendation Engines:** Netflix, Spotify, and Amazon use algorithms to suggest movies, music, and products.
    *   **Navigation:** GPS apps like Google Maps use algorithms to find the fastest route.
    *   **Search Engines:** Algorithms rank webpages to give you the most relevant results.

#### **3. Societal Impact and Responsibility**
*   Programmers hold significant power and, therefore, responsibility.
*   Code can have unintended consequences.
*   **Ethical Considerations** are crucial:
    *   **Bias:** Algorithms trained on biased data can perpetuate or amplify societal biases (e.g., in loan applications or facial recognition).
    *   **Privacy:** How is user data collected, stored, and used?
    *   **Automation:** How does automation affect jobs and the economy?
*   It is the programmer's duty to think about the societal and ethical implications of the software they create.

---

## **Part 2**

This part covers fundamental programming concepts including problem-solving patterns, loops, and methods in Java.

### **Part 2.1: Problems and Patterns**

#### **Recurring Problems and Patterns**

Programming involves solving the same small problems repeatedly. Common sub-problems include:
- Reading input from the user
- Calculating sums of values
- Performing conditional logic

#### **Reading User Input Pattern**

The standard pattern for reading user input involves:

1. **Import Scanner**: `import java.util.Scanner;` (before class definition)
2. **Create Scanner**: `Scanner reader = new Scanner(System.in);` (in main method)
3. **Read different types**:
   - String: `String text = reader.nextLine();`
   - Integer: `int number = Integer.valueOf(reader.nextLine());`
   - Double: `double numberWithDecimals = Double.valueOf(reader.nextLine());`
   - Boolean: `boolean trueOrFalse = Boolean.valueOf(reader.nextLine());`

```java
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        String text = reader.nextLine();
        int number = Integer.valueOf(reader.nextLine());
        double numberWithDecimals = Double.valueOf(reader.nextLine());
        boolean trueOrFalse = Boolean.valueOf(reader.nextLine());
    }
}
```

#### **Calculating Pattern**

For calculation problems, follow these steps:

1. **Define inputs**: Identify and declare variables for calculation inputs
2. **Identify operation**: Declare a variable for the result and perform the calculation
3. **Use the result**: Print or use the calculated result

```java
// Example: Sum of two integers
int first = 1;
int second = 2;
int sum = first + second;
System.out.println("The sum of " + first + " and " + second + " is " + sum);
```

#### **Combining Reading and Calculating**

You can combine both patterns:

```java
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        int first = Integer.valueOf(reader.nextLine());
        int second = Integer.valueOf(reader.nextLine());
        
        int product = first * second;
        System.out.println("The product of " + first + " and " + second + " is " + product);
    }
}
```

#### **Conditional Logic Pattern**

Conditional statements use `if`, `else if`, and `else`:

```java
if (value > 42) {
    System.out.println("ok");
} else {
    System.out.println("not ok");
}
```

**Chaining conditions**:
```java
if (value > 5) {
    // functionality when value is greater than five
} else if (value < 0) {
    // functionality when value is less than zero
} else {
    // functionality otherwise
}
```

#### **Complete Example: Combining All Patterns**

```java
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        int first = Integer.valueOf(reader.nextLine());
        int second = Integer.valueOf(reader.nextLine());
        
        int sum = first + second;
        
        if (sum > 100) {
            System.out.println("too much");
        } else if (sum < 0) {
            System.out.println("too little");
        } else {
            System.out.println("ok");
        }
    }
}
```

### **Part 2.2: Repeating Functionality**

#### **Introduction to Loops**

Loops allow repetitive execution of code blocks. Without loops, repetitive tasks become cumbersome and impractical.

**Problem without loops** (reading 5 numbers):
```java
Scanner scanner = new Scanner(System.in);
int sum = 0;
System.out.println("Input a number: ");
sum = sum + Integer.valueOf(scanner.nextLine());
System.out.println("Input a number: ");
sum = sum + Integer.valueOf(scanner.nextLine());
// ... repeated 5 times
System.out.println("The sum of the numbers is " + sum);
```

**Solution with loops**:
```java
Scanner scanner = new Scanner(System.in);
int numbersRead = 0;
int sum = 0;

while (true) {
    if (numbersRead == 5) {
        break;
    }
    System.out.println("Input number");
    sum = sum + Integer.valueOf(scanner.nextLine());
    numbersRead = numbersRead + 1;
}
System.out.println("The sum of the numbers is " + sum);
```

#### **Loops and Infinite Loops**

**Basic loop structure**:
```java
while (expression) {
    // Code block to repeat
}
```

**Infinite loop**:
```java
while (true) {
    System.out.println("I can program!");
}
```

#### **Ending a Loop**

Use `break` to exit a loop:

```java
int number = 1;
while (true) {
    System.out.println(number);
    if (number >= 5) {
        break;
    }
    number = number + 1;
}
System.out.println("Ready!");
```

**Output**: 1 2 3 4 5 Ready!

#### **Reading Input in Loops**

Variables used in loops should be defined before the loop:

```java
Scanner scanner = new Scanner(System.in);
while (true) {
    System.out.println("Exit? (y exits)");
    String input = scanner.nextLine();
    if (input.equals("y")) {
        break;
    }
    System.out.println("Ok! Let's carry on!");
}
System.out.println("Ready!");
```

#### **Returning to the Start of the Loop**

Use `continue` to skip to the beginning of the loop:

```java
Scanner scanner = new Scanner(System.in);
while (true) {
    System.out.println("Insert positive integers");
    int number = Integer.valueOf(scanner.nextLine());
    
    if (number <= 0) {
        System.out.println("Unfit number! Try again.");
        continue;
    }
    
    System.out.println("Your input was " + number);
}
```

#### **Complete Example with Break and Continue**

```java
Scanner scanner = new Scanner(System.in);
while (true) {
    System.out.println("Input positive numbers.");
    int number = Integer.valueOf(scanner.nextLine());
    
    if (number == 0) {
        break;
    }
    
    if (number < 0) {
        System.out.println("Unfit number! Try again.");
        continue;
    }
    
    System.out.println("Your input was " + number);
}
```

#### **Calculation with Loops**

**Variable Scope in Loops**:
- Variables defined inside loops only exist within the loop
- Variables needed after the loop must be declared before the loop

**Incorrect approach** (variable scope error):
```java
while (true) {
    int ones = 0;  // Declared inside loop
    // ... loop logic
}
System.out.println("The total of ones: " + ones);  // ERROR: ones not accessible
```

**Correct approach**:
```java
Scanner scanner = new Scanner(System.in);
int ones = 0;  // Declared before loop

while (true) {
    System.out.println("Give a number (end with 0): ");
    int number = Integer.valueOf(scanner.nextLine());
    
    if (number == 0) {
        break;
    }
    
    if (number == 1) {
        ones = ones + 1;
    }
}

System.out.println("The total of ones: " + ones);
```

#### **Complex Loop Example**

Tracking multiple variables:

```java
Scanner reader = new Scanner(System.in);
int numberOfPositives = 0;
int numberOfNegatives = 0;

while (true) {
    System.out.println("Give a number (0 to stop): ");
    int numberFromUser = Integer.valueOf(reader.nextLine());
    
    if (numberFromUser == 0) {
        break;
    }
    
    if (numberFromUser > 0) {
        numberOfPositives = numberOfPositives + 1;
    }
    
    if (numberFromUser < 0) {
        numberOfNegatives = numberOfNegatives + 1;
    }
}

System.out.println("Positive numbers: " + numberOfPositives);
System.out.println("Negative numbers: " + numberOfNegatives);

if (numberOfPositives + numberOfNegatives > 0) {
    double percentageOfPositives = 100.0 * numberOfPositives / (numberOfPositives + numberOfNegatives);
    System.out.println("Percentage of positive numbers: " + percentageOfPositives + "%");
}
```

### **Part 2.3: More Loops**

#### **While Loop with a Condition**

Instead of using `while (true)`, you can use conditional expressions:

```java
int number = 1;
while (number < 6) {
    System.out.println(number);
    number++;
}
```

This prints numbers 1 through 5.

#### **For Loop**

The `for` loop provides a compact way to write loops with counters:

**While loop equivalent**:
```java
int i = 0;
while (i < 10) {
    System.out.println(i);
    i++;
}
```

**For loop version**:
```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

#### **For Loop Structure**

```java
for (initialization; condition; increment) {
    // Code to execute
}
```

Components:
1. **Initialization**: Declare and initialize the counter variable
2. **Condition**: Loop continues while this is true
3. **Increment**: Modify the counter variable after each iteration
4. **Body**: Code to execute in each iteration

**Using variables in for loops**:
```java
int start = 3;
int end = 7;
for (int i = start; i < end; i++) {
    System.out.println(i);
}
```

#### **Loop Execution Behavior**

**Important**: Loop conditions are evaluated at specific times:
1. When the loop starts for the first time
2. After each iteration completes

**Example of infinite loop** (condition never becomes false):
```java
int number = 1;
while (number != 2) {
    System.out.println(number);
    number = 2;
    System.out.println(number);
    number = 1;  // Reset to 1, so condition never becomes false
}
```

#### **Repeating Functionality**

**Problem**: Calculate 4 × 3 as repeated addition (3 + 3 + 3 + 3)

**Using while-true loop**:
```java
int result = 0;
int i = 0;
while (true) {
    result += 3;
    i++;
    if (i == 4) {
        break;
    }
}
System.out.println(result);
```

**Using while loop with condition**:
```java
int result = 0;
int i = 0;
while (i < 4) {
    result += 3;
    i++;
}
System.out.println(result);
```

**Using for loop**:
```java
int result = 0;
for (int i = 0; i < 4; i++) {
    result += 3;
}
System.out.println(result);
```

#### **Program Structure with Loops**

**Poor structure** (processing inside loop):
```java
Scanner reader = new Scanner(System.in);
int sum = 0;
int validNumbers = 0;
int invalidNumbers = 0;

while (true) {
    int input = Integer.valueOf(reader.nextLine());
    if (input == 0) {
        // Processing inside loop - NOT RECOMMENDED
        System.out.println("Sum of valid numbers: " + sum);
        System.out.println("Valid numbers: " + validNumbers);
        System.out.println("Invalid numbers: " + invalidNumbers);
        break;
    }
    // ... rest of logic
}
```

**Better structure** (processing outside loop):
```java
Scanner reader = new Scanner(System.in);
int sum = 0;
int validNumbers = 0;
int invalidNumbers = 0;

while (true) {
    int input = Integer.valueOf(reader.nextLine());
    if (input == 0) {
        break;
    }
    if (input < 0) {
        invalidNumbers++;
        continue;
    }
    sum += input;
    validNumbers++;
}

// Process results after loop ends
System.out.println("Sum of valid numbers: " + sum);
System.out.println("Valid numbers: " + validNumbers);
System.out.println("Invalid numbers: " + invalidNumbers);
```

**Recommended loop structure**:
```java
Scanner reader = new Scanner(System.in);
// Create variables needed for the loop

while (true) {
    // read input
    // end the loop -- break
    // check for invalid input -- continue
    // handle valid input
}

// functionality to execute after the loop ends
```

### **Part 2.4: Methods**

#### **Introduction to Methods**

Methods are named sets of statements that can be called from elsewhere in the program. They help structure programs and avoid code repetition.

**Key concepts**:
- Methods ending in parentheses (like `System.out.println()`) are method calls
- Methods can receive parameters and return values
- Methods help organize code into logical units

#### **Custom Methods**

**Method definition structure**:
```java
public static void methodName() {
    // Method body
}
```

**Basic method example**:
```java
public static void greet() {
    System.out.println("Greetings from the method world!");
}
```

**Complete program with method**:
```java
import java.util.Scanner;

public class ProgramStructure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Let's try if we can travel to the method world:");
        greet();
        System.out.println("Looks like we can, let's try again:");
        greet();
        greet();
        greet();
    }
    
    public static void greet() {
        System.out.println("Greetings from the method world!");
    }
}
```

#### **Method Naming Conventions**

**Correct naming** (camelCase):
```java
public static void thisMethodSaysWoof() {
    System.out.println("woof");
}
```

**Incorrect naming**:
```java
public static void This_method_says_woof ( ) {  // Wrong!
    System.out.println("woof");
}
```

**Rules**:
- Start with lowercase letter
- Use camelCase for multiple words
- No spaces between parentheses
- Proper indentation (4 spaces)

#### **Method Parameters**

**Single parameter**:
```java
public static void greet(int numOfTimes) {
    int i = 0;
    while (i < numOfTimes) {
        System.out.println("Greetings!");
        i++;
    }
}
```

**Multiple parameters**:
```java
public static void sum(int first, int second) {
    System.out.println("The sum of numbers " + first + " and " + second + " is " + (first + second));
}
```

**Calling methods with parameters**:
```java
public static void main(String[] args) {
    greet(3);
    sum(5, 7);
    
    int a = 2;
    int b = 4;
    sum(a, b);
}
```

#### **Parameter Value Copying**

**Important**: Parameter values are copied when methods are called. Changes to parameters inside methods don't affect the original variables.

```java
public static void main(String[] args) {
    int number = 1;
    System.out.println("Before method call: " + number);
    incrementByThree(number);
    System.out.println("After method call: " + number);  // Still 1!
}

public static void incrementByThree(int number) {
    System.out.println("Inside method, before increment: " + number);
    number = number + 3;
    System.out.println("Inside method, after increment: " + number);
}
```

**Output**:
```
Before method call: 1
Inside method, before increment: 1
Inside method, after increment: 4
After method call: 1
```

#### **Methods That Return Values**

**Method without return value** (uses `void`):
```java
public static void printMessage() {
    System.out.println("This method doesn't return anything");
}
```

**Method with return value**:
```java
public static int alwaysReturnsTen() {
    return 10;
}
```

**Using return values**:
```java
public static void main(String[] args) {
    int number = alwaysReturnsTen();
    System.out.println("The method returned: " + number);
    
    // Can be used in expressions
    double result = 4 * alwaysReturnsTen() + (alwaysReturnsTen() / 2) - 8;
    System.out.println("Calculation result: " + result);
}
```

#### **Return Value Types**

| Return Type | Method Definition | Example |
|-------------|------------------|---------|
| No return value | `public static void methodName()` | `public static void printHello()` |
| Integer | `public static int methodName()` | `public static int getNumber()` |
| Double | `public static double methodName()` | `public static double calculateAverage()` |
| String | `public static String methodName()` | `public static String getName()` |
| Boolean | `public static boolean methodName()` | `public static boolean isValid()` |

#### **Return Statement Behavior**

**Method execution ends** when `return` is reached:
```java
public static int functioningMethod(int parameter) {
    if (parameter > 10) {
        return 10;  // Method ends here if condition is true
    }
    System.out.println("The number is ten or less.");
    return parameter;  // Method ends here otherwise
}
```

**Early return in void methods**:
```java
public static void division(int numerator, int denominator) {
    if (denominator == 0) {
        System.out.println("Cannot divide by 0!");
        return;  // Exit method early
    }
    System.out.println("" + numerator + " / " + denominator + " = " + (1.0 * numerator / denominator));
}
```

#### **Variables Inside Methods**

**Local variables** exist only within the method:
```java
public static double average(int number1, int number2, int number3) {
    int sum = number1 + number2 + number3;  // Local variable
    double avg = sum / 3.0;                 // Local variable
    return avg;
}
```

**Common mistake** - trying to access local variables outside the method:
```java
public static void main(String[] args) {
    int first = 3;
    int second = 8;
    int third = 4;
    
    average(first, second, third);
    
    // This DOES NOT WORK - avg is not accessible here!
    System.out.println("Average: " + avg);  // ERROR!
}
```

**Correct approach**:
```java
public static void main(String[] args) {
    int first = 3;
    int second = 8;
    int third = 4;
    
    double result = average(first, second, third);
    System.out.println("Average: " + result);
    
    // Or call directly in print statement
    System.out.println("Average: " + average(first, second, third));
}
```

#### **Calculating Return Values**

**Simple calculation**:
```java
public static int sum(int first, int second) {
    return first + second;
}
```

**Complex calculation**:
```java
public static double average(int number1, int number2, int number3) {
    int sum = number1 + number2 + number3;
    return sum / 3.0;
}
```

**Using methods with user input**:
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Enter first number: ");
    int first = Integer.valueOf(scanner.nextLine());
    
    System.out.print("Enter second number: ");
    int second = Integer.valueOf(scanner.nextLine());
    
    System.out.println("Sum: " + sum(first, second));
}

public static int sum(int first, int second) {
    return first + second;
}
```

#### **Call Stack**

The **call stack** keeps track of method calls and their local variables:

1. **Frame creation**: When a method is called, a new frame is added to the stack
2. **Frame removal**: When a method ends, its frame is removed from the stack
3. **Execution order**: The method on top of the stack is always the one currently executing

**Example execution**:
```java
public static void main(String[] args) {
    System.out.println("Hello world!");
    printNumber();
    System.out.println("Bye bye world!");
}

public static void printNumber() {
    System.out.println("Number");
}
```

**Call stack progression**:
1. `main` starts executing
2. `printNumber` is called → `printNumber` added to stack top
3. `printNumber` completes → `printNumber` removed from stack
4. Execution continues in `main`

### **Call Stack with Parameters**

**Method with parameters**:
```java
public static void main(String[] args) {
    int beginning = 1;
    int end = 5;
    printStars(beginning, end);
}

public static void printStars(int beginning, int end) {
    while (beginning < end) {
        System.out.print("*");
        beginning++;
    }
}
```

**Call stack behavior**:
1. `main` creates variables `beginning` and `end`
2. `printStars` is called → new frame created with parameters `beginning` and `end`
3. Parameter values are **copied** from `main` to `printStars`
4. Changes to parameters in `printStars` don't affect variables in `main`

#### **Method Calling Another Method**

**Example**: Multiplication table
```java
public static void multiplicationTable(int max) {
    int number = 1;
    while (number <= max) {
        printMultiplicationTableRow(number, max);
        number++;
    }
}

public static void printMultiplicationTableRow(int number, int coefficient) {
    int printable = number;
    while (printable <= number * coefficient) {
        System.out.print(" " + printable);
        printable += number;
    }
    System.out.println("");
}
```

**Call stack for `multiplicationTable(3)`**:
1. `main` calls `multiplicationTable(3)`
2. `multiplicationTable` calls `printMultiplicationTableRow(1, 3)`
3. `printMultiplicationTableRow` completes, returns to `multiplicationTable`
4. `multiplicationTable` calls `printMultiplicationTableRow(2, 3)`
5. And so on...

#### **Best Practices for Methods**

1. **Single responsibility**: Each method should have one clear purpose
2. **Meaningful names**: Use descriptive names that indicate what the method does
3. **Parameter naming**: Use clear parameter names
4. **Return values**: Use return values instead of printing inside methods when possible
5. **Avoid side effects**: Methods should be predictable and not modify unexpected state

**Example of good method design**:
```java
public static boolean isEven(int number) {
    return number % 2 == 0;
}

public static int calculateSum(int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
        sum += i;
    }
    return sum;
}

public static void printRange(int start, int end) {
    for (int i = start; i <= end; i++) {
        System.out.println(i);
    }
}
```

---

