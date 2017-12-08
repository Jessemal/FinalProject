
public class LargeGame {
	
	private final int SIZE = 3;
	protected GameBoard[][] largeBoard = new GameBoard[SIZE][SIZE];
	private static GameBoard active;
	public static Player p1 = new Player("X");
	public static Player p2 = new Player("O");
	public static Player currentPlayer = p1;
	
	public LargeGame() {
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				largeBoard[i][j] = new GameBoard();
			}
		}
	}
	
	public boolean setBoard(GameBoard board, int x, int y, Player player) {
		if(active!=null && !board.equals(active)) {
			return false;
		}
		
		if(board.setBoard(x, y, player)) {
			active = largeBoard[GameBoard.getLastMove()[0]][GameBoard.getLastMove()[1]];
			return true;
		}
		if (player == p1) {
			currentPlayer = p2;
		} else {
			currentPlayer = p1;
		}
		return false;
	}
	
	public Player getWinner1() { // returns true if one board is won
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(largeBoard[i][j].getWinner() != null) {
					return largeBoard[i][j].getWinner();
				}
			}
		}
		return null;
	}
	
	public Player getWinner2() { // returns true if big board is won
		GameBoard consolidated = new GameBoard();
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				consolidated.board[i][j] = largeBoard[i][j].getWinner();
			}
		}
		return consolidated.getWinner();
	}
	
	
	public static Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	
	public static void main(String[] args) {
		LargeGame board1 = new LargeGame();
		
		board1.setBoard(board1.largeBoard[0][0],0, 2, p2);
		active = board1.largeBoard[0][0];
		board1.setBoard(board1.largeBoard[0][0],1, 1, p2);
		active = board1.largeBoard[0][0];
		board1.setBoard(board1.largeBoard[0][0],2, 0, p2);
		System.out.print(board1.getWinner1().getName());
	}
	
}
