
public class GameBoard {
	
	private final int SIZE = 3;
	
	protected Player[][] board = new Player[3][3];
	
	protected static int numBoards = 0;
	
	private int id;
	
	private static int[] lastMove = {-1,-1}; // stores last valid placement as [x,y]
	
	public GameBoard() {
		id = numBoards++;
	}
	
	public boolean setBoard(int x, int y, Player setVal) {
		if ((x > SIZE || y > SIZE )|| board[x][y] != null){
			// checks bounds and that there is no player at this board index
			return false;
		}
		board[x][y] = setVal;
		lastMove[0] = x;
		lastMove[1] = y;
		return true;
	}
	
	public static int[] getLastMove() {
		return lastMove;
	}
	
	public Player getBoardAt(int x, int y) {
		if(x > SIZE || y > SIZE ) 
			return null;
		return board[x][y];
	}
	
	public Player getWinner() {
		boolean foundWinner;
		for(int x = 0; x < SIZE; x++) {// checks for horizontal wins
			foundWinner = true;
			for(int y = 0; y < SIZE - 1; y++) {
				if(board[x][y] != board[x][y+1]) {
					foundWinner = false;
				}
			}
			if (foundWinner == true && board[x][SIZE - 1] != null) 
				return board[x][SIZE - 1];
		}
		
		
		for(int y = 0; y < SIZE; y++) { // checks for vertical wins
			foundWinner = true;
			for(int x = 0; x < SIZE - 1; x++) {
				if(board[x][y] != board[x + 1][y]) {
					foundWinner = false;
				}
			}
			if (foundWinner == true && board[SIZE - 1][y] != null) 
				return board[SIZE-1][y];
		}
		
		
		foundWinner = true;
		for(int i = 0; i < SIZE - 1; i++) { //checks for diagonal from top left to bottom right
			if(board[i][i] != board[i+1][i+1]) {
				foundWinner = false;
			}
				
		}
		if (foundWinner == true && board[SIZE - 1][SIZE - 1] != null) 
			return board[SIZE-1][SIZE - 1];
		
		
		foundWinner = true;
		for(int i = 0; i < SIZE - 1; i++) {//checks for diagonal from top right to bottom left
			if (board[SIZE-1-i][i] != board[SIZE-2-i][i+1])
				foundWinner = false;
		}
		if (foundWinner == true && board[SIZE - 1][0] != null) 
			return board[SIZE - 1][0];
		
		
		return null;// no winner yet
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameBoard other = (GameBoard) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		GameBoard board1 = new GameBoard();
		Player p1 = new Player("Jesse");
		
		board1.setBoard(0, 2, p1);
		board1.setBoard(1, 1, p1);
		board1.setBoard(2, 0, p1);
		System.out.print(board1.getWinner());
	}
	
	
}
