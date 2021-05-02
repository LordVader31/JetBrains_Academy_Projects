package readability;

import java.util.Scanner;

public class GradePrinter {

    ReadingLevelGrader grader;
    Scanner scanner;

    public GradePrinter(ReadingLevelGrader grader) {
        this.grader = grader;
        this.scanner = new Scanner(System.in);
    }

    public void initialPrint() {
        System.out.printf("The text is:\n%s\n", grader.getText());
        System.out.printf("Words: %d\n" +
                        "Sentences: %d\n" +
                        "Characters: %d\n" +
                        "Syllables: %d\n" +
                        "Polysyllables: %d\n",
                grader.getWords(), grader.getSentences(), grader.getCharacters(),
                grader.getSyllables(), grader.getPolysyllables());
    }

    public void requestCalculation() {
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String request = scanner.nextLine();
        System.out.println();
        switch (request.toLowerCase()) {
            case "fk":
                printFK();
                break;
            case "smog":
                printSMOG();
                break;
            case "cl":
                printCL();
                break;
            case "ari":
                printARI();
                break;
            default:
                printAll();
                break;
        }
    }

    private void printFK() {
        double grade = grader.getFK();
        int age = grader.gradeToAge(grade);
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d-year-olds).\n", grade, age);
    }

    private void printSMOG() {
        double grade = grader.getSMOG();
        int age = grader.gradeToAge(grade);
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d-year-olds).\n", grade, age);
    }

    private void printCL() {
        double grade = grader.getCL();
        int age = grader.gradeToAge(grade);
        System.out.printf("Coleman–Liau index: %.2f (about %d-year-olds).\n", grade, age);
    }

    private void printARI() {
        double grade = grader.getARI();
        int age = grader.gradeToAge(grade);
        System.out.printf("Automated Readability Index: %.2f (about %d-year-olds).\n", grade, age);
    }

    private void printAll() {
        printARI();
        printFK();
        printSMOG();
        printCL();
        System.out.printf("\nThis text should be understood in average by %.2f-year-olds.", grader.averageAgeAllTests());

    }
}
