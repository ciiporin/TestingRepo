package SpaceInvaders;


	import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.image.BufferedImage;

//defining the locations.  
	public class Bomb extends Actor {
		int setImage;
		int setY;
		int setX;

//setting the bullets as string & defining the H space & V space 
	    private String Bullets = "bullet.gif";
	    private final int H_SPACE = 6;
	    private final int V_SPACE = 1;

	    public Bomb() {
	    }

	    public Bomb(int x, int y) {

	        ImageIcon ii = new ImageIcon(this.getClass().getResource(Bullets));
	        setImage(ii.getImage());
	        setX(x + H_SPACE);
	        setY(y - V_SPACE);
	    }

		private void setImage(Image image) {
			// TODO Auto-generated method stub
			
		}

		private void setY(int i) {
			// TODO Auto-generated method stub
			
		}

		private void setX(int i) {
			// TODO Auto-generated method stub
			
		}}