//Matthew Hinton
//4/7/17
//CS 3 H 6th Period
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Manages the Oxygen atom
 *
 */
public class Oxygen extends Atom{

	/**
	 * Constructs a Oxygen object, which serves as the runnable for the thread,and manages the motion of the atom as well
	 * @param x the starting x location
	 * @param y the starting y location
	 * @param magnitudeX the speed in the x direction
	 * @param magnitudeY the speed in the y direction
	 * @param directionX the direction in the x
	 * @param directionY the direction in the y
	 * @param screen the screen in which the atom exists
	 */
	public Oxygen(int x, int y, int magnitudeX, int magnitudeY, int directionX, int directionY, Screen screen) {
		super(x, y, magnitudeX, magnitudeY, directionX, directionY, screen);
	}
	/**
	 * draws the oxygen atom on the graphics provided
	 * @param g the graphics to draw on
	 */
	public void draw(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillOval(x, y, 40, 40);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Bold", Font.BOLD, 20));
		g.drawString("O", x+15, y+30);
	}
}
