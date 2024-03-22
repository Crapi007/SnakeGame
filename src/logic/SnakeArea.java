package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import characters.SnakeCell;

public class SnakeArea {
	
	public static final int column = 21;
	public static final int rows = 21;
	
	public List<SnakeCell> snake = new ArrayList<SnakeCell>();
	
	public int fruitColumn = 1;
	public int fruitRow = 3;
	
	private Random random;
	
	public SnakeArea() {
		
		// Adds snake head and body parts
		snake.add(new SnakeCell(4, 3));
		snake.add(new SnakeCell(4, 4));
		snake.add(new SnakeCell(5, 4));
		snake.add(new SnakeCell(6, 4));
		snake.add(new SnakeCell(6, 5));
		
		// Create Instance of Random class and generate random start location of the first fruit
		random = new Random();
		fruitColumn = random.nextInt(column);
		fruitRow = random.nextInt(rows);
		
	}
	
	void updateSnake(SnakeCell newHead) {
		
		// Prevent crashing when no snake elements are found
		if (snake.isEmpty()) return;
		
		// Create a new List for the updated snake parts when moving a certain direction
		List<SnakeCell> updatedSnake = new ArrayList<SnakeCell>();
		updatedSnake.add(newHead);
		
		// Go through the previous List with -1 index count, in order to get rid of the latest tail position
		for (int i = 0; i < snake.size() - 1; i++) {
			
			// Add old body parts and leave out the last element 
			updatedSnake.add(snake.get(i));
			
		}
		
		// Leave the tail when going over a fruit and act as a new body part
		if (newHead.column == fruitColumn && newHead.row == fruitRow) {
			
			updatedSnake.add(snake.get(snake.size() - 1));
			
			// Relocate the fruit after pickup
			fruitColumn = random.nextInt(column);
			fruitRow = random.nextInt(rows);
			
		}
		
		snake = updatedSnake;
		
	}
	
	// Method for moving the Snake to the left by adjusting the column value with a negative
	public void moveLeft() {
		
		SnakeCell snakeHead = snake.get(0);
		SnakeCell newHead = new SnakeCell(snakeHead.column - 1, snakeHead.row);
		updateSnake(newHead);

	}
	
		
	
	// Method for moving the Snake to the right by adjusting the column value with a positive
	public void moveRight() {
		
		SnakeCell snakeHead = snake.get(0);
		SnakeCell newHead = new SnakeCell(snakeHead.column + 1, snakeHead.row);
		updateSnake(newHead);

	}
	
	// Method for moving the Snake upwards by adjusting the row value with a negative
	public void moveUp() {
			
		SnakeCell snakeHead = snake.get(0);
		SnakeCell newHead = new SnakeCell(snakeHead.column, snakeHead.row - 1);
		updateSnake(newHead);

	}
	
	// Method for moving the Snake downwards by adjusting the row value with a positive
	public void moveDown() {
		
		SnakeCell snakeHead = snake.get(0);
		
		SnakeCell newHead = new SnakeCell(snakeHead.column, snakeHead.row + 1);
		updateSnake(newHead);
		
	}
	
	// Method for checking all Elements inside the snake List
	boolean isOnSnake(int column, int row) {
		
		for (SnakeCell snakeCell : snake) {
			
			if (column == snakeCell.column && row == snakeCell.row) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * 
	Visualization for the Playable Grid
	0 1 2 3 4 5 6 7 8 9 10
0	. . . . . . . . . . .
1	. . . . . . . . . . .
2	. . . . . . . . . . .
3	. . . . o . . . . . .
4	. . . . o o o . . . .
5	. . . . . . o . . . .
6	. . . . . . . . . . .
7	. . . . . . . . . . .
8	. . . . . . . . . . .
9	. . . . . . . . . . .
10	. . . . . . . . . . .

	 */
	
	// Creates a String and prints out the Visualization inside the Console
	@Override
	public String toString() {
		
		String areaStr = " ";
		
		// Loop for adding the top row numbers
		for (int col = 0; col <= column; col++) {
		
		areaStr += " " + col;
			
		}
		
		// 
		areaStr += " \n";
		
		for (int i = 0; i <= rows; i++) {
			
			areaStr += i;
			
			for (int j = 0; j <= column; j++) {
				
				if (isOnSnake(j, i)){
					
					SnakeCell head = snake.get(0);
					
					if (j == head.column && i == head.row) {
						
						areaStr += " O";
						
					} else {
						
					areaStr += " o";
					
					}
				} else if (i == 10 && j == 0) areaStr += "."; else areaStr += " .";
				
			}
			
			areaStr += "\n";
			
		}
		return areaStr;
	}

}
