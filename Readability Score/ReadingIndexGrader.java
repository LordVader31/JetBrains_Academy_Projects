package readability;

public class ReadingIndexGrader {

    private String text;
    private int sentences;
    private int words;
    private int characters;
    private int syllables;
    private int polysyllables;
    private boolean initialised;

    public ReadingLevelGrader(String text) {
        this.text = text;
        this.initialised = false;
        this.initialise();
    }

    private void initialise() {
        String[] sentenceArray = this.text.split("[.?!]");
        this.sentences = sentenceArray.length;
        this.characters = this.text.replaceAll(" ", "").length();
        this.words = 0;
        this.syllables = 0;
        this.polysyllables = 0;
        for (String sentence : sentenceArray) {
            String[] wordArray = sentence.trim().split(" ");
            words += wordArray.length;
            for (String word : wordArray) {
                int currentSyllables = word.toLowerCase()
                        .replaceAll("e$", "")
                        .replaceAll("[aeiouy]{2,}", "a")
                        .replaceAll("[^aeiouy]", "")
                        .length();
                this.syllables += Math.max(currentSyllables, 1);
                if (currentSyllables > 2) {
                    this.polysyllables++;
                }
            }
        }
        this.initialised = true;
    }

    public int gradeToAge(double grade) {
        int gradeINT = (int) Math.round(grade) - 1;
        int[] ages = {6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 24, 24};
        return ages[gradeINT];
    }

    public double averageAgeAllTests() {
        return 1.0 * (gradeToAge(getARI()) + gradeToAge(getFK()) + gradeToAge(getSMOG()) + gradeToAge(getCL())) / 4;
    }

    public double getARI() {
        if (this.initialised) {
            return 4.71 * (1.0 * this.characters / this.words) + 0.5 * (1.0 * this.words / this.sentences) - 21.43;
        } else {
            return 0;
        }
    }

    public double getFK() {
        if (this.initialised) {
            return 0.39 * (1.0 * this.words / this.sentences) + 11.8 * (1.0 * this.syllables / this.words) - 15.59;
        } else {
            return 0;
        }
    }

    public double getSMOG() {
        if (this.initialised) {
            return 1.043 * Math.sqrt(this.polysyllables * (30.0 / this.sentences)) + 3.1291;
        } else {
            return 0;
        }
    }

    public double getCL() {
        if (this.initialised) {
            double S = 1.0 * this.sentences / this.words * 100;
            double L = 1.0 * this.characters / this.words * 100;
            return 0.0588 * L - 0.296 * S - 15.8;
        } else {
            return 0;
        }
    }

    public String getText() {
        return this.text;
    }

    public int getSentences() {
        return sentences;
    }

    public int getWords() {
        return words;
    }

    public int getCharacters() {
        return characters;
    }

    public int getSyllables() {
        return syllables;
    }

    public int getPolysyllables() {
        return polysyllables;
    }
}
