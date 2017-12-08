import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(!isValidMove()) {
			return;
		}
		JButton button = (JButton) arg0.getSource();
		button.setText(GameRunner.game.getCurrentPlayer().name);
		
	}
	
	public boolean isValidMove() {
		return true;
	}
}

// test