
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener{

	private static JLabel jLabel1;
	private static JLabel jLabel2;
	private JButton jButton1;
	private JLabel jLabel3;
	Thread t2;
	Toro t;
	hilo h;

	static Coin c=new Coin(60,0);
	static Coin c2=new Coin(145,110);
	
	public Game() 
	{

		setFocusable(true);
		this.setPreferredSize(new java.awt.Dimension(630, 180));
		this.setLayout(null);
		{
			jLabel1 = new JLabel();
			jLabel1.setBounds(0, 22, 16, 17);
			this.add(jLabel1);
			jLabel1.setText("1");
			
		}
		{
			jLabel2 = new JLabel();
			this.add(jLabel2);
			jLabel2.setBounds(247, 72, 17, 18);
			jLabel2.setText("2");
		}
		{
			jButton1 = new JButton();
			this.add(jButton1);
			jButton1.setText("jButton1");
			jButton1.setBounds(247, 157, 59, 23);
			jButton1.addActionListener(this);
		}
		{
			jLabel3 = new JLabel();
			this.add(jLabel3);
			jLabel3.setText("3");
			jLabel3.setBounds(37, 125, 16, 16);
		}
		h=new hilo();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	public class hilo extends Thread
	{
		int x=0;
		int y=0;
		int x2=0;
		int y2=0;
		public void run()
		{
			boolean v=true;
			while (v==true)
			{
				jLabel2.setBounds(jLabel2.getX()+2, jLabel2.getY(), jLabel2.getWidth(), jLabel2.getHeight());
				if(jLabel1.getX()<jLabel2.getX())
				{
					x=jLabel1.getX()+3;
				}
				if(jLabel1.getY()<jLabel2.getY())
				{
					y=jLabel1.getY()+3;
				}
				else y=jLabel1.getY()-3;
				jLabel1.setBounds(x, y, jLabel1.getWidth(), jLabel1.getHeight());
				
				if(jLabel3.getX()<jLabel2.getX())
				{
					x2=jLabel3.getX()+3;
				}
				if(jLabel3.getY()<jLabel2.getY())
				{
					y2=jLabel2.getY()+3;
				}
				else y2=jLabel3.getY()-3;
				jLabel3.setBounds(x2, y2, jLabel3.getWidth(), jLabel3.getHeight());
				try {
					h.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(jLabel2.getBounds().intersects(jLabel1.getBounds()))
				{
					v=false;
					JOptionPane.showMessageDialog(null, "detuvo el 1");
				}
				if(jLabel2.getBounds().intersects(jLabel3.getBounds()))
				{
					v=false;
					JOptionPane.showMessageDialog(null, "detuvo el 2");
				}
			}
		}
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

//	public static void mover() throws InterruptedException
//	{
//		int x=0;
//		int y=0;
//		boolean v=true;
//		while (v==true)
//		{
//			jLabel2.setBounds(jLabel2.getX()+2, jLabel2.getY(), jLabel2.getWidth(), jLabel2.getHeight());
//			//jLabel2.setBounds(jLabel2.getX(), jLabel2.getY()-5, jLabel2.getWidth(), jLabel2.getHeight());
//			//System.out.println(jLabel1.getY()+","+jLabel2.getY());
//			//if(jLabel1.getBounds().intersects(jLabel2.getBounds()))
////			{
////				v=false;
////				JOptionPane.showMessageDialog(null, "detener");
////			}
//			if(jLabel1.getX()<jLabel2.getX())
//			{
//				x=jLabel1.getX()+3;
//			}
//			if(jLabel1.getY()<jLabel2.getY())
//			{
//				y=jLabel1.getY()+3;
//			}
//			else y=jLabel1.getY()-3;
//			jLabel1.setBounds(x, y, jLabel1.getWidth(), jLabel1.getHeight());
//			
//			Thread.sleep(250);
//			if(jLabel2.getBounds().intersects(jLabel1.getBounds()))
//			{
//				v=false;
//				JOptionPane.showMessageDialog(null, "detener");
//			}
//			
//		}
//	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("atrapar");
		Game game = new Game();
		frame.add(game);
		frame.setSize(630, 180);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jButton1)
		{
			h.start();
		}
		
	}
}