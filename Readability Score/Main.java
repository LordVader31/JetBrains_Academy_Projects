package readability;
import readability.Indexes.TextInformation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner txt = new Scanner(System.in);
        if (args.length < 1) {
            System.out.println("No file name supplied. Exiting program.");
            System.exit(0);
        }

        // READING IN THE DATA
        StringBuilder data = new StringBuilder();
        File file = new File(args[0]);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! Source file not found.");
        }

        // TESTS
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        char option = txt.next().trim().charAt(0);

        TextInformation info = new TextInformation(data.toString());
        double averageAge = 0d;
        switch (option) {
            case 'A' :

                break;

            case 'F':
                break;

            case 'S':
                break;

            case 'C':
                break;

            case 'a' :
                break;
        }
        System.out.printf("This text should be understood on average by %.2f-year-olds.", averageAge);
    }
}
