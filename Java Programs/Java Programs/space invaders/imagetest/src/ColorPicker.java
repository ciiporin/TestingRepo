

	import java.awt.*; import java.awt.event.*; import javax.swing.*;
	public class ColorPicker extends JFrame
	{
	  final Container contentPane;
	  public ColorPicker()
	  {
	    super("ColorPicker"); setBounds(200,200,200,100);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    JButton go=new JButton("Show JColorChooser");
	    contentPane=getContentPane();
	    contentPane.add(go,BorderLayout.SOUTH);
	    setVisible(true);
	    go.addActionListener(new ColorHandler());
	  }
	  class ColorHandler implements ActionListener
	  {
	    public void actionPerformed(ActionEvent e)
	    {
	      Color c;
	      c=JColorChooser.showDialog(((Component)e.getSource()).getParent(),
	        "Demo",Color.blue);
	      contentPane.setBackground(c);
	    }
	  }
	  public static void main(String args[])
	  {ColorPicker cp=new ColorPicker();}
	}

