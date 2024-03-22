package logic;

import org.junit.jupiter.api.Test;

class SnakeAreaTest {

	@Test
	void test() {
		
		SnakeArea sArea = new SnakeArea();
		System.out.print(sArea);
	}
	
	@Test
	void testMoveLeft() {
		
		SnakeArea sArea = new SnakeArea();
		System.out.print(sArea);
		sArea.moveLeft();
		System.out.print(sArea);
	}

}
