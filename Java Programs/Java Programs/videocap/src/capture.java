import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.CaptureDeviceInfo;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JFrame;

public class capture {
	CaptureDeviceInfo di = null;
	try{
	MediaLocator loc= new MediaLocator("vfw://0"); 
        Player p = null;
        try {
            p = Manager.createRealizedPlayer(loc);
        } catch (IOException ex) {
            Logger.getLogger(capture.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoPlayerException ex) {
            Logger.getLogger(capture.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(capture.class.getName()).log(Level.SEVERE, null, ex);
        }
	p.start();
        JFrame f = new JFrame();
	t.setTitle("StuMgtSystem Java:Lecture");
	t.setLayout(new BorderLayout());
	t.add("South", p.getControlPanelComponent());
	// Adding the Visual Component to display Video captured by Player 
	// from URL provided by MediaLocator
	t.add(p.getVisualComponent(), BorderLayout.CENTER);
	t.pack(); 
	t.setSize(200, 100);
	t.setVisible(true);
	t.setTitle("Capturing ON");
	}catch(Exception e){
	e.printStackTrace();
	}}}


