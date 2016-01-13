import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Coin 
{

	private ImageIcon image;
	 private int x,y;
	 public Coin(int x,int y){
	     ImageIcon ii = new ImageIcon(this.getClass().getResource("Anim12.gif"));
	     image = ii;
	     this.x = x;
	     this.y = 40;
	 }

	 public int getX(){
	     return x;
	 }

	 public int getY(){
	     return y;
	 }

	 public ImageIcon getImage(){
	     return image;
	 }

	public Rectangle getBounds(){
	 return new Rectangle(x, y, 40, 30);
	}
}
