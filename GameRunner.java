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
		
		
		
		while(game.getWinner1() == null) {
			
			
			
		}
		
	}
	
	public static void create() {
		String squareID = "";
		JButton button;
		boolean midRow;
		boolean midColumn;
		for (int i = 1; i <= SIZE*SIZE; i++) {
			for(int j = 1; j <= SIZE*SIZE; j++) {
				//squareID = "board[" + i/SIZE +"][" + j/SIZE + "], square["
						//+ i % SIZE +"][" + j % SIZE + "]";
				button = new JButton(""+i+j);
				buttonArray[i][j] = button;
				frame.add(squareID, button);
				button.setBackground(Color.CYAN);
				midRow = i > SIZE && i <= SIZE * 2;
				midColumn =  j > SIZE && j <= SIZE * 2;
				if((midRow || midColumn) && !(midRow && midColumn) ) {
					button.setBackground(Color.BLUE);
				}
				button.addActionListener(new ButtonListener());
			}
		}
	}
	
	
}

// test