package heapsort;

import java.util.Scanner;

public class ConsoleInput {
    public int getUserInput(String message, int defaultValue) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);

        String input = scanner.nextLine();
        if (input.isEmpty()) {
            input = Integer.toString(defaultValue);
        }

        return Integer.parseInt(input);
    }
}
