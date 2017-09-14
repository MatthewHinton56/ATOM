//Matthew Hinton
//4/7/17
//CS 3 H 6th Period
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * This class creates and manages the JFrame responnsible for displaying the cycle
 * 
 *
 */
public class AtomFrame extends JFrame implements ActionListener{
	private JPanel panel;
	private Screen screen;
	/**
	 * Constructs an AtomFrame which displays the scene of atoms reacting
	 */
	public AtomFrame()
	{
		setTitle("Water Atom Formation");
		this.setLayout(new BorderLayout());
		Screen screen = new Screen();
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		JButton Hydrogen = new JButton("Hydrogen");
		JButton Oxygen = new JButton("Oxygen");
		Hydrogen.addActionListener(this);
		Oxygen.addActionListener(this);
		panel.add(Hydrogen);
		panel.add(Oxygen);
		this.add(panel,BorderLayout.SOUTH);
		this.add(screen);
		this.setSize(400,500);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	/**
	 * Tracks the button presses of the frame, creating atoms as requested
	 * @param e the event that occurs
	 */
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		if(button.getText().equals("Hydrogen"))
		{
			int directionX = ((int)(Math.random()*3))-1;
			int directionY = ((int)(Math.random()*3))-1;
			int magnitudeX = ((int)(Math.random()*11))+10;
			int magnitudeY = ((int)(Math.random()*11))+10;
			if(directionX==0&&directionY==directionX)directionX=1;
			int x = ((int)(Math.random()*361));
			int y = ((int)(Math.random()*331));
			Hydrogen h = new Hydrogen(x,y,magnitudeX,magnitudeY,directionX,directionY,screen);
			Screen.atoms.add(h);
			Thread t = (new Thread(h));
			h.t=t;
			t.start();
		}
		if(button.getText().equals("Oxygen"))
		{
			int directionX = ((int)(Math.random()*3))-1;
			int directionY = ((int)(Math.random()*3))-1;
			int magnitudeX = ((int)(Math.random()*11))+10;
			int magnitudeY = ((int)(Math.random()*11))+10;
			if(directionX==0&&directionY==directionX)directionX=1;
			int x = ((int)(Math.random()*361));
			int y = ((int)(Math.random()*331));
			Oxygen h = new Oxygen(x,y,magnitudeX,magnitudeY,directionX,directionY,screen);
			Screen.atoms.add(h);
			Thread t = (new Thread(h));
			h.t=t;
			t.start();
		}
	}
	public static void main(String[] args) {
		new AtomFrame();
	}
	
}
