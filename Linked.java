package list;


class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
    }
}


public class Linked {
    public Node head;
    
    public Linked() {
        this.head = null;
    }
    
    public void insertAtPos(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        int count = 1;
        Node prev = null;
        while (current != null && count < pos) {
            prev = current;
            current = current.next;
            count++;
        }
        newNode.next = current;
        if (prev != null) {
            prev.next = newNode;
        }
    }
    
    public void deleteAtPosition(int pos) {
        if (head == null) {
            return;
        }
        if (pos == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        int count = 1;
        Node prev = null;
        while (current != null && count < pos) {
            prev = current;
            current = current.next;
            count++;
        }
        if (current != null && prev != null) {
            prev.next = current.next;
        }
    }
    
    public void deleteAfterNode(Node previous) {
        if (previous != null && previous.next != null) {
            previous.next = previous.next.next;
        }
    }
    
    public int searchNode(int value) {
        Node current = head;
        int pos = 1;
        while (current != null) {
            if (current.data == value) {
                return pos;
            }
            current = current.next;
            pos++;
        }
        return -1;
    }
    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }
    public static void main(String[] args) {
     
        System.out.println("Linked List Operations:");
        Linked list = new Linked();
        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        list.insertAtPos(40, 4);
        System.out.println("After inserting 10, 20, 30, 40:");
        list.display();
        
        list.insertAtPos(25, 3);
        System.out.println("After inserting 25 at position 3:");
        list.display();
        
        list.deleteAtPosition(2);
        System.out.println("After deleting node at position 2:");
        list.display();
        
        System.out.println("Position of 40: " + list.searchNode(40));
        System.out.println("Position of 15 (not in list): " + list.searchNode(15));
        
        System.out.println("\nStack Operations:");
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("After pushing 10, 20, 30, 40:");
        stack.display();
        
        System.out.println("Top element (peek): " + stack.peek());
        
        System.out.println("Popped element: " + stack.pop());
        System.out.println("After popping an element:");
        stack.display();
        
        System.out.println("Is stack empty? " + stack.isEmpty());
        
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("After popping all elements:");
        System.out.println("Is stack empty? " + stack.isEmpty());
    }


}


class Stack {
    public Node head;
    
    public Stack() {
        this.head = null;
    }
    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public int pop() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int popData = head.data;
        head = head.next;
        return popData;
    }
    
    public int peek() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return head.data;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }
}



    