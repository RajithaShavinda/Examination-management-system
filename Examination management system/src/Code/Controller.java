/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Rajitha Shavinda
 */
public class Controller {
    
    private static Controller con; //current class object
    
    private Controller(){
        
    }  
    
    
    public static Controller getController(){
        if(con==null){
            con=new Controller();
        }
        return con;
    }
}


