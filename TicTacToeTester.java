import java.util.Scanner;

public class TicTacToeTester
{
    public static void main(String[] args)
    {
        TicTacToe game = new TicTacToe();
        game.printBoard();
        System.out.println("Enter move in row then col");
        System.out.println("EX: 0 0");
        while(!game.checkWin())
        { 
	System.out.println(game.getMark()+" has "+game.possibleWins()+" possible wins");
	System.out.println("Player one move:");
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();
        while(!game.pickLocation(row, col)){
            System.out.println("Sorry, invalid space! Try again!");
            row = input.nextInt();
            col = input.nextInt();
        }
        System.out.println(" ");
        game.takeTurn(row, col);
        game.printBoard();
	System.out.println(game.getMark()+" has "+game.possibleWins()+" possible wins");
        
        if(game.checkWin())
            break;

        System.out.println("Player Two move:");
        row = input.nextInt();
        col = input.nextInt();
        while(!game.pickLocation(row, col)){
            System.out.println("Sorry, invalid space! Try again!");
            row = input.nextInt();
            col = input.nextInt();
        }
        System.out.println(" ");
        game.takeTurn(row, col);
        game.printBoard();
	//System.out.println(game.getMark()+" has "+game.possibleWins()+" possible wins");
        }
        if(game.getTurn()%2==0)
            System.out.println("Player Two Wins!");
        else
            System.out.println("Player One Wins!");
        
    }
    
}
