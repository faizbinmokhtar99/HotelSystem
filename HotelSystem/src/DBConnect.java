/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author Faiz
 */
public class DBConnect { //class to connect to database
    private static  Connection con;
    private  static Statement st;
    private ResultSet rs;
   String arr[];
   public String name;

    public   DBConnect(){
        
    try{
       
           Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","");
            st=con.createStatement();
        }catch(Exception e){
            //System.out.println("Error ");
        }
    
    
    
}
   public static Connection DBConnect(){
        con=null;
    try{
       
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","");
            st=con.createStatement();
        }catch(Exception e){
            System.out.println("Error ");
        }
    return con;
    
    
}
   
    
    //CALLING DATA FROM DATABASE
   
            
            
            
            
            
  
   
   
   
   
   
   
   
   
   public void getData(){
        try{
            String query ="select * from profile";
            rs=st.executeQuery(query);
            System.out.println("Records from database");
           
            while(rs.next()){
                
              
                    
                String name=rs.getString("name");
                
               
                
               
                System.out.println("Name:"+name);

                
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        /*try{
             String query1 ="select *from queenroom";
             rs=st.executeQuery(query1);
             System.out.println("Records from database");
             while(rs.next()){
                 /////////////////////////////////////////////
                int i=0;
              
                    
                String tempname=rs.getString("username");
                System.out.println(tempname);
                arr[i]=tempname;
                i++;
                
                System.out.println(arr[i]);
              ////////////////////////////////////
                    
                String room=rs.getString("roomID");
                
                int full=rs.getInt("occupation");
                if(full==1){
                System.out.println("roomID :"+room +  " room is empty " );        
                }
                else 
                    System.out.println("roomID :"+room +  "room is full");
                
            }
        }catch(Exception ex){
             System.out.println(ex);
        }
        */
       
    }
    
    
    
     public void updateDataUser(){
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","");
            
        }catch(Exception e){
            System.out.println("Error");
        }
            
        }
     
     
     
     
     
     
}



        
       
