import java.util.Scanner;

public class TasksMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("Please select a task:");
            System.out.println("1. Task 3 – Two-Dimensional Array 10x10");
            System.out.println("2. Task 4 – Concatenating Strings");
            System.out.println("3. Task 5 – Is it Palindrome?");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        runTask3();
                        break;
                    case 2:
                        runTask4(scanner);
                        break;
                    case 3:
                        runTask5(scanner);
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 0 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        scanner.close();
    }

    private static void runTask3() {
        System.out.println("\n--- Task 3: Two-Dimensional Array ---");

        int[][] matrix = new int[10][10];

        for (int i = 0; i < 10; i++) {
            matrix[i][i] = i;
        }

        System.out.println("Generated 10x10 Matrix:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int diagonalSum = 0;
        for (int i = 0; i < 10; i++) {
            diagonalSum += matrix[i][i];
        }

        System.out.println("\nThe sum of the elements on the diagonal is: " + diagonalSum);
    }

    private static void runTask4(Scanner scanner) {
        System.out.println("\n--- Task 4: Concatenating Strings ---");

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        String concat1 = str1.concat(str2);
        String concat2 = str2.concat(str1);

        System.out.println("Concatenation 1 (first + second): " + concat1);
        System.out.println("Concatenation 2 (second + first): " + concat2);

        if (concat1.equals(concat2)) {
            System.out.println("The two concatenated strings ARE equal.");
            System.out.println("This means the composition is alternating (commutative).");
        } else {
            System.out.println("The two concatenated strings are NOT equal.");
            System.out.println("This means the composition is not alternating (not commutative).");
        }
    }

    private static void runTask5(Scanner scanner) {
        System.out.println("\n--- Task 5: Palindrome Check ---");

        System.out.print("Enter a word to check: ");
        String originalWord = scanner.nextLine();

        String lowerWord = originalWord.toLowerCase();
        String reversedWord = new StringBuilder(lowerWord).reverse().toString();

        if (lowerWord.equals(reversedWord)) {
            System.out.println("The word '" + originalWord + "' IS a palindrome.");
        } else {
            System.out.println("The word '" + originalWord + "' is NOT a palindrome.");
        }
    }
}