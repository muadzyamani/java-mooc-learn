import java.util.Scanner;

public class Example {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter your name: ");
    String name = scanner.nextLine();
    greet(name);
  }

  public static void greet(String name) {
    System.out.println("Greetings from the method world! Hello " + name + "!");
  }
}
