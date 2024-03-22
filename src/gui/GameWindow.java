package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;

import logic.SnakeArea;

// Constants for which directio the Player is heading
enum Direction {
	
	LEFT, RIGHT, UP, DOWN;
	
}

public class GameWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	
	int frameHeight;
	int frameWidth;
	Direction direction = Direction.LEFT;

	public GameWindow (int height, int width, String title) {
		super();
		
		// Set properties of the GameWindow via extending JFrame
		this.frameHeight = height;
		this.frameWidth = width;
		setTitle(title);
		setSize(height, width);
		setVisible(true);
		setLayout(null);
		setFocusable(true);
		
		// Add the Game Area and Logical Area to the Main Frame
		SnakeArea board = new SnakeArea();
		GameArea ga = new GameArea(board);
		ga.setBounds(0, 0 , 600, 600);
		add(ga);
		
		// Create and add Buttons for movement inputs
		JButton bleft = new JButton("Left");
		bleft.setBounds(130, 680, 100, 40);
		add(bleft);
		JButton bright = new JButton("Right");
		bright.setBounds(370, 680, 100, 40);
		add(bright);
		JButton bdown = new JButton("Down");
		bdown.setBounds(250, 680, 100, 40);
		add(bdown);
		JButton bup = new JButton("Up");
		bup.setBounds(250, 620, 100, 40);
		add(bup);
		
		setResizable(false);
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				switch (direction) {
					
				case UP:
					board.moveUp();
				break;
					
				case DOWN:
					board.moveDown();
				break;
					
				case LEFT:
					board.moveLeft();
				break;
					
				case RIGHT:			
					board.moveRight();
				break;
					
				}
				repaint();
				
			}
		}, 1*300, 1*300);
		
		// Awaits the Window closing in order to terminate the program
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent ev) {
				
				System.exit(0);
				
			}
			
		});
		
		bleft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				direction = Direction.LEFT;
				
			}
		});
		
		bright.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				direction = Direction.RIGHT;
				
			}
		});

		bup.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
			
				direction = Direction.UP;
			
			}
		});

		bdown.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
			
				direction = Direction.DOWN;
			
			}
		});
		
	}


}
