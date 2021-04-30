package readability;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner txt = new Scanner(System.in);
        final String sentenceSplitRegex = "[.!?]";
        String input = txt.nextLine();

        String[] sentences = input.split(sentenceSplitRegex);
        int sum = 0;
        for (String sentence : sentences) {
            sum += countWordsInSentence(sentence.trim());
        }

        final double average = ((double) sum) / sentences.length;
        if (average <= 10d) {
            System.out.println("EASY");
        } else {
            System.out.println("HARD");
        }
    }

    private static int countWordsInSentence(String sentence) {
        return sentence.length() - sentence.replaceAll(" ", "").length() + 1;
    }
}
