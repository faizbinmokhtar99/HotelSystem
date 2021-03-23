
public final class HashTableArray<T> { 

    int count = 0;
    Entry[] arrayHash;
    int size;
    public String passID;

    public HashTableArray(int size) {
        this.size = size;
        arrayHash = new Entry[size];
        for (int i = 0; i < size; i++) {
            arrayHash[i] = new Entry();
        }
    }

    public int getHash(int key) {
        return key % size;
    }

    public void generateID(int key, Object value) { //method to generate booking id

        int ct = 1;
        int HashIndex = getHash(key);

        String id = "";
        switch (key) {
            case 1:
                id = "ST";
                break;
            case 2:
                id = "KG";
                break;
            case 3:
                id = "QN";
                break;
            case 4:
                id = "SR";
                break;
        }

        Entry n = arrayHash[HashIndex];

        while (n.next != null) {

            String temp = (String) n.next.getValue();

            String holdReceivedValue = (String) value;
            String UpValue = holdReceivedValue.toUpperCase();
            boolean flag = searchKey(temp, UpValue);
            if (flag) {
                ct++;
            }

            n = n.next;

        }
        String nameph = (String) value;
        String Upvalue = nameph.toUpperCase();
        String bookingID = id + Upvalue + ct;
        Entry node = new Entry(key, bookingID);
        n.next = node;
        passID = bookingID;
        System.out.println("Successfully booking! Your Booking ID is " + bookingID);

    }

    public boolean searchKey(Object temp, Object value) {
        String str = (String) temp;
        int intIndex = str.indexOf((String) value);
        if (intIndex == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void show(int key) {
        int HashIndex = getHash(key);
        Entry head = arrayHash[HashIndex];
        Entry n = head;
        while (n.next != null) {
            System.out.println(n.next.getValue());
            n = n.next;
        }

    }

    public void deleteBooking(int key, Object value) { //delete booking
        int temp = findValue(key, value);

        int HashIndex = getHash(key);
        Entry head = arrayHash[HashIndex];

        if (temp == 0) {
            System.out.println("no value to delete");
        } else if (temp > 0) {
            Entry n = head;
            Entry n1 = null;

            for (int i = 0; i < temp - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;

            n1 = null;
            System.out.println("Booking cancelled.");
        } else {
            System.out.println("Room is not booked.");
        }

    }

    public int findValue(int key, Object value) { //find value in linked list
        int ct = 0;
        int HashIndex = getHash(key);
        Entry head = arrayHash[HashIndex];
        Entry n = head;
        int sizeLinked = LinkedListLength(key);
        for (int i = 0; i < sizeLinked - 1; i++) {
            String temp = (String) n.next.getValue();
            boolean flag = searchKey(temp, value);
            if (flag) {
                return i + 1;
            }

            n = n.next;

        }
        return -1;
    }

    public int LinkedListLength(int key) { //length of linked list
        int ct = 0;
        int HashIndex = getHash(key);
        Entry head = arrayHash[HashIndex];
        Entry n = head;
        if (n.next == null) {
            return 0;
        } else {
            while (n.next != null) {
                ct++;
                n = n.next;
            }
            ct++;
            return ct;
        }
    }

}
