package gui;

public class SnakeArea {
	
	static final int collums = 10;
	static final int rows = 10;
	
	/**
	 * 

	0 1 2 3 4 5 6 7 8 9 10
0	. . . . . . . . . . .
1	. . . . . . . . . . .
2	. . . . . . . . . . .
3	. . . . . . . . . . .
4	. . . . . . . . . . .
5	. . . . . . . . . . .
6	. . . . . . . . . . .
7	. . . . . . . . . . .
8	. . . . . . . . . . .
9	. . . . . . . . . . .
10	. . . . . . . . . . .

	 */
	
	@Override
	public String toString() {
		
		String areaStr = "";
		
		areaStr += " 0 1 2 3 4 5 6 7 8 9 10";
		areaStr += " \n";
		
		for (int i = 0; i <= rows; i++) {
			
			for (int j = 0; j <= collums; j++) {
				
				areaStr += " .";
				
			}
			
			areaStr += "\n";
			
		}
		return areaStr;
	}

}
