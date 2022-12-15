package breakoutBall;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements ActionListener, KeyListener {
	
	private boolean play = false;
	private int score = 0;
	private int totalbricks = 36;
	private MapGen mapGen;
	
	//Timer
	private Timer timer;
	private int delay = 8;
	
	//position of paddle
	private int playerX = 310;
	
	//position of ball
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
/**
 *Constructor for Gameplay enables key inputs for players
 */
public Gameplay () {
	mapGen = new MapGen(5,5);
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
    timer = new Timer(delay, this);
    timer.start(); 
	
}
	public void paint(Graphics g)
	{    		
		// background
		Color deepBlue = new Color (0x241734);
		g.setColor(deepBlue);
		g.fillRect(1, 1, 692, 592);
		
		//drawing map
		mapGen.draw((Graphics2D) g);
		
		// borders
		Color navy = new Color (0x2E2157);
		g.setColor(navy);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(681, 0, 3, 592);
		
		// the paddle
		Color magenta = new Color (0xFD3777);
		g.setColor(magenta);
		g.fillRect(playerX, 550, 100, 8);
		
		// the ball
		Color vomitYellow = new Color (0xF9C80E);
		g.setColor(vomitYellow);
		g.fillOval(ballposX, ballposY, 20, 20);
	
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			//Check bounds
			if (playerX >= 600) {
				playerX = 600;
			}
			else {
				moveRight();
				//System.out.println("Right");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			//Check bounds
			if (playerX < 10 ) {
				playerX = 10;
			}
			else {
				moveLeft();
				//System.out.println("Left");
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (play) {
			ballposX -= ballXdir;
			ballposY -= ballYdir;
			
			//Bounds check, balls bounce back if hitting a corner
			if (ballposX < 0 || ballposX > 665) {
				ballXdir = -ballXdir;
			}
			if (ballposY < 0) {
				 ballYdir = -ballYdir;
			}
			//Collision check between ball and paddle
			if (new Rectangle (ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))){
				ballYdir = -ballYdir;
			}
			
		}
		repaint();
		
	}
	
	public void moveLeft() {
		play = true;
		playerX -= 15;
	}
	
	public void moveRight() {
		play = true;
		playerX += 15;
		
	}
	
	
}
