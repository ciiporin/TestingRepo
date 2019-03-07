package SpaceInvaders;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.math.*;
import java.awt.image.BufferedImage;

public class Actor {
	
	 
	

protected String[] spriteNames;
protected int height, width;	
	protected SpriteCache spritecache;
	

	public void act() {
		// TODO Auto-generated method stub
		
	}

	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
	 	
		
	}
	
	public void setSpriteName(String[] names) {
		
		spriteNames = names;
		
		height = 0;
		width = 0;
		
		for (int i=0; i < names.length; i++) {
		
			BufferedImage image = spritecache.getSprite (spriteNames[i]);
			
			height = Math.max(height,image.getHeight());
			width = Math.max(width,image.getWidth());
			
			
		}
	}
		
	
	// TODO Auto-generated method stub
	
	public int getHeight() { return height; }
	public int getWidth(){ return width; }
	public void setHeight(int i){height = i;}
	public void setWidth(int i){width = i;}
		
	

	
	public void collision(Actor a1) {
		// TODO Auto-generated method stub
		
	}

	public void collision(Player player) {
		// TODO Auto-generated method stub
		
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle();
	}

	public boolean isMarkedForRemoval() {
		// TODO Auto-generated method stub
		return false;
	}

}
