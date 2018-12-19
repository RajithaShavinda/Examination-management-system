/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Rajitha Shavinda
 */
public class ConnectionDB {
    
    
    public static Connection Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/exams","root","");
            //create connection >> DB name:exams|| username:"root" || password:""
            
            return con;
        }
        catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, sqle.getMessage());
             return null;
        }
        catch(ClassNotFoundException cle){
            JOptionPane.showMessageDialog(null, cle.getMessage());
            return null;
        }
    }
    
}
