ackage readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No file name supplied. Exiting program.");
            System.exit(0);
        }
        String input = textFromArgs(args);
        ReadingLevelGrader grader = new ReadingLevelGrader(input);
        GradePrinter printer = new GradePrinter(grader);
        printer.initialPrint();
        printer.requestCalculation();
    }

    public static String textFromArgs(String[] args) {
        StringBuilder data = new StringBuilder();
        File file = new File(args[0]);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! Source file not found.");
            return null;
        }
        return data.toString();
    }
}
