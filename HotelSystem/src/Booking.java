
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Booking {

    Showspecific law = new Showspecific();
    String[] all = new String[50];
    String specific;
    public static final int totalRooms = 40;	//number of rooms
    static Room[] roomdata = new Room[totalRooms];              //create array
    private static boolean menu = true;
    
    public void deleteall(){ 	//method to delete all booking
        int i =0;
        while(i<roomdata.length){
            roomdata[i]=null;
            i++;
        }
    }

    public void bookRoom(Object roomID, Object name) {	//method to book a room
        int temp = (Integer) roomID;
        if (roomdata[(int) roomID - 1] == null) {
            int roomCode = roomID.hashCode() - 1;
            int counter = 0;
            int slot = hash(roomCode, counter);

            while (!isEmpty(slot)) {                                                                 
                slot = hash(roomCode, ++counter);
                break;
            }

            roomdata[slot] = new Room(roomID, name);
//            System.out.println("Booking Successful!\n");	//successful booking

        } else {
            System.out.println("Room is booked! Please choose another room!\n"); //room is occupied
        }
    }

    public boolean vacantRoom(Object roomID) {                                   //Method when to see vacant room
        int roomCode = roomID.hashCode() - 1;
        int step = 0;
        int slot = hash(roomCode, step);

        while (roomdata[slot] != null && !roomdata[slot].getRoomID().equals(roomID)) {
            slot = hash(roomCode, ++step);
        }
        if (roomdata[slot] != null) {
            showName(roomID);
            System.out.println("Room is booked by " + roomdata[slot].getName() + "! Please choose another room!\n");
            return true;
        } else {
            System.out.println("Room is vacant.\n");
            return false;
        }
    }

    public Object showName(Object roomID) {	//check room vacancy
        int roomCode = roomID.hashCode();
        int step = 0;
        int slot = hash(roomCode, step);

        while (roomdata[slot] != null && !roomdata[slot].getRoomID().equals(roomID)) {
            slot = hash(roomCode, ++step);
        }

        if (roomdata[slot] != null) {
            return roomdata[slot].getName();
        } else {
            return null;
        }
    }

    public int hash(int key, int step) { //hash method
        if (step == 0) {
            return key % totalRooms;
        } else {
            return (key % totalRooms + step * step) % totalRooms;
        }
    }

    public void emptyRooms() { 	//list out empty rooms
        for (int i = 0; i < totalRooms; i++) {
            if (roomdata[i] == null) {
                System.out.println("Room " + (i + 1) + " is empty");
            }
        }
        System.out.println("");
    }

    public boolean isEmpty(int slot) {
        return roomdata[slot] == null;
    }

    public void nullArray(Object roomID) {	//delete an array
        for (int i = 0; i < totalRooms; i++) {
            if (roomdata[i] != null) {
                roomdata[i] = null;
            }
        }
    }

    public static void main(String[] args) {            // this main fuction  do 4 method which is book, check vacancy, show all vacancy and delete booking.

        HashTableArray<String> hm = new HashTableArray<String>(4);
        Booking book = new Booking();
        Scanner s = new Scanner(System.in);

        while (menu) {

            String selection = "A";
            //  String input

            switch (selection) {

                case "A":
                    System.out.println("Enter type of Room(1:Suite 2:King 3:Queen 4:Single)");
                    int roomType = s.nextInt();
                    System.out.println("Enter a room number(1-40): ");
                    Object roomID = s.nextInt();
                    if ((int) roomID == 0 || (int) roomID > 50) {
                        System.out.println("Error\n");
                        break;
                    }
                    if (!book.isEmpty((int) roomID - 1)) {
                        System.out.println("Room is booked! Please choose another room!\n");
                        break;
                    }
                    //name 
                    System.out.println("Enter your name for room " + roomID + " :");
                    Object name = s.next();
                    String nameph = (String) name;
                    nameph = nameph.toUpperCase();
                    name = (Object) nameph;

                    book.bookRoom(roomID, name);
                    hm.generateID(roomType, name);
                    break;

                case "B":
                    System.out.println("Enter a room number(1-50): ");
                    roomID = s.nextInt();
                    book.vacantRoom(roomID);
                    break;

                case "C":
                    book.emptyRooms();
                    break;

                case "D":
                    //delete booking
                    System.out.println("Enter your booking ID: ");
                    Object bookingID = s.next();
                    System.out.println("Enter your room number: ");
                    roomID = s.nextInt();
                    System.out.println("Enter type of Room(1:Suite 2:King 3:Queen 4:Single)");
                    roomType = s.nextInt();
                    hm.deleteBooking(roomType, bookingID);
                    book.nullArray(roomID);
                    break;

                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }

    }



    public void searchroom(String room) {

        String temp;
        int i = Integer.valueOf(room)-1;

        if (roomdata[i] == null) {

            if (i >= 0 && i <= 10) {

                System.out.println("Room" + (i+1) + " is empty");
                temp = "Room" + (i+1) + " is empty";
                all[i] = temp;
            } else if (i > 10 && i <= 20) {
                System.out.println("Room" + (i+1) + " is empty");
                temp = "Room" + (i+1) + " is empty";
                all[i] = temp;
            } else if (i > 20 && i <= 30) {
                System.out.println("Room" + (i+1) + " is empty");
                temp = "Room" + (i+1) + " is empty";
                all[i] = temp;
            } else if (i > 30 && i <= 40) {
                System.out.println("Room" + (i+1) + " is empty");
                temp = "Room" + (i+1) + " is empty";
                all[i] = temp;
            } 
            specific = all[i];

        }else {
                temp = "Room" + (i+1) + " is occupied";
                all[i] = temp;
                specific = all[i];
            }

    }
}
