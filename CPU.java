public class CPU{

public void randomMove(TicTacToe game){
	game.takeTurn(randomSpot(), randomSpot());
}

public int randomSpot(){
	double randomNum = Math.random()*(2); //2 for the array
        return (int)randomNum;
}
}

