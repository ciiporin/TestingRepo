/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pervasive_gui.java
 *
 * Created on Dec 13, 2012, 4:27:08 PM
 */
package gui_pervasive;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class pervasive_gui extends javax.swing.JFrame {

    private Image image = null;
    String image_store = new String("");
    public String name_store = "";
    int security_store = 0;
    // public String username;
    //  public String password;
    Connection con;
    Statement st;
    ResultSet rs;
    JFrame f = new JFrame("User Login");
    JLabel l = new JLabel("Username");
    JLabel l1 = new JLabel("Username");
    JTextField t = new JTextField(10);
    JTextField t1 = new JTextField(10);
    JButton b = new JButton("Login");

    //sets the image of the user
    public void image_input() {
        System.out.println("Testin");
        System.out.println(image_store);
        image = getToolkit().getImage(
                "//C:/Users/Peter/Dropbox/Java Programs/GUI_Pervasive/images/" + image_store);
        //	   "//c1staffhome1/STAFFHOME1/Matthewp/Desktop/Other/Java Programs/PhDInput/src/per_system/" + image_store);
        //"C:/Users/Peter/Dropbox/Java Programs/PhDInput/src/per_system/" 
        //c1staffhome1\STAFFHOME1\Matthewp\Desktop\Other\Java Programs\PhDInput\bin\per_system

        display.setIcon(new ImageIcon(image));
        welcome.setText("Welcome: " + name_store);
               option1.setEnabled(false);
            option2.setEnabled(false);
            option3.setEnabled(false);
            option4.setEnabled(false);
            option5.setEnabled(false);
            option6.setEnabled(false);
    }
//clears the username and password fields and sets focus to the username field

    public void cleanup() {
        name.setText("");
        password.setText("");
        name.requestFocusInWindow();
        
            

        if (security_store == 4) {

            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);
            option5.setEnabled(true);
            option6.setEnabled(true);

        } else if (security_store == 3) {
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);

        } else if (security_store == 2) {
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
        } else if (security_store == 1) {
            option1.setEnabled(true);
        } else {
            option1.setEnabled(false);
            option2.setEnabled(false);
            option3.setEnabled(false);
            option4.setEnabled(false);
            option5.setEnabled(false);
            option6.setEnabled(false);


        }

    }

    public void logout() {
        security_store = 0;
        image_store = "";
        name_store ="";
        image_input();
    }

    /**
     * Creates new form pervasive_gui
     */
    public pervasive_gui() {
        initComponents();
        //image_store = "NoPhoto.jpg";

        image_input();
        connect();
        frame();
    }

    public void connect() {
        try {
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
            Class.forName(driver);

            String db = "jdbc:odbc:db1";
            con = DriverManager.getConnection(db);
            st = con.createStatement();
        } catch (Exception ex) {
        }

    }

    public void frame() {


        JPanel p = new JPanel();


        submit_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String user = name.getText().trim();
                    String pass = password.getText().trim();


                    String sql = "select user,pass,profile,security from Table1 where user = '" + user + "'and pass='" + pass + "'";
                    rs = st.executeQuery(sql);



                    // rs = st.executeQuery(getimage_store);



                    int count = 0;

                    while (rs.next()) {
                        count = count + 1;
                        name_store = rs.getString("user");
                        image_store = rs.getString("profile");
                        security_store = rs.getInt("security");
                        System.out.println("Image:" + image_store + security_store);
                        image_input();
                        cleanup();


                    }

                    if (count == 1) {
                        JOptionPane.showMessageDialog(null, "User Found, Access Granted");


                        //String getimage_store = rs.getString(1);
                        //System.out.println(getimage_store);
                    } else if (count > 0) {
                        JOptionPane.showMessageDialog(null, "Dublicate user found, Access Denied");
                    } else {
                        JOptionPane.showMessageDialog(null, "User not Found!");
                    }




                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        display = new javax.swing.JLabel();
        submit_btn = new javax.swing.JButton();
        voice_label = new javax.swing.JLabel();
        temp_label = new javax.swing.JLabel();
        greet_label = new javax.swing.JLabel();
        voice = new javax.swing.JLabel();
        temp = new javax.swing.JLabel();
        greet = new javax.swing.JLabel();
        loggin = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        option1 = new javax.swing.JButton();
        option2 = new javax.swing.JButton();
        option3 = new javax.swing.JButton();
        option4 = new javax.swing.JButton();
        option5 = new javax.swing.JButton();
        option6 = new javax.swing.JButton();
        welcome = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        name.setName("username"); // NOI18N

        jLabel2.setText("Password");

        display.setName("display"); // NOI18N

        submit_btn.setText("Submit");
        submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_btnActionPerformed(evt);
            }
        });

        voice_label.setText("Voice");

        temp_label.setText("Temprature");

        greet_label.setText("Greeting");

        option1.setText("option1");
        option1.setFocusCycleRoot(true);
        option1.setName("option1"); // NOI18N

        option2.setText("option2");
        option2.setName("option2"); // NOI18N

        option3.setText("option3");
        option3.setName("option3"); // NOI18N

        option4.setText("option4");
        option4.setName("option4"); // NOI18N

        option5.setText("option5");
        option5.setName("option5"); // NOI18N

        option6.setText("option6");
        option6.setName("option6"); // NOI18N

        welcome.setText("jLabel3");

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(submit_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addComponent(password)))
                                .addComponent(welcome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loggin, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(166, 166, 166)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(temp_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(voice_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(greet_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(greet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(voice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(temp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(option1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(option2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(option3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(option4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(option5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(option6)))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voice_label)
                            .addComponent(voice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(temp_label)
                            .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(greet_label)
                            .addComponent(greet, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(option1)
                            .addComponent(option2)
                            .addComponent(option3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(option4)
                            .addComponent(option5)
                            .addComponent(option6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submit_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loggin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logout))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_btnActionPerformed
//
//        if (src == submit_btn) {
//            name_store = name.getText();
//
//            Map<String, Object> logins = new HashMap<String, Object>();
//            logins.put("Peter", gui_hashtable.pass);
//            logins.put("Alan", gui_hashtable.pass);
//            logins.put("Bill", gui_hashtable.pass);
//
//            username = name_store;
//         
//
//            if (logins.containsKey(username) && logins.get(username).equals(gui_hashtable.pass)) {
//                loggin.setText("Welcome " + gui_hashtable.name);
//                image_store = gui_hashtable.image;
//                image_input();
//                                                  
//                
//                System.out.println(image_store);
//     
//            } else {
//                loggin.setText("Unauthorised user");
//            }
//        }
}//GEN-LAST:event_submit_btnActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
logout();
// TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        gui_hashtable aScore[] = new gui_hashtable[3];
        // The player #1
        aScore[0] = new gui_hashtable("Peter", "85", "Koala.jpg", "Holly", "Red");
        aScore[1] = new gui_hashtable("Bill", "85", "Jellyfish.jpg", "Holly", "Red");

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pervasive_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pervasive_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pervasive_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pervasive_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pervasive_gui().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JLabel display;
    private javax.swing.JLabel greet;
    private javax.swing.JLabel greet_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel loggin;
    private javax.swing.JTextField name;
    private javax.swing.JButton option1;
    private javax.swing.JButton option2;
    private javax.swing.JButton option3;
    private javax.swing.JButton option4;
    private javax.swing.JButton option5;
    private javax.swing.JButton option6;
    private javax.swing.JTextField password;
    private javax.swing.JButton submit_btn;
    private javax.swing.JLabel temp;
    private javax.swing.JLabel temp_label;
    private javax.swing.JLabel voice;
    private javax.swing.JLabel voice_label;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
