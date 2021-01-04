package battleship;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    static char[][] battlefield = new char[10][10];

    public enum Ship {
        AIRCRAFT_CARRIER("Aircraft Carrier", 5),
        BATTLESHIP("Battleship", 4),
        SUBMARINE("Submarine", 3),
        CRUISER("Cruiser", 3),
        DESTROYER("Destroyer", 2);

        String shipName;
        int shipLength;

        Ship(String name, int length) {
            shipLength = length;
            shipName = name;
        }

        public String getShipName() {
            return shipName;
        }

        public int getShipLength() {
            return shipLength;
        }
    }

    public static void main(String[] args) {
        for (char[] row : battlefield) {
            Arrays.fill(row, '~');
        }

        printBattlefield();
        for (Ship ship : Ship.values()) {
            placeShip(ship.getShipName(), ship.getShipLength());
            printBattlefield();
        }
        System.out.println("\nThe game starts!\n");
        printFogOfWarWithSalvos();
        while (isNavyAfloat()) {
            firingASalvo();
            printFogOfWarWithSalvos();
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
    }

    private static boolean isNavyAfloat() {
        for (char[] row : battlefield) {
            for (char status : row) {
                if (status == 'O')
                    return true;
            }
        }
        return false;
    }

    private static void printBattlefield() {
        System.out.print("\n  ");
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
        System.out.println("\n");
    }

    private static void printFogOfWarWithSalvos() {
        System.out.print("\n  ");
        for (int i = 1; i <= 10; i++){
            System.out.print(i + " ");
        }
        int row = 0;
        for (char ch = 'A'; ch <= 'J'; ch++){
            System.out.print("\n" + ch + " ");
            for (char status : battlefield[row]) {
                if (status == 'X' || status == 'M')
                    System.out.print(status + " ");
                else
                    System.out.print("~ ");
            }
            row++;
        }
        System.out.println("\n");
    }

    private static void placeShip(String shipType, int shipLength) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nEnter the coordinates of the " + shipType + " (" + shipLength + " cells): ");
        while (true) {
            String firstCoordinate = sc.next().toUpperCase();
            String secondCoordinate = sc.next().toUpperCase();

            char rowOfFirst = firstCoordinate.charAt(0);
            char rowOfSecond = secondCoordinate.charAt(0);
            int columnOfFirst = Integer.parseInt(firstCoordinate.substring(1));
            int columnOfSecond = Integer.parseInt(secondCoordinate.substring(1));

            if (!isCorrectCoordinates(rowOfFirst, rowOfSecond, columnOfFirst, columnOfSecond, shipType, shipLength))
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
    
    private static boolean isCorrectCoordinates(char roF, char roS, int coF, int coS, String ship, int length) {
        
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

        if (ship != null) {
            // CHECK FOR COORDINATES NOT CORRESPONDING TO STRAIGHT LINES
            if (roF != roS && coF != coS) {
                System.out.println("Error! Wrong ship location! Try again:");
                return false;
            } else if (roF == roS) {
                if (Math.abs(coF - coS) + 1 != length) {
                    System.out.println("Error! Wrong length of the " + ship + "! Try again:");
                    return false;
                }
            } else {
                if (Math.abs(roF - roS) + 1 != length) {
                    System.out.println("Error! Wrong length of the " + ship + "! Try again:");
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
        // CHECK FOR TOUCHING OTHER SHIPS
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

            if (!isCorrectCoordinates(rowCoordinate, 'A', columnCoordinate, 9, null, -1)) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                continue;
            }
            if (battlefield[rowCoordinate - 65][columnCoordinate - 1] == 'O') {
                battlefield[rowCoordinate - 65][columnCoordinate - 1] = 'X';
                printFogOfWarWithSalvos();
                System.out.println("You hit a ship! Try again: ");

            }
            else if (battlefield[rowCoordinate - 65][columnCoordinate -1] == '~') {
                battlefield[rowCoordinate - 65][columnCoordinate - 1] = 'M';
                printFogOfWarWithSalvos();
                System.out.println("You missed! Try again:");
            }
            break;
        }
    }
}
