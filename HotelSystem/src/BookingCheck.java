/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NAIM
 */
import java.util.Scanner;

public class BookingCheck {

    Showspecific law = new Showspecific();
    static final int totalRooms = 50;
    Room[] roomdata = new Room[totalRooms];
    private static boolean menu = true;
    String[] all = new String[50];
    String specific;

    public void bookRoom(Object roomID, Object name) { //book room
        if (roomdata[(int) roomID - 1] == null) {
            int roomCode = roomID.hashCode() - 1;
            int counter = 0;
            int slot = hash(roomCode, counter);

            while (!isEmpty(slot)) {
                slot = hash(roomCode, ++counter);
                break;
            }

            roomdata[slot] = new Room(roomID, name);
//            System.out.println("Booking Successful!\n");

        } else {
            System.out.println("Room is booked! Please choose another room!\n");
        }
    }

    public boolean roomExist(Object roomID) { //check room vacancy
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
            System.out.println("Room is vacant.\n");        //////End kan loop
            return true;

        }
    }

    public Object showName(Object roomID) { //check room vacancy
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

    public void allemptyRooms() { //show all empty rooms

        String temp;
        for (int i = 0; i < totalRooms; i++) {
            if (roomdata[i] == null) {

                if (i >= 0 && i <= 10) {

                    System.out.println(" Room Deluxe King Room" + (i + 1) + " is empty");
                    temp = " Room Deluxe King Room" + (i + 1) + " is empty";
                    all[i] = temp;
                } else if (i > 10 && i <= 20) {
                    System.out.println(" Suite Room" + (i + 1) + " is empty");
                    temp = " Suite Room" + (i + 1) + " is empty";
                    all[i] = temp;
                } else if (i > 20 && i <= 30) {
                    System.out.println(" Deluxe Queen Room" + (i + 1) + " is empty");
                    temp = " Deluxe Queen Room" + (i + 1) + " is empty";
                    all[i] = temp;
                } else if (i > 30 && i <= 40) {
                    System.out.println(" Premier Single Room" + (i + 1) + " is empty");
                    temp = " Premier Single Room" + (i + 1) + " is empty";
                    all[i] = temp;
                }

            }
        }

    }

    public void searchroom(String room) { //search room

        String temp;
        int i = Integer.valueOf(room);

        if (roomdata[i] == null) {

            if (i >= 0 && i <= 10) {

                System.out.println(" Room Deluxe King Room" + (i) + " is empty");
                temp = " Room Deluxe King Room" + (i) + " is empty";
                all[i] = temp;
            } else if (i > 10 && i <= 20) {
                System.out.println(" Suite Room" + (i) + " is empty");
                temp = " Suite Room" + (i) + " is empty";
                all[i] = temp;
            } else if (i > 20 && i <= 30) {
                System.out.println(" Deluxe Queen Room" + (i) + " is empty");
                temp = " Deluxe Queen Room" + (i) + " is empty";
                all[i] = temp;
            } else if (i > 30 && i <= 40) {
                System.out.println(" Premier Single Room" + (i) + " is empty");
                temp = " Premier Single Room" + (i) + " is empty";
                all[i] = temp;
            }

            specific = all[i];

        }

    }

    public boolean isEmpty(int slot) { 
        return roomdata[slot] == null;
    }

    public void nullArray(Object roomID) { //null an array
        for (int i = 0; i < totalRooms; i++) {
            if (roomdata[i] != null) {
                roomdata[i] = null;
            }
        }
    }

    public void viewall(String a) { 
        HashTableArray<String> hm = new HashTableArray<String>(4);

        Scanner s = new Scanner(System.in);

        while (menu) {

            String selection = a;

            switch (selection) {

                case "A":
                    System.out.println("Enter type of Room(1:Suite 2:King 3:Queen 4:Single)");
                    int roomType = s.nextInt();
                    System.out.println("Enter a room number(1-50): ");
                    Object roomID = s.nextInt();
                    if ((int) roomID == 0 || (int) roomID > 50) {
                        System.out.println("Error\n");
                        break;
                    }
                    if (!isEmpty((int) roomID - 1)) {
                        System.out.println("Room is booked! Please choose another room!\n");
                        break;
                    }
                    //name 
                    System.out.println("Enter your name for room " + roomID + " :");
                    Object name = s.next();
                    String nameph = (String) name;
                    nameph = nameph.toUpperCase();
                    name = (Object) nameph;

                    bookRoom(roomID, name);
                    hm.generateID(roomType, name);
                    break;

                case "B":

                    roomID = law.jTextField2;
                    roomExist(roomID);
                    break;

                case "C":
                    allemptyRooms();
                    menu = false;
                    break;

                default:
                    System.out.println("Invalid selection");
                    break;

            }
        }

    }
}
