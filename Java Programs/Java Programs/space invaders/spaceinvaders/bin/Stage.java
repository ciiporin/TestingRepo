package bin;

    //interface for receiving notifications about Image 
//information as the Image is constructed.
    import java.awt.image.ImageObserver;
   
   
   
//the stage will interact/interface with the image observer as defined by the below
    //variable declarations as well with the spritecache
	public interface Stage extends ImageObserver {
      public static final int WIDTH=650;
      public static final int HEIGHT=700;
      public static final int SPEED=5;
      public SpriteCache getSpriteCache();
     
      
    	   
      
     //add the class actor for use by the stage class 
      public void addActor(Actor a);




	public Player getPlayer();
    }

   