import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please specify map rows and columns !");
        System.out.print("Give number for Row Number:  ");
        int row = input.nextInt();

        System.out.print("Give number for Column Number:  ");
        int column = input.nextInt();

        MineSweeper MineGame = new MineSweeper(row,column);
        MineGame.run();
    }
}



