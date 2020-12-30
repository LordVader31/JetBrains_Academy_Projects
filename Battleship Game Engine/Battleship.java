package battleship;
import java.util.Arrays;
import java.util.Scanner;
public class Battleship {

    static char[][] battlefield = new char[10][10];
    static String[] occupied = new String[5];
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

            // CHECK FOR COORDINATES OUTSIDE THE BOARD
            if (rowOfFirst > 'J' || rowOfFirst < 'A' || rowOfSecond > 'J' || rowOfSecond < 'A') {
                System.out.print("\nError! Invalid Row Coordinates. Please enter a value between A and J.");
                System.out.println(" Try again :");
                continue;
            } else if (columnOfFirst > 10 || columnOfFirst < 1 || columnOfSecond > 10 || columnOfSecond < 1) {
                System.out.print("\nError! Invalid Column Coordinates. Please enter a value between 1 and 10.");
                System.out.println(" Try again :");
                continue;
            }

            // CHECK FOR COORDINATES NOT CORRESPONDING TO STRAIGHT LINES
            if (rowOfFirst != rowOfSecond && columnOfFirst != columnOfSecond) {
                System.out.println("Error! Wrong ship location! Try again:");
                continue;
            } else if (rowOfFirst == rowOfSecond) {
                if (Math.abs(columnOfFirst - columnOfSecond) + 1 != shipLength) {
                    System.out.println("Error! Wrong length (column ex) of the " + shipType +"! Try again:");
                    continue;
                }
            } else {
                if (Math.abs(rowOfFirst - rowOfSecond) + 1 != shipLength) {
                    System.out.println("Error! Wrong length (row ex) of the " + shipType +"! Try again:");
                    continue;
                }
            }

            // CHECK FOR CROSSING OR TOUCHING OTHER SHIPS
            boolean crossOrTouch = false;
                // CHECK FOR CROSSING OTHER SHIPS
                for (int i = rowOfFirst - 65; i <= rowOfSecond - 65; i++) {
                    for (int j = columnOfFirst - 1; j < columnOfSecond; j++) {
                        if (battlefield[i][j] == '0') {
                            crossOrTouch = true;
                            System.out.println("Error! Your ships cannot cross one another. Try again:");
                            break;
                        }
                    }
                    if (crossOrTouch) break;
                }

                //CHECK FOR TOUCHING OTHER SHIPS
                int n = pos;
                while (occupied[n] != null) {
                    String firstCoordShip = occupied[n].substring(0, occupied[n].indexOf(':'));
                    String secondCoordShip = occupied[n].substring(occupied[n].indexOf(':')+1);
                    char rowOfFPS = firstCoordinate.charAt(0);
                    char rowOfLPS = secondCoordinate.charAt(0);
                    int columnOfFPS = Integer.parseInt(firstCoordinate.substring(1));
                    int columnOfLPS = Integer.parseInt(secondCoordinate.substring(1));


                }

            if (!crossOrTouch)  {

                // NORMALIZE THE ROW AND COLUMN COORDINATES
                int temp = Math.max(columnOfFirst, columnOfSecond);
                columnOfFirst = Math.min(columnOfFirst, columnOfSecond);
                columnOfSecond = temp;

                temp = rowOfFirst > rowOfSecond ? rowOfFirst : rowOfSecond;
                rowOfFirst = rowOfFirst < rowOfSecond ? rowOfFirst : rowOfSecond;
                rowOfSecond = (char) temp;

                for (int i = rowOfFirst - 65; i <= rowOfSecond - 65; i++) {
                    for (int j = columnOfFirst - 1; j < columnOfSecond; j++) {
                        battlefield[i][j] = 'O';
                    }
                }
                occupied[pos] = firstCoordinate + ":" + secondCoordinate;
                break;
            }

        }


    }//end of String decrypt(String)

}
