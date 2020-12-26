import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class BullsAndCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lengthOfRand = sc.nextInt();
        StringBuilder randomNumber = new StringBuilder();
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for(int i = 0; i < 10; i++)
            numbers.add(i);

        while (numbers.get(0) == 0)
            Collections.shuffle(numbers);

        if (lengthOfRand > 10) {
            System.out.println("Error! Type a number between 0 and 10");
        } else {
            for (int i = 0; i < lengthOfRand; i++) {
                randomNumber.append(numbers.get(i));
            }
            System.out.println(randomNumber);
        }
    }
    
    private static void printInteractions() {
        System.out.println("The secret code is prepared : ****");
        System.out.println("\nTurn 1. Answer:");
        System.out.println("4819");
        System.out.println("Grade: 2 bulls 2 cows");
        System.out.println("\nTurn 2. Answer:");
        System.out.println("1349");
        System.out.println("Grade: 1 bulls 3 cows");
        System.out.println("\nTurn 3. Answer:");
        System.out.println("4759");
        System.out.println("Grade: 4 bulls.");
        System.out.println("Congrats! The secret code is 9876.");
    }

    private static void bullsAndCowsCalc() {
        String predefNum = "2307";
        Scanner sc = new Scanner(System.in);
        int userNum = sc.nextInt();
        String num = String.valueOf(userNum);

        int noOfBulls =  0;
        int noOfCows = 0;
        for (int i = 0; i < predefNum.length(); i++) {
            char ch = predefNum.charAt(i);
            if (i == num.indexOf(ch)) noOfBulls++;
            else if (num.indexOf(ch) >= 0) noOfCows++;
        }
        if (noOfBulls == 0 && noOfCows == 0) {
            System.out.println("None. The secret code is " + predefNum);
        }
        else if (noOfBulls == 0)
            System.out.println(noOfCows + " cow(s). The secret code is " + predefNum);
        else if (noOfCows == 0)
            System.out.println(noOfBulls + " bull(s). The secret code is " + predefNum);
        else
            System.out.println(noOfBulls + " bull(s) and " + noOfCows + " cow(s). The secret code is " + predefNum);
    }
}
