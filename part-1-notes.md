### **Part 1**

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