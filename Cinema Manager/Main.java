package Cinema;
import java.util.Scanner;
import java.util.Arrays;
import Cinema.Services.*;

public class Main {

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
            Printing.printMenu();
            int userResponse = num.nextInt();

            switch(userResponse) {
                case 1:
                    Printing.printSeating(rows, columns, booked);
                    continue;

                case 2:
                    Booking.performBooking(rows, columns, booked);
                    Printing.printSeating(rows, columns, booked);
                    continue;

                case 3:
                    Printing.printStatistics(booked);
                    continue;
            }
            break;
        }
    }
}
