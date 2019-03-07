/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_pervasive;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;


/**
 *
 * @author Peter
 */
public class Login {
     Connection con;
     Statement st;
     ResultSet rs;
     
     JFrame f = new JFrame("User Login");
     JLabel l = new JLabel("Username");
     JLabel l1 = new JLabel("Username");
     JTextField t = new JTextField(10);
     JTextField t1 = new JTextField(10);
     JButton b = new JButton("Login");
     

     public Login (){
     connect();
     frame();
 }
 
 
 public void connect()
 {
     try
     {
         String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
         Class.forName(driver);
         
         String db = "jdbc:odbc:db1";
         con = DriverManager.getConnection(db);
         st = con.createStatement();
     }
     catch(Exception ex)
     {
         
     }
     
 }
 public void frame(){
 f.setSize(600,400);
 
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 f.setVisible(true);
 
 
 JPanel p = new JPanel();
 p.add(l);
 p.add(t);
 p.add(l1);
 p.add(t1);
 p.add(b);
 f.add(p);
 
 b.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          try
          {
      String user = t.getText().trim();
      String pass = t1.getText().trim();
      String sql = "select user,pass from Table1 where user = '"+user+"'and pass='"+pass+"'";
      rs = st.executeQuery(sql);
      
      int count = 0;
      
      while(rs.next())
      {
          count = count+1;
      }
      
      if (count == 1)
         
      {
          JOptionPane.showMessageDialog(null, "User Found, Access Granted");
      }
      else if (count >0)
      {
          JOptionPane.showMessageDialog(null, "Dublicate user found, Access Denied");
      }
      else 
      {
          JOptionPane.showMessageDialog(null, "User not Found!");
      }
      
      
      
      
      
      
          }
          catch(Exception ex)
          {
              
          }
            }
 });

}
 
 public static void main(String[]args){
    new Login();
}
}
 
 
