//Matthew Hinton
//4/7/17
//CS 3 H 6th Period
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Manages the Hydrogen2 atom, which is two hydrogens
 *
 */
public class Hydrogen2 extends Atom{

	/**
	 * Constructs a Hydrogen2 object, which serves as the runnable for the thread,and manages the motion of the atom as well
	 * @param x the starting x location
	 * @param y the starting y location
	 * @param magnitudeX the speed in the x direction
	 * @param magnitudeY the speed in the y direction
	 * @param directionX the direction in the x
	 * @param directionY the direction in the y
	 * @param screen the screen in which the atom exists
	 */
	public Hydrogen2(int x, int y, int magnitudeX, int magnitudeY, int directionX, int directionY, Screen screen) {
		super(x, y, magnitudeX, magnitudeY, directionX, directionY, screen);
		// TODO Auto-generated constructor stub
	}
	/**
	 * draws the oxygen atom on the graphics provided
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
	}
	/**
	 * checks if a Oxygen atom is on it, and reacts with it, creating a water molecule
	 */
	public void react()
	{
		for(int i = 0;i<Screen.atoms.size();i++)
		{ Atom a = Screen.atoms.get(i);
		if(a instanceof Oxygen && a.x>=this.x&&a.x<=this.x+20&&a.y>=this.y&&a.y<=this.y+20)
		{
		//	System.out.println("Before"+Screen.atoms);
			Screen.atoms.remove(this);
			Screen.atoms.remove(a);
			//System.out.println("After"+Screen.atoms);
			Water temp = new Water(x,y,magnitudeX,magnitudeY,directionX,directionY,screen);
			Screen.atoms.add(temp);
			Thread t = new Thread(temp);
			t.start();
			temp.t=t;
			
			//t.stop();
			break;
		}
		}
	}
}
