/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Aliff Aiman
 */
public class Room { //roomlist for hashtable

    Object roomID;
    Object name;
    
    public Room (Object roomID, Object name){
        this.roomID = roomID;
        this.name = name;
    }
    
    public Object getRoomID(){
        return this.roomID;
    }
    
    public Object getName(){
        return this.name;
    }

}
