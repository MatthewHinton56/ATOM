//Matthew Hinton
//4/7/17
//CS 3 H 6th Period
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/**
 * Manages the Water atom, which is two hydrogens and one oxygen
 *
 */
public class Water extends Atom{
	/**
	 * Constructs a Water object, which serves as the runnable for the thread,and manages the motion of the atom as well
	 * @param x the starting x location
	 * @param y the starting y location
	 * @param magnitudeX the speed in the x direction
	 * @param magnitudeY the speed in the y direction
	 * @param directionX the direction in the x
	 * @param directionY the direction in the y
	 * @param screen the screen in which the atom exists
	 */
	public Water(int x, int y, int magnitudeX, int magnitudeY, int directionX, int directionY, Screen screen) {
		super(x, y, magnitudeX, magnitudeY, directionX, directionY, screen);
	}
	/**
	 * draws the water molecule on the graphics provided
	 * @param g the graphics to draw on
	 */
	public void draw(Graphics g)
	{
		super.draw(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Bold", Font.BOLD, 16));
		g.drawString("H", x+5, y+17);
		g.setColor(Color.red);
		g.fillOval(x+20, y, 20, 20);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Bold", Font.BOLD, 16));
		g.drawString("H", x+25, y+17);
		g.setColor(Color.BLUE);
		g.fillOval(x,y+15, 40, 40);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Bold", Font.BOLD, 20));
		g.drawString("O", x+15, y+45);
	}
}
