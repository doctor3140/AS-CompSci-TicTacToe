public class CPU{

private TicTacToe game;
private String myMark = "O";
private String theirMark = "X";
private int[] lastMove = new int[2];

public CPU(TicTacToe game){
	this.game = game;
}

public void randomMove(){	
	int row = randomSpot();
        int col = randomSpot();
        while(!game.pickLocation(row, col)){
            row = randomSpot();
            col = randomSpot();
        }
        System.out.println(" ");
	lastMove[0] = row;
	lastMove[1] = col;
        game.takeTurn(row, col);
	}

private int randomSpot(){
	double randomNum = Math.random()*(3); //2 for the array
        int i = ((int)randomNum);
	//System.out.println(i);
	return i;
}

//methods for checking 2 in a row
private int[] checkRow(String mark, String otherMark)
   {
       int count = 0;
       for(int row=0; row<3;row++){
	int[] win = new int[2];
	count = 0;
           for(int col=0; col<3;col++){
               //System.out.println(board[row][col]);
                if(game.getSpot(row, col).equals("-")){
		    win[0] = row;
		    win[1] = col;
		    System.out.println("empty is: "+row+" "+col);
		    System.out.println("count: "+count);
		}

		if(game.getSpot(row, col).equals(mark)){
                    count++;
		    System.out.println("count++");
		}
		}

		if((count==2)&&(game.pickLocation(win))){
			System.out.println("Win is: "+win[0]+" "+win[1]);
			return win;
		}

   }
   return null;
   }

private int[] checkCol(String mark, String otherMark)
   {
       int count = 0;
       for(int col=0; col<3;col++){
	int[] win = new int[2];
	count = 0;
           for(int row=0; row<3;row++){
               //System.out.println(board[row][col]);
                if(game.getSpot(row, col).equals("-")){
		    win[0] = row;
		    win[1] = col;
		    System.out.println("empty is: "+row+" "+col);
		    System.out.println("count: "+count);
		}

		if(game.getSpot(row, col).equals(mark)){
                    count++;
		    System.out.println("count++");
		}
	       }
		if((count==2)&&(game.pickLocation(win))){
			System.out.println("Win is: "+win[0]+" "+win[1]);
			return win;
		}

   }
   return null;
   }

private int[] checkDiag(String mark, String otherMark)
   {
       int count = 0;
	int[] win = new int[2];
           for(int j=0; j<3; j++){	
		
		if(game.getSpot(j, j).equals("-")){
		    win[0] = j;
		    win[1] = j;
		    System.out.println("empty is: "+j+" "+j);
		    System.out.println("count: "+count);
		}

               if(game.getSpot(j, j).equals(mark))
                    count++; 
           }
	       if((count==2)&&(game.pickLocation(win))){
                    	System.out.println("Win is: "+win[0]+" "+win[1]);
			return win;
	       }
            
	   count = 0;
	   int[] win2 = new int[2];
           for(int i=0; i<3; i++){
           int j = 2-i;
	   if(game.getSpot(j, i).equals("-")){
		    win2[0] = j;
		    win2[1] = i;
		    System.out.println("empty is: "+j+" "+i);
		    System.out.println("count: "+count);
		}

           if(game.getSpot(j, i).equals(mark))
                    count++; 
           }
	   if((count==2)&&(game.pickLocation(win))){
                    	System.out.println("Win2 is: "+win2[0]+" "+win2[1]);
			return win2;
	       }

 	   else
        	return null;
   }



private int[] winSpot(String mark, String otherMark){

if((checkDiag(mark, otherMark)!=null)&&(game.pickLocation(checkDiag(mark, otherMark)))){
	System.out.println("diag");
	return checkDiag(mark, otherMark);
}

else if(checkRow(mark, otherMark)!=null&&(game.pickLocation(checkRow(mark, otherMark)))){
	System.out.println("row");
	return checkRow(mark, otherMark);
}
else if(checkCol(mark, otherMark)!=null&&(game.pickLocation(checkCol(mark, otherMark)))){
	System.out.println("col");
	return checkCol(mark, otherMark);
}
else
	return null;
}



public void dubz(){
	//check for own winning spot
	//if((winSpot(myMark, theirMark)!=null)&&(game.pickLocation(winSpot(myMark, theirMark)))){
	if((winSpot(myMark, theirMark)!=null)){
		lastMove = winSpot(myMark, theirMark);
		System.out.println("122: The move is: "+lastMove[0]+" "+lastMove[1]);
		game.takeTurn(winSpot(myMark, theirMark));
	}
	//check for opponent winning spot
	//else if(winSpot(theirMark, myMark)!=null&&(game.pickLocation(winSpot(theirMark, myMark)))){
	else if(winSpot(theirMark, myMark)!=null){
		lastMove = winSpot(theirMark, myMark);
		System.out.println("128: The move is: "+lastMove[0]+" "+lastMove[1]);
		game.takeTurn(winSpot(theirMark, myMark));
	}
	else if((lastMove[0]<2)&&(game.pickLocation(lastMove[0]+1, lastMove[1]))){
			game.takeTurn(lastMove[0]+1, lastMove[1]);
			lastMove[0]=lastMove[0]+1;
			System.out.println("134: The move is: "+lastMove[0]+" "+lastMove[1]);
		}
	else if((lastMove[0]==2)&&(game.pickLocation(lastMove[0]-1, lastMove[1]))){
			game.takeTurn(lastMove[0]-1, lastMove[1]);
			lastMove[0]=lastMove[0]-1;
			System.out.println("140: The move is: "+lastMove[0]+" "+lastMove[1]);
		}
	else if((lastMove[1]<2)&&(game.pickLocation(lastMove[0], lastMove[1]+1))){
			game.takeTurn(lastMove[0], lastMove[1]+1);
			lastMove[1]=lastMove[1]+1;
			System.out.println("144: The move is: "+lastMove[0]+" "+lastMove[1]);
		}
	else if((lastMove[1]==2)&&(game.pickLocation(lastMove[0], lastMove[1]-1))){
			game.takeTurn(lastMove[0], lastMove[1]-1);
			lastMove[0]=lastMove[0]-1;
			System.out.println("129: The move is: "+lastMove[0]+" "+lastMove[1]);
		}
		//shouldn't need an else... buuuuut
		else{
			System.out.println("random");
			randomMove();
		}
}


//assuming moving second
public void smartMove(){
	//need to specify turn order for subsequent turns
	if(game.getTurn() == 1){
	if(game.getSpot(1, 1).equals("X")){
		lastMove[0] = 0;
		lastMove[1] = 0;
		game.takeTurn(0, 0); //could be any, but why not make it easy
	}
	/*
	if else((game.getSpot(0, 0).equals("X"))||(game.getSpot(2, 0).equals("X"))||(game.getSpot(0, 2).equals("X"))(game.getSpot(2, 2).equals("X"))){
		game.takeTurn(1, 1);
	}
	*/
	else{
		lastMove[0] = 1;
		lastMove[1] = 1;
		game.takeTurn(1, 1);
	    }
	}
	else
		dubz();
	}
}

