/*
 * Jaime Herrera
 * Assignment 7
 * 11/27/2015
 */

import java.util.Scanner;

enum Player {X('X'), O('O');
	private char player;
	private Player(char player) {
		this.player = player;
	}
	
	public char getChar() {
		return this.player;
	}
}



public class TicTacToe {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean game = false;
		String User;
		
		
		while(!game) {
			System.out.print("Would you like to play Tic-Tac-Toe? (Y/N) ");
			User = scan.nextLine();
			
			if(User.equalsIgnoreCase("y")) {
				Game.gamereset();
				Game.gameboard();
				while(!Game.done) {
					Game.Player(Player.X);
					if(Game.win('X')) {
						break;
					}
					if(Game.Tie()){
						System.out.println("Tie.");
						break;
					}
					Game.Player(Player.O);
					if(Game.win('O')) {
						break;
					}
					if(Game.Tie()){
						System.out.println("Tie.");
						break;
					}
				}
				
			}
			if(User.equalsIgnoreCase("n")) {
				System.out.print("Thanks for playing! Have a noice day! ");
				game = true;
			}
		}
		
	}

}
