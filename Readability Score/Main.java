package readability;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner txt = new Scanner(System.in);
        String input = txt.nextLine();
        if (input.length() <= 100) {
            System.out.println("EASY");
        } else {
            System.out.println("HARD");
        }
    }
}
