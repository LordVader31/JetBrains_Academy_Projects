package battleship;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    static char[][] battlefield = new char[10][10];
    static final String[] ships = {"Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer"};
    static final int[] shipLengths = {5, 4, 3, 3, 2};

    public static void main(String[] args) {
        for (char[] row : battlefield) {
            Arrays.fill(row, '~');
        }

        printBattlefield();
        for (int i = 0; i < 5; i++) {
            placeShips(i);
            printBattlefield();
        }
        System.out.println("\nThe game starts!\n");
        printBattlefield();
        firingASalvo();
    }

    private static void printBattlefield() {
        System.out.print("  ");
        for (int i = 1; i <= 10; i++){
            System.out.print(i + " ");
        }
        int row = 0;
        for (char ch = 'A'; ch <= 'J'; ch++){
            System.out.print("\n" + ch + " ");
            for (char position : battlefield[row]) {
                System.out.print(position + " ");
            }
            row++;
        }
        System.out.println();
    }

    private static void placeShips(int pos) {
        Scanner sc = new Scanner(System.in);
        String shipType = ships[pos];
        int shipLength = shipLengths[pos];
        System.out.println("\n\nEnter the coordinates of the " + shipType + " (" + shipLength + " cells): ");
        while (true) {
            String firstCoordinate = sc.next().toUpperCase();
            String secondCoordinate = sc.next().toUpperCase();

            char rowOfFirst = firstCoordinate.charAt(0);
            char rowOfSecond = secondCoordinate.charAt(0);
            int columnOfFirst = Integer.parseInt(firstCoordinate.substring(1));
            int columnOfSecond = Integer.parseInt(secondCoordinate.substring(1));

            if (!isCorrectCoordinates(rowOfFirst, rowOfSecond, columnOfFirst, columnOfSecond, pos))
                continue;

            // NORMALIZE THE ROW AND COLUMN COORDINATES
            int temp = Math.max(columnOfFirst, columnOfSecond);
            columnOfFirst = Math.min(columnOfFirst, columnOfSecond);
            columnOfSecond = temp;

            temp = rowOfFirst > rowOfSecond ? rowOfFirst : rowOfSecond;
            rowOfFirst = rowOfFirst < rowOfSecond ? rowOfFirst : rowOfSecond;
            rowOfSecond = (char) temp;

            // CHECK FOR CROSSING OR TOUCHING OTHER SHIPS
            boolean cross = isCrossing(rowOfFirst, rowOfSecond, columnOfFirst, columnOfSecond);
            boolean touch = isTouching(rowOfFirst, rowOfSecond, columnOfFirst, columnOfSecond);
            if (cross || touch) continue;

            for (int i = rowOfFirst - 65; i <= rowOfSecond - 65; i++) {
                for (int j = columnOfFirst - 1; j < columnOfSecond; j++) {
                    battlefield[i][j] = 'O';
                }
            }
            break;
        } 
    }
    
    private static boolean isCorrectCoordinates(char roF, char roS, int coF, int coS, int pos) {
        
        // CHECK FOR COORDINATES OUTSIDE THE BOARD
        if (roF > 'J' || roF < 'A' || roS > 'J' || roS < 'A') {
            System.out.print("\nError! Invalid Row Coordinates. Please enter a value between A and J.");
            System.out.println(" Try again :");
            return false;
        } else if (coF > 10 || coF < 1 || coS > 10 || coS < 1) {
            System.out.print("\nError! Invalid Column Coordinates. Please enter a value between 1 and 10.");
            System.out.println(" Try again :");
            return false;
        }

        if (pos != -1) {
            // CHECK FOR COORDINATES NOT CORRESPONDING TO STRAIGHT LINES
            if (roF != roS && coF != coS) {
                System.out.println("Error! Wrong ship location! Try again:");
                return false;
            } else if (roF == roS) {
                if (Math.abs(coF - coS) + 1 != shipLengths[pos]) {
                    System.out.println("Error! Wrong length of the " + ships[pos] + "! Try again:");
                    return false;
                }
            } else {
                if (Math.abs(roF - roS) + 1 != shipLengths[pos]) {
                    System.out.println("Error! Wrong length of the " + ships[pos] + "! Try again:");
                    return false;
                }
            }
        }

        return true;
    }
    
    private static boolean isCrossing(char roF, char roS, int coF, int coS) {
        // CHECK FOR CROSSING OTHER SHIPS OR TOUCHING OTHER SHIPS
        for (int i = roF - 65; i <= roS - 65; i++) {
            for (int j = coF - 1; j <= coS - 1; j++) {
                if (battlefield[i][j] == '0') {
                    System.out.println("Error! Your ships cannot cross one another. Try again:");
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isTouching(char roF, char roS, int coF, int coS) {
        // CHECK FOR CROSSING OTHER SHIPS OR TOUCHING OTHER SHIPS
        boolean touch = false;
        for (int i = roF - 65; i <= roS - 65; i++) {
            for (int j = coF - 1; j <= coS - 1; j++) {
                if (roF == roS) {
                    if (coF - 2 >= 0)
                        touch = battlefield[roF - 65][coF - 2] == 'O';
                    if (coS <= 9)
                        touch = battlefield[roF - 65][coS] == 'O' || touch;

                    if (roF - 66 >= 0)
                        touch = battlefield[roF - 66][j] == 'O' || touch;
                    if (roS - 64 <= 9)
                        touch = battlefield[roS - 64][j] == 'O' || touch;
                } else {
                    if (roF - 66 >= 0)
                        touch = battlefield[roF - 66][coF - 1] == 'O';
                    if (roS - 64 <= 9)
                        touch = battlefield[roS - 64][coF - 1] == 'O' || touch;

                    if (coF - 2 >= 0)
                        touch = battlefield[i][coF - 2] == 'O' || touch;
                    if (coS <= 9)
                        touch = battlefield[i][coS] == 'O' || touch;
                }
                if (touch) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    return true;
                }
            }
        }
        return false;
    }

    private static void firingASalvo() {
        Scanner num = new Scanner(System.in);
        System.out.println("\nTake a shot!");
        while (true) {
            String firingPos = num.next().toUpperCase().trim();

            char rowCoordinate = firingPos.charAt(0);
            int columnCoordinate = Integer.parseInt(firingPos.substring(1));

            if (!isCorrectCoordinates(rowCoordinate, 'A', columnCoordinate, 9, -1)) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                continue;
            }

            if (battlefield[rowCoordinate - 65][columnCoordinate - 1] == 'O') {
                battlefield[rowCoordinate - 65][columnCoordinate - 1] = 'X';
                printBattlefield();
                System.out.println("You hit a ship!");

            }
            else if (battlefield[rowCoordinate - 65][columnCoordinate -1] == '~') {
                battlefield[rowCoordinate - 65][columnCoordinate - 1] = 'M';
                printBattlefield();
                System.out.println("You missed!");
            }
            break;
        }
    }
}
