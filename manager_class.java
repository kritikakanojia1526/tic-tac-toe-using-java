package tic_tac_toe;

import java.util.Scanner;

public class manager_class {
	Player Player1,Player2;
	Board board;
	public static void main(String args[]){
		manager_class t = new manager_class();
		t.startGame();
	}
	public void startGame() {
		//player input 
		Player1=takePlayerInput(1);
		Player2=takePlayerInput(2);
		if(Player1.getSymbol()==Player2.getSymbol()) {
			System.out.println("symbol is already !! taken pick another symbol");
		}
		//create board 
		board=new Board(Player1.getSymbol(),Player2.getSymbol());
		//conduct the game
		boolean Player1turn=true;
		int status=Board.INCOMPLETE;
		Scanner s= new Scanner (System.in);
		while(status==Board.INCOMPLETE ||status==Board.INVALID) {
			if(Player1turn) {
				System.out.println("Player 1-"+ Player1.getName()+"s turn");
				System.out.println("enter x: "); 
				int x=s.nextInt();
				System.out.println("enter y: ");
				int y=s.nextInt();
				//System.out.println("Player 2-"+ Player2.getName()+"s turn");
				//System.out.println("enter y: ");
				//int y=s.nextInt();
				status=board.move(Player1.getSymbol(),x,y);
				if(status !=Board.INVALID) {
					Player1turn=false;
					board.Print();
				}
			}else {System.out.println("Player 2-"+ Player2.getName()+"s turn");
			System.out.println("enter x: ");
			int x=s.nextInt();
			//System.out.println("Player 2-"+ Player2.getName()+"s turn");
			System.out.println("enter y: ");
			int y=s.nextInt();
			status=board.move(Player2.getSymbol(),x,y);
			if(status !=Board.INVALID) {
				Player1turn=true;
				board.Print();
			 }
			}
		}
		if(status == Board.PLAYER_1_WINS){
			System.out.println("Player 1 - " + Player1.getName() +" wins !!");
		}else if(status == Board.PLAYER_2_WINS){
			System.out.println("Player 2 - " + Player2.getName() +" wins !!");
		}else{
			System.out.println("Draw !!");
		}
		}
	private Player takePlayerInput(int num) {
		Scanner s= new Scanner (System.in);
		System.out.println("enter player "+num+"name: ");
		String name=s.nextLine();  
		System.out.println("enter player "+ num+"symbol: ");
		char symbol=s.next().charAt(0);
		Player p=new Player(name,symbol);
		return p;
		
		
	}

}
