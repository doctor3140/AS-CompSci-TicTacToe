public class CPU{

public void randomMove(TicTacToe game){	
	int row = randomSpot();
        int col = randomSpot();
        while(!game.pickLocation(row, col)){
            row = randomSpot();
            col = randomSpot();
        }
        System.out.println(" ");
        game.takeTurn(row, col);
	}

public int randomSpot(){
	double randomNum = Math.random()*(3); //2 for the array
        int i = ((int)randomNum);
	//System.out.println(i);
	return i;
}
}

