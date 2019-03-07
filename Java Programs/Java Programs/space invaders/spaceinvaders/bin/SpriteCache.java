package bin;

    
    import java.awt.image.BufferedImage;
    import java.net.URL;
    import java.util.HashMap;
    
import javax.imageio.ImageIO;
    
    public class SpriteCache {
      private HashMap<String, BufferedImage> sprites;
     
      public SpriteCache() {
        sprites = new HashMap<String, BufferedImage>();
      }
      
      private BufferedImage loadImage(String SpaceInvader0) {
        URL url=null;
        try {
          url = getClass().getClassLoader().getResource(SpaceInvader0);
          return ImageIO.read(url);
        } catch (Exception e) {
         
          System.exit(0);
          return null;
        }
      }
      
      public BufferedImage getSprite(String SpaceInvader0) {
        BufferedImage img = (BufferedImage)sprites.get(SpaceInvader0);
        if (img == null) {
          img = loadImage("Resources/"+SpaceInvader0);
          sprites.put(SpaceInvader0,img);
        }
        return img;
      }
    }
    
