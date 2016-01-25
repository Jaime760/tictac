import java.util.Scanner;
public class Game {
	private static char[][] board = new char[3][3];
	private static int Rows;
	private static int Cols;
	static Scanner scan = new Scanner(System.in);
	public static boolean done = false;

	public static void gamereset() {
		done = false;
		for(Rows = 0; Rows < board.length ; Rows++) {
			for(Cols = 0; Cols < board[Rows].length ; Cols++) {
				board[Rows][Cols] = ' ';
			}
		}
	}

	public static void gameboard() {
		for(Rows = 0; Rows < board.length ; Rows++) {
			System.out.println("+---+---+---+");
			for(Cols = 0; Cols < board[Rows].length ; Cols++) {
				System.out.print("|  ");
				System.out.print(board[Rows][Cols]);
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("+---+---+---+");
	}
	
	public static void BoardUpdate(char update) {
		board[Rows - 1][Cols - 1] = update;
	}
	
	public static void Player(Player player) {
		boolean turn = false;
		while(!turn) {
			System.out.println("Player " + player.getChar());
			System.out.print("Enter Row: ");
			Rows = scan.nextInt();
			
			System.out.print("Enter Column: ");
			Cols = scan.nextInt();
			
			if(Game.bounds()) {
				if(Game.check()) {
					Game.BoardUpdate(player.getChar());
					Game.gameboard();
					turn = true;
				}
				else {
					System.out.println("Don't Cheat! Choose another spot. ");
				}
			}
			else
				System.out.println("Out of Bounds. Enter a new Position.");
		}
		
	}
	
	public static boolean win(char check) {
		//check rows
		if(board[0][0] == check && board[0][1] == check && board[0][2] == check){
			System.out.println("" + check + " Wins");
			done = true;
		}
		if(board[1][0] == check && board[1][1] == check && board[1][2] == check){
			System.out.println("" + check + " Wins");
			done = true;
		}
		if(board[2][0] == check && board[2][1] == check && board[2][2] == check){
			System.out.println("" + check + " Wins");
			done = true;
		}
		//check columns
		if(board[0][0] == check && board[1][0] == check && board[2][0] == check){
			System.out.println("" + check + " Wins");
			done = true;
		}
		if(board[0][1] == check && board[1][1] == check && board[2][1] == check){
			System.out.println("" + check + " Wins");
			done = true;
		}
		if(board[0][2] == check && board[1][2] == check && board[2][2] == check){
			System.out.println("" + check + " Wins");
			done = true;
		}
		//check diagonals
		if(board[0][0] == check && board[1][1] == check && board[2][2] == check){
			System.out.println("" + check + " Wins");
			done = true;
		}
		if(board[0][2] == check && board[1][1] == check && board[2][0] == check){
			System.out.println("" + check + " Wins");
			done = true;
		}
		
		return done;
	}
	
	public static boolean check() {
		if(board[Rows - 1][Cols - 1] == ' ' ) {
			return true;
		}
		else
			return false;
	}
	
	public static boolean Tie() {
		boolean cat = true;
		for(Rows = 0; Rows < board.length ; Rows++) {
			for(Cols = 0; Cols < board[Rows].length ; Cols++) {
				if(board[Rows][Cols] == ' ') {
					cat = false;
				}
			}
		}
		return cat;
	}
	
	public static boolean bounds() {
		if(Rows - 1 < 0 || Rows - 1 > 2 || Cols - 1 < 0 || Cols - 1 > 2) {
			return false;
		}
		else
			return true;
	}
	
	
	
	
	

}
