  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.ia;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Yash
 */
public class sql_connection {
    Connection con;
 
    /**
     *
     * @return
     * @throws java.sql.SQLException
     */
    public static Connection conneect_DB() throws SQLException 
    {
             
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ia", "root", "");
            return con;
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(sql_connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
}
    public static ImageIcon scaleimg(int w, int h){
    ImageIcon icon=new ImageIcon("C:\\Users\\Yash\\Documents\\NetBeansProjects\\Main IA\\images\\login1.jpg");
    Image img;
        img = icon.getImage();
    Image iscl=img.getScaledInstance(w,h,Image.SCALE_SMOOTH);
    ImageIcon scl=new ImageIcon(iscl);
    
    return scl;
    }
    public static Connection conneect_DB1() throws SQLException 
    {
             
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ia", "root", "");
           //JOptionPane.showMessageDialog(null, "database connection done");
                        return con;
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(sql_connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
}
}
