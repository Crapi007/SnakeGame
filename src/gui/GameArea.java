package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GameArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Declare and initialize set in stone values
	
	static final int startX = 40;
	static final int startY = 25;
	static final int boxSide = 50;
	
	public GameArea () {
		
		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		// Draws horizontal lines for the Game Area
		for (int i = 0; i <= SnakeArea.rows; i++) {
		
			g.drawLine(startX, startY + i * boxSide, startX + SnakeArea.collums * boxSide, startY + i * boxSide);
			
		}
		
		// Draws vertical lines for the Game Area
		for (int i = 0; i <= SnakeArea.collums; i++) {
			
			g.drawLine(startX + i * boxSide, startY, startX + i * boxSide, startY + SnakeArea.rows * boxSide);
			
		}
		
	}

}
