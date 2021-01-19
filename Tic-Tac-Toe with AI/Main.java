import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in), txt = new Scanner(System.in);
        System.out.println("Enter the cells :");
        String state = sc.next().trim().toUpperCase();

        Board b = new Board(state);
        b.displayBoard();

        System.out.println("\nEnter coordinates");
        String coordinates = txt.nextLine().trim();
        while (!isValidCoordinates(coordinates)) {
            System.out.println("\nEnter coordinates");
            coordinates = txt.nextLine().trim();
        }
        coordinates = coordinates.replaceAll(" ", "");
        int row = coordinates.charAt(0) - 48;
        int column = coordinates.charAt(1) - 48;

        if (b.decidedWhoseTurn() == 'X')
            b.placePiece(row, column, 'X');
        else
            b.placePiece(row, column, 'O');

        Result res = new Result(b);
        res.displayBoard();
        //b.displayBoard();
        System.out.println(res.determineResult());
    }

    public static boolean isValidCoordinates(String coordinates) {
        try {
            Integer.parseInt(coordinates.replaceAll(" ", ""));
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return false;
        }
        coordinates = coordinates.replaceAll(" ", "");
        int row = coordinates.charAt(0) - 48;
        int col = coordinates.charAt(1) - 48;

        System.out.println(row + ":" + col);
        if (row < 1 || row > 3 || col < 1 || col > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return  false;
        }
        return true;
    }
}
