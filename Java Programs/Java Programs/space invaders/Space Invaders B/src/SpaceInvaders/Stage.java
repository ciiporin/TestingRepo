package SpaceInvaders;

import java.awt.image.ImageObserver;

public interface Stage extends ImageObserver {

	
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 600;
	public static final int MONSTER_HEIGHT = 15;
	public static final int MONSTER_WIDTH = 15;
	public static final int PLAYER_HEIGHT = 12;
	public static final int PLAYER_WIDTH = 15;
	public static final int SPEED = 30;
	public static final int CHANCE = 3;
	public static final int NUMBER_OF_MONSTERS_TO_KILL = 30;
    int MONSTER_X =0;
    int MONSTER_Y=0;
    int MONSTER_VX=0;
	public SpriteCache getSpriteCache();
	public void addActor(Actor a);
		
}

