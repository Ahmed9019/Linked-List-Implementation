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
    public void addToIndex(int index, Object element);
    /**
     * @return the element at the specified position in this list.
     * @param element
     */
    public void add(Object element);
    /**
     * @param index
     * Inserts the specified element at the end of the list.
     */
    public Object get(int index);
    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index
     * @param element
     */
    public void set(int index, Object element);
    /**
     * Removes all of the elements from this list.
     */
    public void clear();
    /**
     * @return true if this list contains no elements.
     */
    public boolean isEmpty();
    /**
     * Removes the element at the specified position in this list.
     * @param index
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
    public boolean contains(Object o);
}
public class DoubleLinkedList implements ILinkedList {
    public class Node {
        private Object element;
        private Node next, prev;
        public Node(Object element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
        /* Getter */
        public Object getElement() {
            return element;
        }
        public Node getNext() {
            return next;
        }
        public Node getPrev() {
            return prev;
        }
        /* Setter */
        public void setElement(Object element) {
            this.element = element;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
    private int size;
    private Node head, tail;
    public DoubleLinkedList() {
        size = 0;
        head = new Node(null, null, null);
        tail = new Node(null, null, head);
        head.setNext(tail);
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public void add(Object element) {
        Node temp;
        Node A = new Node(element, null, null);
        A.setElement(element);
        temp = tail.getPrev();
        tail.setPrev(A);
        A.setNext(tail);
        temp.setNext(A);
        A.setPrev(temp);
        size += 1;
    }
    public void addToIndex(int index, Object element) {
        if (index > size || index < 0) {
            return;
        } else if (size == 0) {
            add(element);
        } else {
            Node c = head.getNext();
            for (int i = 0; i < index; i++) {
                c = c.getNext();
            }
            Node e = new Node(element, null, null);
            Node te;
            te = c.getPrev();
            c.setPrev(e);
            e.setNext(c);
            te.setNext(e);
            e.setPrev(te);
            size += 1;
        }
    }
    public Object get(int index) {
        Object val;
        if (index > (size - 1) || index < 0) {
            return "Error";
        } else {
            Node cu = head.getNext();
            for (int i = 0; i < index; i++) {
                cu = cu.getNext();
            }
            val = cu.getElement();
            return val;
        }
    }
    public void set(int index, Object element) {
        if (index > (size - 1) || index < 0) {
            return;
        } else {
            Node cur = head.getNext();
            for (int i = 0; i < index; i++) {
                cur = cur.getNext();
            }
            cur.setElement(element);
        }
    }
    public void clear() {
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }
    public void remove(int index) {
        if (index > (size - 1) || index < 0) {
            return;
        } else {
            Node curr = head.getNext();
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
            Node before = curr.getPrev();
            Node after = curr.getNext();
            before.setNext(after);
            after.setPrev(before);
            size -= 1;
        }
    }
    public ILinkedList sublist(int fromIndex, int toIndex) {
        int i;
        if (fromIndex > toIndex) {
            System.out.println("Error");
            return null;
        } else if (fromIndex > (size - 1) || fromIndex < 0 || toIndex > (size - 1) || toIndex < 0) {
            System.out.println("Error");
            return null;
        } else {
            Node curr = head.getNext();
            for (i = 0; i < fromIndex; i++) {
                curr = curr.getNext();
            }
            ILinkedList sub = new DoubleLinkedList();
            for (int j = i; j <= toIndex; j++) {
                if (curr != tail) {
                    sub.add(curr.getElement());
                    curr = curr.getNext();
                } else {
                    System.out.println("Error");
                    return null;
                }
            }
            return sub;
        }
    }
    public boolean contains(Object o) {
        Node n = head.getNext();
        while (n != tail) {
            if (n.getElement() == o) {
                return true;
            } else {
                n = n.getNext();
            }
        }
        return false;
    }
    public void display() {
        Node n = head;
        System.out.print("[");
        if (n.getNext() != tail) {
            n = n.getNext();
            System.out.print(n.getElement());
        }
        while (n.getNext() != tail) {
            n = n.getNext();
            System.out.print(", ");
            System.out.print(n.getElement());
        }
        System.out.print("]");
    }
    /* Implement your linked list class here*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] arrIn = in.split(", ");
        DoubleLinkedList list = new DoubleLinkedList();
        for (int i = 0; i < arrIn.length && !(arrIn[0].equals("")); i++) {
            list.add(Integer.parseInt(arrIn[i]));
        }
        String command = sc.nextLine();
        if (command.equals("add")) {
            int element = sc.nextInt();
            list.add(element);
            list.display();
        } else if (command.equals("addToIndex")) {
            int index, element;
            index = sc.nextInt();
            element = sc.nextInt();
            int size1 = list.size();
            list.addToIndex(index, element);
            int size2 = list.size();
            if (size1 == size2) System.out.println("Error");
            else list.display();
        } else if (command.equals("get")) {
            int index = sc.nextInt();
            System.out.println(list.get(index));
        } else if (command.equals("set")) {
            int index, element;
            index = sc.nextInt();
            element = sc.nextInt();
            if (index > (list.size - 1) || index < 0) {
                System.out.println("Error");
            } else {
                list.set(index, element);
                list.display();
            }
        } else if (command.equals("isEmpty")) {
            if (list.isEmpty()) System.out.println("True");
            else System.out.println("False");
        } else if (command.equals("clear")) {
            list.clear();
            list.display();
        } else if (command.equals("remove")) {
            int index = sc.nextInt();
            int size1 = list.size();
            list.remove(index);
            int size2 = list.size();
            if (size1 == size2) System.out.println("Error");
            else list.display();
        } else if (command.equals("contains")) {
            int element = sc.nextInt();
            if (list.contains(element)) System.out.println("True");
            else System.out.println("False");
        } else if (command.equals("sublist")) {
            int fromIndex, toIndex;
            fromIndex = sc.nextInt();
            toIndex = sc.nextInt();
            DoubleLinkedList sublist = new DoubleLinkedList();
            sublist = (DoubleLinkedList) list.sublist(fromIndex, toIndex);
            if (sublist == null);
            else sublist.display();
        } else if (command.equals("size")) {
            System.out.println(list.size());
        }
    }
}