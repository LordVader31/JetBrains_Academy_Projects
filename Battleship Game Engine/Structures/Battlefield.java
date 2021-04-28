package battleship.structures;

class Battlefield {
    char[][] battlefield;

    public Battlefield() {
        battlefield  = new char[10][10];
        
        // FOG OF WAR
        for (char[] row : battlefield) {
            Arrays.fill(row, '~');
        }
    }

    protected void printBattlefield(boolean isWartime) {
        System.out.print("\n  ");
        for (int i = 1; i <= 10; i++){
            System.out.print(i + " ");
        }
        int row = 0;
        for (char ch = 'A'; ch <= 'J'; ch++){
            System.out.print("\n" + ch + " ");
            for (char position : battlefield[row]) {
                if (isWartime && position == 'O')
                    System.out.print("~ ");
                else System.out.print(position + " ");
            }
            row++;
        }
        System.out.println("\n");
    }

    protected boolean isCorrectCoordinates(char roF, char roS, int coF, int coS, Ship ship) {

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
                if (Math.abs(coF - coS) + 1 != ship.length) {
                    System.out.println("Error! Wrong length of the " + ship.name + "! Try again:");
                    return false;
                }
            } else {
                if (Math.abs(roF - roS) + 1 != ship.length) {
                    System.out.println("Error! Wrong length of the " + ship.name + "! Try again:");
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean isCrossing(char roF, char roS, int coF, int coS) {
        // CHECK FOR CROSSING OTHER SHIPS OR TOUCHING OTHER SHIPS
        for (int i = roF - 65; i <= roS - 65; i++) {
            for (int j = coF - 1; j <= coS - 1; j++) {
                if (battlefield[i][j] == 'O') {
                    System.out.println("Error! Your ships cannot cross one another. Try again:");
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean isTouching(char roF, char roS, int coF, int coS, boolean isWartime) {
        // CHECK FOR TOUCHING OTHER SHIPS OR PIECES OF SHIPS
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
                if (touch && isWartime) {
                    return true;
                }
                if (touch) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    return true;
                }
            }
        }
        return false;
    }
}
