package readability;
import readability.Indexes.*;

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
        StringBuilder data = new StringBuilder(txt.nextLine());
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
        info.printData();
        double averageAge = 0d;
        Automated testAuto = new Automated();
        FleschKincaid testFK = new FleschKincaid();
        ColemanLiau testCL = new ColemanLiau();
        SMOG testSM = new SMOG();
        switch (option) {
            case 'A' :
                testAuto.determineReadingLevel(info);
                break;

            case 'F':
                testFK.determineReadingLevel(info);
                break;

            case 'S':
                testSM.determineReadingLevel(info);
                break;

            case 'C':
                testCL.determineReadingLevel(info);
                break;

            case 'a' :
                testAuto.determineReadingLevel(info);
                testFK.determineReadingLevel(info);
                testSM.determineReadingLevel(info);
                testCL.determineReadingLevel(info);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
        System.out.printf("This text should be understood on average by %.2f-year-olds.", averageAge);
    }
}
