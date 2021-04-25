package Cinema.Services;

final public class Printing {
    public static void printMenu() {
        System.out.println("\n\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void printSeating(int rows, int columns, String[][] booked) {
        // print the first line
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i<= columns; i++) {
            System.out.print(i + " ");
        }

        // print the rest of the seats
        for (int i = 0; i< rows; i++) {
            System.out.println();
            System.out.print((i+1)+ " ");
            for (int j = 0; j < columns; j++) {
                System.out.print(booked[i][j] + " ");
            }
        }
    }

    public static void printStatistics(String[][] currentBooked) {
        int noOfPurchased = 0;
        for (String[] row : currentBooked) {
            for (String ticketStat : row) {
                if ("B".equals(ticketStat)) {
                    noOfPurchased++;
                }
            }
        }

        int rows = currentBooked.length;
        int columns = currentBooked[0].length;
        int totalNoOfSeats = rows * columns;

        int currentIncome = 0;
        int totalIncome = 0;
        for (int i = 0;  i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ("B".equals(currentBooked[i][j])) {
                    currentIncome += calculateSeatCost(i+1, rows);
                }
                totalIncome += calculateSeatCost(i+1, rows);
            }
        }

        float percentageOccupied = ((float)noOfPurchased)/totalNoOfSeats * 100f;

        System.out.printf("\nNumber of purchased tickets: %d", noOfPurchased);
        System.out.printf("\nPercentage: %.2f%%", percentageOccupied);
        System.out.printf("\nCurrent Income: $%d", currentIncome);
        System.out.printf("\nTotal Income: $%d", totalIncome);
    }

    public static int calculateSeatCost(int selectedRow, int allRows) {
        int firstHalf = (int) (Math.floor(allRows/2));
        return selectedRow <= firstHalf ? 10 : 8;
    }
}//end of class
