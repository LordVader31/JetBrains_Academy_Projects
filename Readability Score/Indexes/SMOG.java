package readability.Indexes;

import java.util.Scanner;

public class SMOG extends ReadabilityTest{
    private int POLYSYLLABLES;

    public SMOG() {

    }

    @Override
    public void determineReadingLevel(String input) {

    }

    @Override
    public String getAgeRange() {
        return null;
    }

    public void printData() {
        System.out.printf("Polysyllables: %d", POLYSYLLABLES);
    }
}//end of class
