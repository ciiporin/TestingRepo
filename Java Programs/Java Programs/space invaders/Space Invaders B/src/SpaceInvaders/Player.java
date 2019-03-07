package SpaceInvaders;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;



	public class Player extends Actor implements Stage{

    private BufferedImage bufferedImage;
    private File imageFile;
    private static ImageIO imageIO;
    private static AffineTransform transformer;
	private final String Player =("Player.gif");
	protected int dx;
	

	
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	
    static int PLAYER_X = 500;
    static int PLAYER_Y = 450;
	private int width;
	private String getSpriteCache;


	public Player() {

}

	public Player(SpaceInvaders spaceInvaders, String string, int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public Player(Stage stage) {
		// TODO Auto-generated constructor stub
	}

	public void act() {
		
		
		
		PLAYER_X+= dx;
		
		if (PLAYER_X < 0 || PLAYER_X > Stage.WIDTH)
			dx = - dx;
		if (PLAYER_X >= WIDTH - 2*width)
			PLAYER_X = WIDTH - 2*width;
		
  //setSpriteName = new String [] ("Player.gif")	;

}

	 public void keyPressed(KeyEvent e) {
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT); 
	        {
	        boolean leftPressed = true;
	        
	            dx = -5;
	        }

	        if (key == KeyEvent.VK_RIGHT)
	        {
	            boolean rightPressed = true;
	        	dx = +5;
	        }

	    }

	    public void keyReleased(KeyEvent e) {
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT)
	        {
	        	boolean leftPressed = true;
	            dx = 0;
	        }

	        if (key == KeyEvent.VK_RIGHT)
	        {
	        	boolean rightPressed = true;
	            dx = 0;
	        }
	    }





public Rectangle getBounds() {
	// TODO Auto-generated method stub
	return new Rectangle();
}

public void setX(int i) {
	// TODO Auto-generated method stub
	
}

public void setY(int i) {
	// TODO Auto-generated method stub
	
}

public void collision(Actor a1) {
	// TODO Auto-generated method stub
	
}

public void paint(Graphics2D g) {
	// TODO Auto-generated method stub

	imageFile = new File
	("src\\Player.gif");
	
	try{
		bufferedImage = ImageIO.read(imageFile);
		
	} catch (IOException e){
	
	e.printStackTrace();
	}
	g.drawRenderedImage(bufferedImage,transformer.getTranslateInstance(PLAYER_X,PLAYER_Y));
	
	
	
}


public int getHeight() {
	// TODO Auto-generated method stub
	return 0;
}

public void add(Player player2) {
	// TODO Auto-generated method stub
	
}

@Override
public void addActor(Actor a) {
	// TODO Auto-generated method stub
	
}

@Override
public SpriteCache getSpriteCache() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4,
		int arg5) {
	// TODO Auto-generated method stub
	return false;
}
}