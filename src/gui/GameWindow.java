package gui;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	
	int frameHeight;
	int frameWidth;

	public GameWindow (int height, int width, String title) {
		super();
		
		// Set properties of the GameWindow via extending JFrame
		this.frameHeight = height;
		this.frameWidth = width;
		setTitle(title);
		setSize(height, width);
		setVisible(true);
		add(new GameArea());
		
		setResizable(false);
		
	}

}
