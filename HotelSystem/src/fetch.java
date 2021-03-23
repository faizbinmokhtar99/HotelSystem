
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faiz
 */
public class fetch { //fetch from database
    Connection con= null;
    ResultSet rs= null;
    PreparedStatement ps=null;
    
    public ResultSet find(String s){
       try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","");
            ps= con.prepareStatement("select * from profile where username =?");
            ps.setString(1, s);
            rs=ps.executeQuery();
       }catch(Exception ex){
           
       }
      return rs;
    }
    
    
    
    
    
    
    
    
}




