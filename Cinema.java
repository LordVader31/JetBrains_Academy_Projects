import java.util.Scanner;
import java.util.Arrays;
public class Cinema {

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        String[][] booked;
         
        System.out.println("Enter the number of rows:");
        int rows = num.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = num.nextInt();
        booked = new String[rows][columns];
        
        for (String[] row : booked) {
            Arrays.fill(row, "S");
        }
            
        while (true) {
            printMenu();
            int userResponse = num.nextInt();
            
            switch(userResponse) {
                case 1:
                    printSeating(rows, columns, booked);
                    continue;
                    
                case 2:
                    booked = performBooking(rows, columns, booked);
                    printSeating(rows, columns, booked);
                    continue;  
                
                case 3:
                    printStatistics(booked);
                    continue;         
            }
            break;        
        }
    }
    
    private static void printMenu() {
        System.out.println("\n\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }
    
    private static void printSeating(int rows, int columns, String[][] booked) {
        // print the first line
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i<= columns; i++) {
            System.out.print(i + " ");
        }        
        
        int bookedItre = 0;
        // print the rest of the seats
        for (int i = 0; i< rows; i++) {
            System.out.println();
            System.out.print((i+1)+ " ");
            for (int j = 0; j < columns; j++) {
                System.out.print(booked[i][j] + " ");
            }
        }
    }
    
    private static String[][] performBooking(int totalRows, int totalColumns, String[][] currentBooked) {
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
            System.out.println("Ticket Price : $" + calculateSeatCost(userRow, totalRows));
        }
        currentBooked[userRow-1][userColumn-1] = "B";
        
        return currentBooked;
    }
    
    private static void printStatistics(String[][] currentBooked) {
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
    
    private static int calculateSeatCost(int selectedRow, int allRows) {
        int firstHalf = (int) (Math.floor(allRows/2));
        return selectedRow <= firstHalf ? 10 : 8;
    }
}
