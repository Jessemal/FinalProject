import java.awt.*;
import javax.swing.*;
public class GameRunner{
	
	private static final int SIZE = 3;
	public static JFrame frame = new JFrame();
	public static JButton[][] buttonArray = new JButton[SIZE*SIZE][SIZE*SIZE];
	public static LargeGame game = new LargeGame();
	public static JFrame winFrame = new JFrame();
	
	public static Player p1 = new Player("X");
	public static Player p2 = new Player("O");
	public static Player currentPlayer = p1;
	
	
	public static void main(String args[]){
		Label winMessage = new Label();
		winMessage.setFont(new Font("Serif", Font.BOLD, 30));
		winMessage.setForeground(Color.BLUE);
		winFrame.setSize(300, 150);
		winFrame.add(winMessage);
		winFrame.setBackground(Color.lightGray);
		
		frame.setSize(600, 600);
		frame.setLayout(new GridLayout(SIZE*SIZE,SIZE*SIZE));
		create();
		frame.setVisible(true);

		while(game.getWinner1() == null) {}
		winMessage.setText("Congratulations " + game.getWinner1().getName());
		frame.setVisible(false);
		winFrame.setVisible(true);
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
				button.setFont(new Font("Serif", Font.BOLD, 30));
				midRow = i >= SIZE && i < SIZE * 2;
				midColumn =  j >= SIZE && j < SIZE * 2;
				if((midRow || midColumn) && !(midRow && midColumn) ) {
					button.setBackground(Color.yellow);
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
		if(game.setBoard(smallPlayingBoard, xVal, yVal, currentPlayer)) {
			button.setText(currentPlayer.getName());
		
			if (currentPlayer.equals(p1)) {
				currentPlayer = p2;
			} else {
				currentPlayer = p1;
			}
		}
	}
	
}