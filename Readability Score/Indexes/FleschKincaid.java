package readability.Indexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FleschKincaid extends ReadabilityTest{
    private int SYLLABLES;

    public FleschKincaid() {
        super();
    }

    public FleschKincaid(String input) {
        super(input);
        for
    }

    private int countSyllables(String word) {
        String i = "(?i)[aiou][aeiou]*|e[aeiou]*(?!d?\\b)";
        Matcher m = Pattern.compile(i).matcher(word);
        int count = 0;

        while (m.find()) {
            count++;
        }

        // RETURN AT LEAST 1
        return Math.max(count, 1);
    }

    @Override
    public void determineReadingLevel(String input) {

    }

    @Override
    public String getAgeRange() {
        return null;
    }

    public void printData() {
        System.out.printf("Syllables: %d", SYLLABLES);
    }
}//end of class
