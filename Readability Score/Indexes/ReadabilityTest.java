package readability.Indexes;

public abstract class ReadabilityTest {
    int SENTENCES;
    int WORDS;
    int CHARACTERS;
    double score;
    String[] data;
    final static String sentenceSplitRegex = "[.!?]";

    public ReadabilityTest(){
        this.SENTENCES = 0;
        this.WORDS = 0;
        this.CHARACTERS = 0;
        this.score = Double.MAX_VALUE;
        this.data = null;
    }

    public ReadabilityTest(String input) {
        this.data = input.split(sentenceSplitRegex);
        this.SENTENCES = input.length();
        this.CHARACTERS = input.replaceAll("\\s", "").length();
        for (String sentence : data) {
            String[] wordArray = sentence.trim().split(" ");
            WORDS += wordArray.length;
        }
    }

    public abstract void determineReadingLevel(String input) ;

    public abstract String getAgeRange() ;

    public void printData() {
        System.out.printf("Words: %d\n" +
                       "Sentences: %d\n" +
                        "Character:%d \n",
                WORDS, SENTENCES, CHARACTERS);
    }
}//end of class
