package characters;

import java.awt.Graphics;

import javax.swing.JPanel;


public class MainCharacter extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final int CHARACTERHEIGHT = 100;
	final int CHARACTERWIDTH = 100;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawRect(200, 700, CHARACTERWIDTH, CHARACTERHEIGHT);
		
	}

}
