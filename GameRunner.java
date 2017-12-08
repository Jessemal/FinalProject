import java.awt.*;
import javax.swing.*;
public class GameRunner{
	
	private static final int SIZE = 3;
	public static JFrame frame = new JFrame();
	public static JButton[][] buttonArray = new JButton[SIZE*SIZE][SIZE*SIZE];
	public static LargeGame game = new LargeGame();
	
	public static void main(String args[]){
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(SIZE*SIZE,SIZE*SIZE));
		create();
		frame.setVisible(true);
		
		
		
	}
	
	public static void create() {
		JButton button;
		boolean midRow;
		boolean midColumn;
		for (int i = 0; i < SIZE*SIZE; i++) {
			for(int j = 0; j < SIZE*SIZE; j++) {
				button = new JButton();
				buttonArray[i][j] = button;
				frame.add("", button);
				button.setBackground(Color.CYAN);
				midRow = i >= SIZE && i < SIZE * 2;
				midColumn =  j >= SIZE && j < SIZE * 2;
				if((midRow || midColumn) && !(midRow && midColumn) ) {
					button.setBackground(Color.BLUE);
				}
				button.addActionListener(new ButtonListener());
			}
		}
	}
	
	public static void pressed(JButton button) {
		int xVal = 0;
		int yVal = 0;
		for(int x = 0; x < SIZE*SIZE; x++) {
			for(int y = 0; y < SIZE*SIZE; y++) {
				if(button.equals(buttonArray[x][y])) {
					xVal = x;
					yVal = y;
				}
			}
		}
		GameBoard smallPlayingBoard = game.largeBoard[xVal / SIZE][yVal / SIZE];
		xVal = (xVal % SIZE);
		yVal = (yVal % SIZE);
		if(game.setBoard(smallPlayingBoard, xVal, yVal, LargeGame.getCurrentPlayer()))
		button.setText(LargeGame.currentPlayer.getName());
	}
	
}