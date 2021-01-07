package battleship;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Battlefield p1 = new Battlefield();
        Battlefield p2 = new Battlefield();

        Ship[] ships = {new Ship("Aircraft Carrier", 5),
                new Ship("Battleship", 4),
                new Ship("Submarine", 3),
                new Ship("Cruiser", 3),
                new Ship("Destroyer", 2)};

        // PLAYER 1 NAVY SETUP
        System.out.println("\nPlayer 1, place your ships on the game field");
        p1.printBattlefield(false);
        for (int i = 0; i < 5; i++) {
            ships[i].placeShip(p1);
            p1.printBattlefield(false);
        }

        promptEnterKey();

        // PLAYER 2 NAVY SETUP
        System.out.println("\nPlayer 2, place your ships on the game field");
        for (int i = 0; i < 5; i++) {
            ships[i].placeShip(p2);
            p2.printBattlefield(false);
        }

        promptEnterKey();

        //WARTIME
        System.out.println("The game starts!");
        boolean didP1Win = false;
        while(isNavyAfloat(p1)) {
            p2.printBattlefield(true);
            printDivider();
            p1.printBattlefield(false);
            System.out.println("Player 1, it's your turn:");
            firingASalvo(p2);

            if (!isNavyAfloat(p2)) {
                didP1Win = true;
                break;
            }

            promptEnterKey();
            p1.printBattlefield(true);
            printDivider();
            p2.printBattlefield(false);
            System.out.println("Player 2, it's your turn:");
            firingASalvo(p1);
            promptEnterKey();
        }

        if (didP1Win)
            System.out.println("Player 1 won the game!");
        else
            System.out.println("Player 2 won the game!");
    }

    protected static void promptEnterKey() {
        System.out.println("\nPress Enter and pass the move to another player");
        new Scanner(System.in).nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected static void printDivider() {
        for (int i = 0; i < 11; i++) {
            System.out.print("- ");
        }
    }

    protected static boolean isNavyAfloat(Battlefield bf) {
        for (char[] row : bf.battlefield) {
            for (char status : row) {
                if (status == 'O')
                    return true;
            }
        }
        return false;
    }
    

    protected static void firingASalvo(Battlefield bf) {
        Scanner num = new Scanner(System.in);
        while (true) {
            String firingPos = num.next().toUpperCase().trim();

            char rowCoordinate = firingPos.charAt(0);
            int columnCoordinate = Integer.parseInt(firingPos.substring(1));

            if (!bf.isCorrectCoordinates(rowCoordinate, 'A', columnCoordinate, 9, null)) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                continue;
            }

            char status = bf.battlefield[rowCoordinate - 65][columnCoordinate - 1];
            if (status == 'O' || status == 'X') {
                bf.battlefield[rowCoordinate - 65][columnCoordinate - 1] = 'X';
                bf.printBattlefield(true);
                if (isSunken(rowCoordinate, columnCoordinate, bf)) {
                    System.out.println("You sank a ship!");
                }
                else System.out.println("You hit a ship! ");
            } else if (status == '~' || status == 'M') {
                bf.battlefield[rowCoordinate - 65][columnCoordinate - 1] = 'M';
                bf.printBattlefield(true);
                System.out.println("You missed!");
            }
            break;
        }
    }


    protected static boolean isSunken(char rowCo, int columnCo, Battlefield bf) {
        return !bf.isTouching(rowCo, rowCo, columnCo, columnCo, true);
    }
}
