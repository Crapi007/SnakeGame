package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import characters.SnakeCell;
import logic.SnakeArea;

public class GameArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Declare and initialize set in stone values
	
	// Start Point of the vertical/horizontal line
	static final int startX = 30;
	static final int startY = 35;
	
	// Size of the Squares
	static final int boxSide = 25;
	
	private SnakeArea sarea;
	
	public GameArea (SnakeArea sarea) {
		
		this.sarea = sarea;
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		// Casting Graphics2D onto g 
		Graphics2D g2d = (Graphics2D)g;
		
		drawArea(g2d);
		drawSnake(g2d);
		drawFruit(g2d);
		
	}
	
	public void drawFruit(Graphics g2d) {
		
		int size = boxSide - 5;
		int radius = 10;
		
		g2d.fillRoundRect(startX + sarea.fruitColumn * boxSide, startY + sarea.fruitRow * boxSide, size, size, radius, radius);

	}
	
	public void drawSnake(Graphics2D g2d) {
		
		// Do nothing if List is empty
		if (sarea.snake.isEmpty()) return;
		
		int size = boxSide - 5;
		int radius = 10;
				
		for (int i = 0; i < sarea.snake.size(); i++) {
			
			// Draw the head in another Color
			if (i == 0) {
				
				SnakeCell cell = sarea.snake.get(i);
				g2d.setColor(Color.GREEN);
				g2d.fillRoundRect(startX + 2 + cell.column * boxSide, startY + 2 + cell.row * boxSide, size, size, radius, radius);
				
			}
			
			else {
				
			SnakeCell cell = sarea.snake.get(i);
			
			// Draw the Snake at chosen Boxes
			int x = startX + 2 + cell.column * boxSide;
			int y = startY + 2 + cell.row * boxSide;
			g2d.setColor(Color.DARK_GRAY);
			g2d.fillRoundRect(x, y, size, size, radius, radius);
			
			}
		}	
	}
	
	public void drawArea(Graphics2D g2d) {
		
				// Draws horizontal lines for every column in the Game Area
				for (int i = 0; i <= SnakeArea.rows; i++) {
					
					g2d.drawLine(startX, startY + i * boxSide, startX + SnakeArea.column * boxSide, startY + i * boxSide);
					
				}
				
				// Draws vertical lines for every row in the Game Area
				for (int i = 0; i <= SnakeArea.column; i++) {
					
					g2d.drawLine(startX + i * boxSide, startY, startX + i * boxSide, startY + SnakeArea.rows * boxSide);
					
				}
	}
}
