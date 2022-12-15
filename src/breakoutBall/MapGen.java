package breakoutBall;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class to generate the map of the Breakout game, i.e. the bricks
 */
public class MapGen {

	public int map[][];
	public int brickWidth;
	public int brickHeight;

/**
 * Constructs the initial amount of rows and columns of bricks for the layout
 * @param row
 * @param col
 */
public MapGen (int row, int col)
	{
		map = new int[row][col];		
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				//here 1 will detect that brick is not intersected with the ball
				map[i][j] = 1;
			}			
		}
		
		brickWidth = 540/col;
		brickHeight = 150/row;
	}		
/**
 * Creates the bricks' colors and sizes
 * @param g
 * The graphics to be set on the screen/window of the game
 */
public void draw(Graphics2D g) {
	for (int i = 0; i < map.length; i++) {
		for (int j = 0; j < map[0].length; j++) {
			if (map[i][j] > 0) {
				Color brightRed = new Color (0xFD1D53);
				g.setColor(brightRed);
				g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				Color navy = new Color (0x2E2157);
				g.setColor(navy);
				g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
			}
		}
	}
	
}
/**
 * When the ball hits a brick, it should be destroyed
 * @param value
 * 	value to indicate brick is gone, i.e. 0
 * @param row
 * 	row of brick
 * @param col
 * 	column of brick
 */
public void destroyBrick(int value, int row, int col) {
	map[row][col] = value;
}
}
