//Matthew Hinton
//4/7/17
//CS 3 H 6th Period
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/**
 * The Atom class controls the motion and operation of one atom.
 *
 */
public class Atom implements Runnable{
	public int directionX, directionY;
	public int magnitudeX,magnitudeY;
	public int x,y;
	public Thread t;
public static final int NORTH =-1;
public static final int EAST = 1;
public static final int SOUTH =1;
public static final int WEST = -1;
public static final int SOUTHNORNORTH =0;
public static final int WESTNOREAST = 0;
Screen screen;
/**
 * Constructs a Atom object, which serves as the runnable for the thread,and manages the motion of the atom as well
 * @param x the starting x location
 * @param y the starting y location
 * @param magnitudeX the speed in the x direction
 * @param magnitudeY the speed in the y direction
 * @param directionX the direction in the x
 * @param directionY the direction in the y
 * @param screen the screen in which the atom exists
 */
	public Atom(int x,int y,int magnitudeX,int magnitudeY,int directionX, int directionY, Screen screen )
	{
		this.x=x;
		this.y=y;
		this.magnitudeX=magnitudeX;
		this.magnitudeY=magnitudeY;
		this.directionX=directionX;
		this.directionY=directionY;
		this.screen=screen;
	}
	/**
	 * Draws the base atom for all structures
	 * @param g the graphics to draw on
	 */
	public void draw(Graphics g)
	{
		g.setColor(Color.red);
		g.fillOval(x, y, 20, 20);
	}
	/**
	 * moves the atom based on its magnitude and direction it is traveling
	 */
	public void move()
	{
		int deltaX = magnitudeX*directionX;
		int deltaY = magnitudeY*directionY;
		int tempX = x+deltaX;
		int tempY = y+deltaY;
		//System.out.println(directionX+ " "+directionY);
		if(tempX<0||tempX>360)
		{
			directionX*=-1;
			int random = (int)(Math.random()*3);
			if(random==0)directionY=-1;
			else if(random==1)directionY=0;
			else directionY = 1;
		}
		if(tempY<0||tempY>330)
		{
			directionY*=-1;
			int random = (int)(Math.random()*3);
			if(random==0)directionX=-1;
			else if(random==1)directionX=0;
			else directionX = 1;
		}
		if(directionX==0&&directionY==0)directionX=1;
		 deltaX = magnitudeX*directionX;
		 deltaY = magnitudeY*directionY;
		x+=deltaX;
		y+=deltaY;
		
	}
	@Override
	/**
	 * runs the thread, causing the atom to move
	 */
	public void run() {
		for(int i = 0;i<1000;i++)
		{
			move();
			if(screen!=null)
			screen.repaint();
			if(i>50)react();
			//System.out.println(x+ " "+y);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * override in subclasses to obtain functionality.
	 */
	public void react(){}

}
