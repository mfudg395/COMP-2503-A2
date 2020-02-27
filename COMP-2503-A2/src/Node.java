/**
 * COMP-2503 Winter 2020 Assignment 2 Node class
 * 
 * This class is for Nodes to be used in a singly-linked list.
 * 
 * @author mfudg395
 *
 * @param <T> data to be used in a Node
 */
public class Node<T extends Comparable<T>> {
   
    private T data;
    private Node<T> next;
    
    /**
     * Constructor for objects of class Node
     */
    public Node(T d) {
       data = d;
       next = null;
    }

    public T getData() { 
    	return data; 
    }
    
    public void setData(T o) { 
    	data = o; 
    }
    
    public Node<T> getNext() { 
    	return next; 
    }
    
    public void setNext(Node<T> n) { 
    	next = n; 
    }
    
    public String toString() {
        return getData().toString();
    }    
}