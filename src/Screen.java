//Matthew Hinton
//4/7/17
//CS 3 H 6th Period

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Screen extends JComponent {
	public static ArrayList<Atom> atoms;
	private Lock lock;
	private Image image;
	/**
	 * Constructs the viewing screen.
	 */
	public Screen()
	{	atoms = new ArrayList<Atom>();
	lock = new ReentrantLock();
		for(int i  = 0;i<5;i++)
		{
		int directionX = ((int)(Math.random()*3))-1;
		int directionY = ((int)(Math.random()*3))-1;
		int magnitudeX = ((int)(Math.random()*11))+10;
		int magnitudeY = ((int)(Math.random()*11))+10;
		if(directionX==0&&directionY==directionX)directionX=1;
		int x = ((int)(Math.random()*361));
		int y = ((int)(Math.random()*331));
		atoms.add(new Hydrogen(x,y,magnitudeX,magnitudeY,directionX,directionY,this));
		//System.out.println(magnitudeX+ " "+magnitudeY);
		}
		for(int i  = 0;i<5;i++)
		{
		int directionX = ((int)(Math.random()*3))-1;
		int directionY = ((int)(Math.random()*3))-1;
		int magnitudeX = ((int)(Math.random()*11))+10;
		int magnitudeY = ((int)(Math.random()*11))+10;
		if(directionX==0&&directionY==directionX)directionX=1;
		int x = ((int)(Math.random()*361));
		int y = ((int)(Math.random()*331));
		atoms.add(new Oxygen(x,y,magnitudeX,magnitudeY,directionX,directionY,this));
	//	System.out.println(magnitudeX+ " "+magnitudeY);
		}
		for(Atom a:atoms)
			{
			Thread t = (new Thread(a));
			a.t=t;
			t.start();
			}
		 
		 try {
		        image = ImageIO.read(this.getClass().getResource("/img/Water.jpg")); 
		    } catch (IOException exp) {
		        exp.printStackTrace();
		    }
	}
	/**
	 * paints the component using the atoms draw methods
	 * @param g the components graphics
	 */
	public void paintComponent(Graphics g)
	{
		if(image!=null)g.drawImage(image, 0, 0, 400, 400, null);
		lock.lock();
		for(int i = 0;i<atoms.size();i++)
			{
			if(i<atoms.size())
			{
				Atom a = atoms.get(i);
			if(a!=null)	
			a.draw(g);
			}
			}
		lock.unlock();
	}


}