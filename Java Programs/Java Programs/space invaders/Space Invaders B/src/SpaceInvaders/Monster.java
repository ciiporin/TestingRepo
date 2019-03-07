package SpaceInvaders;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;




public class Monster extends Actor implements Stage{

//Inserts SpaceInvader0 onto the Space Invaders game.
	
    private final String shot = "SpaceInvader0.gif";
    private File imageFile;
//Image with accessible buffer of image data.    
    private BufferedImage bufferedImage;
//Source of coding to locate, read and write image files.    
    private static ImageIO imageIO;
    private static AffineTransform transformer;
        
    static int MONSTER_X ;
    static int MONSTER_Y;
    static int MONSTER_VX;
    
    public Monster(int x, int y) {
        this.MONSTER_X = x;
       this.MONSTER_Y = y;

       //setSpriteName = new String [] ("SpaceInvader0.gif")	;

    }

    public Monster(Stage stage) {
		// TODO Auto-generated constructor stub
	}

	private BufferedImage loadImage(String SpaceInvader0){
		return bufferedImage;
    }
    
   //Acquired from SpriteCache coding to link classes together. 
    
    public BufferedImage getSprite(String SpaceInvader0){
		return bufferedImage;
    	
    }
    
    public void act(int direction) {
        //this.x += direction;
    }

   //Locates SpaceInvader0 object from source 
    
    public void paint(Graphics2D g) {
    	// TODO Auto-generated method stub

    	imageFile = new File
    	("src\\SpaceInvader0.gif");
    	
   //Attempts to read the image before catching it and drawing it onto the SpaceInvaders class.
    	
    	try{
    		bufferedImage = ImageIO.read(imageFile);
    		
    	} catch (IOException e){
    	
    	e.printStackTrace();
    	}
    	g.drawRenderedImage(bufferedImage,transformer.getTranslateInstance(MONSTER_X,MONSTER_Y));
    	
    	
    	
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
public boolean imageUpdate(Image img, int infoflags, int x, int y, int width,
		int height) {
	// TODO Auto-generated method stub
	return false;
}

public void setVx(int i) {
	// TODO Auto-generated method stub
	
}

public void setY(int i) {
	// TODO Auto-generated method stub
	
}

public void setX(int i) {
	// TODO Auto-generated method stub
	
}




        

     //   public void setDestroyed(boolean destroyed) {
      //     this.destroyed = destroyed;
      //  }

     //   public boolean isDestroyed() {
       //     return destroyed;
      //  }
    }

