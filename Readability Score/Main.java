package readability;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No file name supplied. Exiting program.");
            System.exit(0);
        }

        StringBuilder data = new StringBuilder();
        File file = new File(args[0]);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! Source file not found.");
        }

        determineReadingLevel(data.toString());
    }

    public static void determineReadingLevel(String input) {
        final String sentenceSplitRegex = "[.!?]";
        String[] sentenceArray = input.split(sentenceSplitRegex);
        final int SENTENCES = sentenceArray.length;
        final int CHARACTERS = input.replaceAll("\\s", "").length();
        int WORDS = 0;
        for (String sentence : sentenceArray) {
            String[] wordArray = sentence.trim().split(" ");
            WORDS += wordArray.length;
        }

        final double SCORE = 4.71 * ((double) CHARACTERS / WORDS) + 0.5 * ((double) WORDS / SENTENCES) - 21.43;

        System.out.printf("The text is:\n%s\n", input);

        System.out.printf("Words: %d\n" +
                        "Sentences: %d\n" +
                        "Characters: %d\n" +
                        "The score is: %.2f\n" +
                        "This text should be understood by %S-year-olds.",
                WORDS, SENTENCES, CHARACTERS, SCORE, getAgeRange(SCORE));
    }

    public static String getAgeRange(double score) {
        int scoreAsInt = (int) Math.ceil(score);

        if (scoreAsInt > 14) {
            return "0";
        } else if (scoreAsInt == 3) {
            return "7-9";
        } else if (scoreAsInt == 13) {
            return "18-24";
        } else if (scoreAsInt == 14) {
            return "24+";
        } else {
            return (scoreAsInt + 4) + "-" + (scoreAsInt + 5);
        }
    }
}
