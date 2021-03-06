package SpaceInvaders;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;


public class SpriteCache {
	private HashMap sprites;
	
public SpriteCache(){
	sprites = new HashMap();
}

private BufferedImage loadImage(String SpaceInvader0){
	URL url=null;
	try{
		url = getClass().getClassLoader().getResource(SpaceInvader0);
		return ImageIO.read(url);
	} catch (Exception e){
		System.exit(0);
		return null;
	}
	}

public BufferedImage getSprite(String SpaceInvader0){
	BufferedImage img = (BufferedImage)sprites.get(SpaceInvader0);
	if (img == null){
		img = loadImage("Resources/"+SpaceInvader0);
		sprites.put(SpaceInvader0,img);
		
	}
	return img;
	
}

	
	


//private boolean visible;
//protected Image image;
//protected int x;
//protected int y;
//protected boolean dying;



//visible = true;


//public void die() {
//visible = false;
//}

// boolean isVisible() {
//return visible;
//}

//protected void setVisible(boolean visible) {
//this.visible = visible;
//}

//public void setImage(Image string) {
//this.image = string;
//}

//public Image getImage() {
//return image;
//}

//public void setX(int x) {
//this.x = x;
//}

//public void setY(int y) {
//this.y = y;
//}
//public int getY() {
//return y;
//}

//public int getX() {
//return x;
//}

//public void setDying(boolean dying) {
//this.dying = dying;
//}

//public boolean isDying() {
//return this.dying;
}
