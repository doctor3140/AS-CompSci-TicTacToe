public class TicTacToe
{
   //copy over your constructor from the Tic Tac Toe Board activity in the previous lesson!
   private int turn;
   public String[][] board = new String[3][3];
   //private String mark;
   
   public TicTacToe(){
        for(int row = 0; row<3; row++)
        {
            for(int column = 0; column<3; column++)
            {
                board[row][column] = "-";
            }
        }
    }
   
   //this method returns the current turn
   public int getTurn()
   {
       return turn;
   }

   public String getSpot(int row, int col){
   	return board[row][col]; 
   }
   
   /*This method prints out the board array on to the console
   */
   public void printBoard()
   {
       System.out.print("  0 1 2");
       for(int i =0; i<board.length; i++){
           System.out.print("\n"+i+" ");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");    
            }
   }
   System.out.print("\n");
   }
   
   //This method returns true if space row, col is a valid space
   public boolean pickLocation(int row, int col)
   {
        if((row<3)&&(col<3)) 
            return board[row][col].equals("-");
        else
            return false;
   }
//method for getting proper note
	public String getMark(int n){
	if(n%2==0){
            return "X";
       }
       else{
            return "O";
       }
	}

public boolean pickLocation(int[] spot)
   {
        if((spot[0]<3)&&(spot[1]<3)) 
            return board[spot[0]][spot[1]].equals("-");
        else
            return false;
   }

public String getMark(){
	if(turn%2==0){
            return "X";
       }
       else{
            return "O";
       }
	}

   
   //This method places an X or O at location row,col based on the int turn
   //a little redundent, but i already wrote it and it aint broke
   public void takeTurn(int row, int col)
   {
	String mark;
	   if(turn%2==0){
            mark = "X";
       }
       else{
            mark = "O";
       }
       if(pickLocation(row, col)){
           board[row][col]=mark;
           turn++;
       }
   }

   public void takeTurn(int[] spot)
   {
	String mark;
	   if(turn%2==0){
            mark = "X";
       }
       else{
            mark = "O";
       }
       if(pickLocation(spot)){
           board[spot[0]][spot[1]]=mark;
           turn++;
       }
   }

   
   //This method returns a boolean that returns true if a row has three X or O's in a row
   //good
   public boolean checkRow()
   {
       for(int row=0; row<board.length;row++){
           int countX = 0;
           int countO = 0;
           for(int col=0; col<board[row].length;col++){
               //System.out.println(board[row][col]);
                if(board[row][col].equals("O"))
                    countO++;
                else if(board[row][col].equals("X"))
                    countX++;
                if(countX==3||countO==3)
                    return true;
       }
   }
   return false;
   }
   
    //This method returns a boolean that returns true if a col has three X or O's
   public boolean checkCol()
   {
       for(int row=0; row<board.length;row++){
           int countX = 0;
           int countO = 0;
           for(int col=0; col<board[row].length;col++){
               //System.out.println(board[row][col]);
                if(board[col][row].equals("O"))
                    countO++;
                else if(board[col][row].equals("X"))
                    countX++;
                if(countX==3||countO==3)
                    return true;
       }
   }
   return false;
   }
   
    //This method returns a boolean that returns true if either diagonal has three X or O's
   public boolean checkDiag()
   {
       int countX = 0;
       int countO = 0;
           for(int j=0; j<3; j++){
               //System.out.println(board[j][j]);
               if(board[j][j].equals("O"))
                    countO++;
                else if(board[j][j].equals("X"))
                    countX++;
                if(countX==3||countO==3)
                    return true;
           }
            countX = 0;
            countO = 0;
           for(int i=0; i<3; i++){
           int j = 2-i;
           //System.out.println(board[i][j]);
           if(board[j][i].equals("O"))
                    countO++;
                else if(board[j][i].equals("X"))
                    countX++;
                if(countX==3||countO==3)
                    return true;
           }
        return false;
   }
   
   //This method returns a boolean that checks if someone has won the game
   public boolean checkWin()
   {
       if(checkCol()||checkRow()||checkDiag()){
           return true;
       }
       else{
           return false;
       }
   }

   public boolean checkTie(){
	 if(turn>1){
		int count = 0;
	for(int i =0; i<board.length; i++){
            for(int j=0;j<board[i].length;j++){
               if(board[i][j].equals("-"))
		       return false;            
	    }
	 }
	return true;
	 }
	 else
		 return false;	 
   } 
  
   //methods for checking possible wins //

   public int possibleRow(int n)
   {
	int countWins = 0;
       for(int row=0; row<board.length;row++){
           int countMove = 0;
        	for(int col=0; col<board[row].length;col++){
                if((board[row][col].equals(getMark(n))||(board[row][col].equals("-"))))
                    countMove++;
		else if(board[row][col].equals(getMark(n+1)))
		    countMove=0;
                if(countMove==3)
                    countWins++;
       }
   }
   return countWins;
   }
   
   public int possibleCol(int n)
   {
	int countWins = 0;
       for(int row=0; row<board.length;row++){
           int countMove = 0;
           for(int col=0; col<board[row].length;col++){
                if((board[col][row].equals(getMark(n))||(board[row][col].equals("-"))))
                    countMove++;
		else if(board[col][row].equals(getMark(n+1)))
		    countMove=0;
                if(countMove==3)
                    countWins++;
       }
   }
   return countWins;
   }
   
   public int possibleDiag(int n)
   {
	int countMove = 0;
        int countWins = 0;
           for(int j=0; j<3; j++){
               if((board[j][j].equals(getMark(n))||(board[j][j].equals("-"))))
                    countMove++;
		else if(board[j][j].equals(getMark(n+1)))
		    countMove=0;
                if(countMove==3)
                    countWins++;
           }
           countMove = 0;

           for(int i=0; i<3; i++){
           int j = 2-i;
           //System.out.println(board[i][j]);
           if((board[i][j].equals(getMark(n))||(board[j][j].equals("-"))))
                    countMove++;
		else if(board[i][j].equals(getMark(n+1)))
		    countMove=0;
                if(countMove==3)
                    countWins++;
           }
        return countWins;
   }
   
   //This method returns a boolean that checks if someone has won the game
   //n will be turn. Use turn for your wins turn+1 for opponent's wins
   public int possibleWins(int n)
   {
	   return possibleRow(n)+possibleCol(n)+possibleDiag(n);
   }
   
   public int possibleWins()
   {
	   return possibleRow(turn)+possibleCol(turn)+possibleDiag(turn);
   }

}
