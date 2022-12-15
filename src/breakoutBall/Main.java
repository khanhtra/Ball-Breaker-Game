package breakoutBall;

/**
 *Practice using Java Swing, used to understand the basics of creating a game using JFrame API
 *Code is referenced from https://kalgi-shah.medium.com/breakout-ball-game-using-java-1ce794a451eb
 **/
import javax.swing.JFrame; //GUI Widget toolkit

public class Main {

	public static void main (String[] args) {
		JFrame frame = new JFrame ();
		Gameplay gamePlay = new Gameplay();
		
		//Sets game window
		frame.setBounds(200, 100, 700, 600);
		frame.setTitle("Breakout");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(gamePlay);
		frame.setVisible(true);
	}
}
