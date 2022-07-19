import java.util.Scanner;

public class MineSweeper {
    Scanner input = new Scanner(System.in);
    int row;
    int column;

    int rowLimit;
    int columnLimit;
    int numberOfMines;
    String[][] gameArea;
    String[][] mineArea;
    boolean supervision = true;
    int counter;

    MineSweeper(int row, int column) {
        this.rowLimit = row;
        this.columnLimit = column;
        this.numberOfMines = ((row * column) / 4);
        this.gameArea = new String[row][column];
        this.mineArea = new String[row][column];

    }

    public void setGameArea() {
        for (int i = 0; i < this.rowLimit; i++) {
            for (int j = 0; j < this.columnLimit; j++) {
                gameArea[i][j] = "-";
                mineArea[i][j] = "-";
                System.out.print(gameArea[i][j] + "");
            }
            System.out.println(" ");
        }
        for (int i = 0; i < numberOfMines; i++) {
            int k = (int) (Math.random() * this.rowLimit);
            int l = (int) (Math.random() * this.columnLimit);
            if (mineArea[k][l].equals("*")) {
                i--;
            }
            mineArea[k][l] = "*";
        }
    }

    public void scanMap() {

        supervision = false;

        System.out.println("=============");
        System.out.print("Enter the line number: ");
        row = input.nextInt();
        System.out.print("Enter the column number: ");
        column = input.nextInt();

        while (!supervision) {
            if ((0 <= row && 0 <= column) && (row < this.rowLimit && column < this.columnLimit)) {
                supervision = true;
            } else {
                System.out.println("You have selected a point outside the area!!!\b" + "Enter the row and column number again !!!");
                System.out.print("Enter the line number: ");
                row = input.nextInt();
                System.out.print("Enter the column number: ");
                column = input.nextInt();
            }
        }
    }

    public void mineCounter() {
        counter = 0;

        for (int i = (row - 1); i <= (row + 1); i++) {
            for (int j = (column - 1); j <= (column + 1); j++) {
                if (i < 0 || j < 0 || i >= this.rowLimit || j >= this.columnLimit) {
                    continue;
                } else {
                    if (mineArea[i][j].equals("*")) {
                        counter = counter + 1;
                    }
                }
            }
        }

        gameArea[row][column] = String.valueOf(counter);
        mineArea[row][column] = String.valueOf(counter);
        for (int i = 0; i < this.rowLimit; i++) {
            for (int j = 0; j < this.columnLimit; j++) {
                System.out.print(gameArea[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public void writeMineArea(){
        for (int i = 0; i < this.rowLimit; i++) {
            for (int j = 0; j < this.columnLimit; j++) {
                System.out.print(mineArea[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public boolean control() {
        for (int i = 0; i < this.rowLimit; i++) {
            for (int j = 0; j < this.columnLimit; j++) {
                if (mineArea[i][j].equals("-")){
                    return false;
                }
            }
        }
        return true;
    }

    public void run (){
        setGameArea();

        while (supervision){
            scanMap();
            if(mineArea[row][column].equals("*")){
                System.out.println("GAME OVER !!!");
                writeMineArea();
                supervision = false;
            } else {
                mineCounter();
                if (control()){
                    System.out.println("YOU WON");
                    System.out.println("The locations of the mines!");
                    writeMineArea();
                    supervision = false;
                }
            }
        }
    }
}






