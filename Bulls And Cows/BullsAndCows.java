package bullscows;
import java.util.Scanner;
public class Main {

    static final String[] allChar = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b",
            "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z",};
    static int length;
    static int numberOfChar;

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        if (isErrorAtInputs()) {
            System.exit(0);
        }
        
        String randomNumber = generateRandomUniqueCode(length, numberOfChar);
        System.out.println(randomNumber);
        printSecretPreamble(length, numberOfChar);

        int turnCount = 1;
        while (true) {
            System.out.println("Turn " + turnCount++ + ":");
            String userInput = num.next();

            bullsAndCowsCalc(randomNumber, userInput);
            if (userInput.equals(randomNumber))
                break;
        }
    }
    
    private static boolean isErrorAtInputs() {
        Scanner num = new Scanner(System.in);

        // HANDLING ERROR WITH THE LENGTH
        System.out.println("Input the length of the secret code:");
        String inLength = num.nextLine();
        try {
            length = Integer.parseInt(inLength);
        } catch (NumberFormatException ex) {
            System.out.println("Error: \"" + inLength + "\" isn't a valid number.");
            return true;
        }
        if (length == 0) {
            System.out.println("Error: length of the unique code cannot be 0");
            return true;
        }

        // HANDLING ERROR WITH THE NUMBER OF CHARACTERS
        System.out.println("Input the number of possible symbols in the code:");
        String inNOC = num.nextLine();
        try {
            numberOfChar = Integer.parseInt(inNOC);
        } catch (NumberFormatException ex) {
            System.out.println("Error: \"" + inNOC + "\" isn't a valid number.");
            return true;
        }
        if (numberOfChar < length) {
            System.out.println("Error: it's not possible to generate a " +
                    "code with a length of " + length + " with " + numberOfChar + " unique symbols.");
            return true;
        } else if (numberOfChar > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return true;
        }
        return false;
    }

    private static void printSecretPreamble(int length, int numberOfChar) {
        System.out.print("The secret is prepared ");
        for (int i = 1; i <= length; i++) System.out.print("*");
        System.out.print("(0-");
        if (numberOfChar <= 10) {
            System.out.println(allChar[numberOfChar -1]);
        }
        else {
            System.out.println("9, a-" + allChar[numberOfChar-1] + ")");
        }
        System.out.println("Okay! let's start a game!");
    }

    private static String generateRandomUniqueCode(int noOfDigits, int totalPossible) {
        String randomNumber = "";

        if (noOfDigits > 36) {
            System.out.println("Error! The no. of digits must be less than 36");
            return null;
        } else {
            while (randomNumber.length() <= noOfDigits - 1) {
                String randomChar = allChar[(int) (Math.floor(Math.random()*totalPossible))];
                if (!randomNumber.contains(randomChar +""))
                    randomNumber = randomNumber.concat(randomChar + "");
            }
        }
        return randomNumber;
    }

    private static void bullsAndCowsCalc (String origRandNum, String userRandNum) {
        int noOfBulls =  0;
        int noOfCows = 0;
        for (int i = 0; i < userRandNum.length(); i++) {
            char ch = userRandNum.charAt(i);
            if (i == origRandNum.indexOf(ch)) noOfBulls++;
            else if (origRandNum.indexOf(ch) >= 0) noOfCows++;
        }

        String bullsOP = (noOfBulls == 1 ? " bull " : " bulls ");
        String cowsOP = (noOfCows == 1 ? " cow " : " cows ");
        System.out.print("Grade: ");
        if (noOfBulls == 4) {
            System.out.println("4 bulls");
            System.out.println("Congratulations! You guessed the secret code");
        } else
            System.out.println(noOfBulls + bullsOP + "and " + noOfCows + cowsOP);

    }
}
