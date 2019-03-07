import javax.swing.*;   
    import javax.swing.event.*;   
    import java.io.*;   
    import java.net.MalformedURLException;   
    import java.net.URL;   
  
    import javax.media.*;   
    import javax.media.format.*;   
    import javax.media.util.*;   
    import javax.media.control.*;   
    import javax.media.protocol.*;   
    import java.util.*;   
    import java.awt.*;   
    import java.awt.image.*;   
    import java.awt.event.*;   
    import com.sun.image.codec.jpeg.*;   
        
    public class VideoPic extends Panel implements ActionListener    
    {   
      public static Player player = null;   
      public CaptureDeviceInfo di = null;   
      public MediaLocator ml = null;   
      public JButton capture = null;   
      public Buffer buf = null;   
      public Image img = null;   
      public VideoFormat vf = null;   
      public BufferToImage btoi = null;   
      public ImagePanel imgpanel = null;   
         
      public VideoPic(URL mediaURL)    
      {   
        setLayout(new BorderLayout());   
        setSize(320,550);   
           
        imgpanel = new ImagePanel();   
        capture = new JButton("Capture");   
        capture.addActionListener(this);   
           
        String str1 = "vfw:Logitech USB Video Camera:0";   
        String str2 = "vfw:Microsoft WDM Image Capture (Win32):0";   
        di = CaptureDeviceManager.getDevice(str1);   
        ml = di.getLocator();   
           
        try    
        {   
               
               
            
         player=Manager.createRealizedPlayer(mediaURL);   
          player.start();   
          try{   
              Thread.sleep(1000);   
          }   
          catch(Exception e)   
          {   
                 
          }   
          Component comp;   
             
          if ((comp = player.getVisualComponent()) != null)   
          {   
            add(comp,BorderLayout.NORTH);   
          }   
            
          Component controls = player.getControlPanelComponent();   
          if (controls  != null)   
          {   
            add(controls,BorderLayout.NORTH);   
           add(comp,BorderLayout.NORTH);   
          }   
             
          add(capture,BorderLayout.CENTER);   
          add(imgpanel,BorderLayout.SOUTH);   
        }    
        catch (Exception e)    
        {   
          e.printStackTrace();   
        }   
      }   
        
        
         
      public static void main(String[] args)    
      {   
          JFileChooser fileChooser = new JFileChooser();   
             int result = fileChooser.showOpenDialog( null );   
              URL mediaURL = null;   
             if ( result == JFileChooser.APPROVE_OPTION ) // user chose a file   
                {   
                    
                      
                   try  
                   {   
                      // get the file as URL   
                      mediaURL = fileChooser.getSelectedFile().toURL();   
                   } // end try   
                   catch (MalformedURLException malformedURLException )   
                   {   
                      System.err.println( "Could not create URL for the file" );   
                   } // end catch   
  
               } // end outer if   
                
        Frame f = new Frame("SwingCapture");   
        VideoPic cf = new VideoPic(mediaURL);   
           
        f.addWindowListener(new WindowAdapter() {   
          public void windowClosing(WindowEvent e) {   
              VideoPic.playerclose();   
          System.exit(0);}});   
           
        f.add("Center",cf);   
        f.pack();   
        f.setSize(new Dimension(320,550));   
        f.setVisible(true);   
      }   
         
         
      public static void playerclose()    
      {   
        player.close();   
        player.deallocate();   
      }   
         
        
      public void actionPerformed(ActionEvent e)    
      {   
        JComponent c = (JComponent) e.getSource();   
           
        if (c == capture)    
        {   
          // Grab a frame   
          FrameGrabbingControl fgc = (FrameGrabbingControl)player.getControl("javax.media.control.FrameGrabbingControl");   
          player.prefetch();   
             
          buf = fgc.grabFrame();   
            
          btoi = new BufferToImage((VideoFormat)buf.getFormat());   
          img = btoi.createImage(buf);   
             
          // show the image   
          imgpanel.setImage(img);   
             
          // save image   
          saveJPG(img,"c:\\test.jpg");   
        }   
      }   
         
      class ImagePanel extends Panel    
      {   
        public Image myimg = null;   
           
        public ImagePanel()    
        {   
          setLayout(null);   
          setSize(320,240);   
        }   
           
        public void setImage(Image img)    
        {   
          this.myimg = img;   
          repaint();   
        }   
           
        public void paint(Graphics g)    
        {   
          if (myimg != null)    
          {   
            g.drawImage(myimg, 0, 0, this);   
          }   
        }   
      }   
         
        
      public static void saveJPG(Image img, String s)   
      {   
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);   
        Graphics2D g2 = bi.createGraphics();   
        g2.drawImage(img, null, null);   
        
        FileOutputStream out = null;   
        try  
        {    
          out = new FileOutputStream(s);    
        }   
        catch (java.io.FileNotFoundException io)   
        {    
          System.out.println("File Not Found");    
        }   
           
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);   
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bi);   
        param.setQuality(0.5f,false);   
        encoder.setJPEGEncodeParam(param);   
           
        try    
        {    
          encoder.encode(bi);    
          out.close();    
        }   
        catch (java.io.IOException io)    
        {   
          System.out.println("IOException");    
        }   
      }   
         
    }   
