import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Toro extends Thread
{
	Component yo;
	Component c;
	
	public Toro(Component c,Component yo)
	{
		this.c=c;
		this.yo=yo;
	}
	

	public void run() 
	{
		int x=0;
		int y=0;
		while(true)
		{
			if(yo.getX()<c.getX())
			{
				x=yo.getX()+3;
			}
			if(yo.getY()<c.getY())
			{
				y=c.getY()+3;
			}
			else y=c.getY()-3;
			yo.setBounds(x, y, yo.getWidth(), yo.getHeight());
			try {
				System.out.println("a");
				Thread.sleep(250);
				System.out.println("b");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(c.getBounds().intersects(yo.getBounds()))
				break;
		}
	}

}
