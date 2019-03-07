import java.awt.*;import java.awt.event.*;
import java.io.*; import javax.swing.*;
public class FilePicker extends JFrame
{
  String curDir; JLabel statusbar;
  public FilePicker()
  {
    super("FilePicker"); setBounds(100,100,350,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    JButton openButton=new JButton("Open File");
    JButton dirButton=new JButton("Pick Directory");
    curDir=System.getProperty("user.dir") + File.separator;
    statusbar=new JLabel("Output of button choice goes here!");
    Container c=getContentPane();
    c.setLayout(new GridLayout(3,1,5,5));
    c.add(openButton);c.add(dirButton);c.add(statusbar);
    setVisible(true);
    openButton.addActionListener(new FileHandler());
    dirButton.addActionListener(new DirHandler());
  }
  class FileHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent ae)
    {
      JFileChooser chooser=new JFileChooser(curDir);
      chooser.setMultiSelectionEnabled(true);
      chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//Java 6 can use FileNameExtensionFilter class
//FileFilter filter=new FileNameExtensionFilter("HTML file","htm","html");
//chooser.addChoosableFileFilter(filter);
//Prior versions need external extension of FileFilter class (eg ExtFilter)
//ExtFilter requires separate compile to enable choosable selection
      String[] html=new String[] {"htm","html","xhtml"};
      chooser.addChoosableFileFilter(new ExtFilter(html,
              "HTML file (*.htm, *.html)"));
      int option=chooser.showOpenDialog(FilePicker.this);
      if (option == JFileChooser.APPROVE_OPTION)
      {
        String filelist="nothing";
        File[] sf=chooser.getSelectedFiles();
        try
        {
          if (sf.length > 0) filelist=sf[0].getCanonicalPath();
          for (int i=1; i < sf.length; i++)
          {filelist += ", " + sf[i].getCanonicalPath() + "\n";}
        }
        catch (IOException evt) {System.out.println("Exception: "+evt);}
        statusbar.setText("Your file choices: \n" + filelist);
      }
      else {statusbar.setText("You cancelled!");}
    }
  }
  class DirHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent ae)
    {
      JFileChooser chooser=new JFileChooser(curDir);
      chooser.setMultiSelectionEnabled(false);
      chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      int option=chooser.showOpenDialog(FilePicker.this);
      if (option == JFileChooser.APPROVE_OPTION)
      {
        String filelist="nothing";
        File sf=chooser.getSelectedFile();
        try
        {
          if (sf!=null) {filelist=sf.getCanonicalPath();}
        }
        catch (IOException evt) {System.out.println("Exception: "+evt);}
        statusbar.setText("Your dir choices: " + filelist);
      }
      else {statusbar.setText("You cancelled!");}
    }
  }
  public static void main(String args[]) {new FilePicker();}
}