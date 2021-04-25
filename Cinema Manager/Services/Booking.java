package Cinema.Services;

import java.util.Scanner;

final public class Booking {
    public static void performBooking(int totalRows, int totalColumns, String[][] currentBooked) {
        Scanner sc = new Scanner(System.in);
        int userRow, userColumn;
        while (true) {
            System.out.println("\nEnter a row number:");
            userRow = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            userColumn = sc.nextInt();

            if (userRow > totalRows || userRow < 1) {
                System.out.println("\nWrong input!\n");
                continue;
            }
            else if (userColumn > totalColumns || userColumn < 1) {
                System.out.println("\nWrong input!\n");
                continue;
            }
            else if ("B".equals(currentBooked[userRow-1][userColumn-1])) {
                System.out.println("\nThat ticket has already been purchased!\n");
                continue;
            }
            break;
        }

        if (totalRows * totalColumns < 60) {
            System.out.println("Ticket Price : $10");
        } else {
            System.out.println("Ticket Price : $" + Printing.calculateSeatCost(userRow, totalRows));
        }
        currentBooked[userRow-1][userColumn-1] = "B";
    }
}//end of class
