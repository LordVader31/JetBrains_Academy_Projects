package readability.Indexes;

public class Automated extends ReadabilityTest{

    @Override
    public void determineReadingLevel(String input) {

    }

    @Override
    public String getAgeRange() {
        int scoreAsInt = (int) Math.ceil(this.score);
        if (scoreAsInt > 14) {
            return "0";
        } else if (scoreAsInt == 3) {
            return "7-9";
        } else if (scoreAsInt == 13) {
            return "18-24";
        } else if (scoreAsInt == 14) {
            return "24+";
        } else if (scoreAsInt < 3){
            return (scoreAsInt + 4) + "-" + (scoreAsInt + 5);
        } else {
            return (scoreAsInt + 5) + "-" + (scoreAsInt + 6);
        }
    }
}//end of class
