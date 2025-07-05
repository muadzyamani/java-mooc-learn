import java.util.Scanner;

public class Scanning {
    public static void main(String[] args) throws Exception {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int times = Integer.valueOf(scanner.nextLine());

        while (i < times) {
            i++;
            System.out.println(i);
        }

        System.out.println("Ready!");
    }
}
