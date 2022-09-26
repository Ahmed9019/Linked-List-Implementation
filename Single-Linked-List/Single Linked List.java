import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
	/**
	* Inserts a specified element at the specified position in the list.
	* @param index
	* @param element
	*/
    public void addToIndex(int index, int element);
    /**
    * Inserts the specified element at the end of the list.
    * @param element
    */

    public void add(int element);
    /**
     * get the element at the specified position in this list    
     * @param index
     */
    public void get(int index);
    /**
    * Replaces the element at the specified position in this list with the
    * specified element.
    * @param index
    * @param element
    * @return 1 if there is  an Error
    */
    public int set(int index, int element);
    /**
    * Removes all of the elements from this list.
    */
    public void clear();
    /**
    * Removes the element at the specified position in this list.
    * @param index
    */
    public boolean isEmpty();
    /**
    * @return the number of elements in this list.
    */
    public void remove(int index);
    /**
    * @return the number of elements in this list.
    */
    public int size();
    /**
    * @param fromIndex
    * @param toIndex
    * @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
    */
    public ILinkedList sublist(int fromIndex, int toIndex);
    /**
    * @param o
    * @return true if this list contains an element with the same value as the specified element.
    */
    public boolean contains(int o);
    
    public void display();
}



public class singleLinkedList implements ILinkedList {
    
    ////////////    DRIVER CODE    ////////////
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] arrIn = in.split(", ");
        singleLinkedList list = new singleLinkedList();
        for (int i=0; i<arrIn.length && !(arrIn[0].equals("")); i++) {
            list.add(Integer.parseInt(arrIn[i]));
        }
        
        String command = sc.nextLine();
        
        if (command.equals("add")) {
            int element = sc.nextInt();
            list.add(element);
            list.display();
        }
        else if (command.equals("addToIndex")) {
            int index, element;
            index = sc.nextInt();
            element = sc.nextInt();
            int size1 = list.size();
            list.addToIndex(index, element);
            int size2 = list.size();
            if (size1 == size2) System.out.println("Error");
            else list.display();
        }
        else if (command.equals("get")) {
            int index = sc.nextInt();
            list.get(index);
        }
        else if (command.equals("set")) {
            int index, element;
            index = sc.nextInt();
            element = sc.nextInt();
            if (list.set(index, element) == 1) System.out.print("Error");
            else list.display();
        }
        else if (command.equals("isEmpty")) {
            if (list.isEmpty()) System.out.println("True");
            else System.out.println("False"); 
        }
        else if (command.equals("clear")) {
            list.clear();
            list.display();
        }
        else if (command.equals("remove")) {
            int index = sc.nextInt();
            int size1 = list.size();
            list.remove(index);
            int size2 = list.size();
            if (size1 == size2) System.out.println("Error");
            else list.display();
        }
        else if (command.equals("contains")) {
            int element = sc.nextInt();
            if (list.contains(element)) System.out.println("True");
            else System.out.println("False");
        }
        else if (command.equals("sublist")) {
            int fromIndex, toIndex;
            fromIndex = sc.nextInt();
            toIndex = sc.nextInt();
            singleLinkedList sublist = new singleLinkedList();
            sublist = (singleLinkedList) list.sublist(fromIndex, toIndex);
            if (sublist == null);
            else sublist.display();
        }
        else if (command.equals("size")) {
            System.out.println(list.size());
        }
    }
    
    //    instance variables and constructor    //
    private int size=0;
    private Node tail = new Node(0, null); 
    private Node head = new Node(0, tail);

    public singleLinkedList() {
        tail = new Node(0, null);
        head = new Node(0, tail);
        size = 0;
    }
    //    class Node (building block of the linked list)    //
    class Node{
        private int data;
        private Node next;
        //    constructor    //
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        //    getters    //
        public int getData() {
            return data;
        }
        public Node getNext() {
            return next;
        }
        //    setters    //
        public void setData(int data) {
            this.data = data;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    
    
    //    Adds an element to the start of the list //
    public void add(int element) {
        Node newElement = new Node(element, null);
        Node n= head;
        while (n.getNext() != tail) {
            n = n.getNext();
        }
        newElement.setNext(tail);
        n.setNext(newElement);
        size++;
    }
    
    //    Adds an element to a specific index in the list    // 
    public void addToIndex(int index, int element) {
        Node newElement = new Node(element, null);
        int target = 0;
        Node nTarget= head;
        while ((target != index) && (nTarget != tail)) {
            nTarget = nTarget.getNext();
            target++;
        }
        if (nTarget == tail) {
            return;
        }
        else if (target == index) {
            newElement.setNext(nTarget.getNext());
            nTarget.setNext(newElement);
            size++;
        }
    }
    
    //    returns the value of the element stored in a specific index in the list    //
    public void get(int index) {
        Node n = head;
        int target = 0;
        while ((target != index) && (n.getNext() != tail)) {
            target++;
            n = n.getNext();
        }
        if (n.getNext() == tail) {
            System.out.println("Error");
        }
        else if (target == index) {
            System.out.println(n.getNext().getData());
            
        }
    }
    
    //    replaces the value of the element stored in a specific index in the list //
    //    with a new value    //
    public int set(int index, int element) {
        Node n = head;
        int target = 0;
        while ((target != index) && (n.getNext() != tail)) {
            target++;
            n = n.getNext();
        }
        if (n.getNext() == tail) {
            return 1;
        }
        else if (target == index) {
            n.getNext().setData(element);
            return 0;
        }
        return 0;
    }
    
    //    returns true if the list is empty //
    public boolean isEmpty() {
        if (head.getNext() == tail) {
            return true;
        }
        else {
            return false;
        }
    }
    
    //    removes all elements in the list //
    public void clear() {
        head.setNext(tail);
        size = 0;
    }
    
    //    removes an element in a specific index in the list    //
    public void remove(int index) {
        Node n = head;
        int target = 0;
        while ((target != index) && (n.getNext() != tail)) {
            target++;
            n = n.getNext();
        }
        if (n.getNext() == tail) {
            return;
        }
        else if (target == index) {
            Node v = n.getNext();
            n.setNext(v.getNext());
            v.setNext(tail);
            size--;
        }
    }
    
    // returns true if an element exists in the list //
    public boolean contains(int o) {
        Node n = head.getNext();
        while (n != tail) {
            if (n.getData() == o) {
                return true;
            }
            else {
                n = n.getNext();
            }
        }
        return false;
    }
    
    //    creates a new list with the elements from the original list    //
    public ILinkedList sublist(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            System.out.println("Error");
            return null;
        }
        else {
            Node n = head.getNext();
            int target = 0;
            while ((target != fromIndex) && (n.getNext() != tail)) {
                target++;
                n = n.getNext();
            }
            if (target != fromIndex) {
                System.out.println("Error");
                return null;
            }
            singleLinkedList res = new singleLinkedList();
            for (int i = target; i <=  toIndex ; i++) {
                if (n != tail) {
                    res.add(n.getData());
                    n = n.getNext();
                }
                else {
                    System.out.println("Error");
                    return null;
                }
            }
            return res;
        }
    }
    
    //returns the current size of a list //
    public int size() {
        return size;
    }
    
    //    prints a list in a proper format //
    public void display() {
        Node n = head;
        System.out.print("[");
        if (n.getNext() != tail) {
            n = n.getNext();
            System.out.print(n.getData());
        }
        while (n.getNext() != tail) {
            n = n.getNext();
            System.out.print(", ");
            System.out.print(n.getData());
        }
        System.out.print("]");
    }
    
}