import java.util.Iterator;

public class SLL<T extends Comparable<T>> implements Iterable<T> {
	
   private Node<T> head;
   private Node<T> tail;
   private int size;
   
   public SLL() {
	   head = null;
	   tail = null;
	   size = 0;
   }
 
   public void addHead(Node<T> n) {
	   n.setNext(null);
	   if (head == null) {
		   head = n;
		   tail = n;
	   } else {
		   n.setNext(head);
	       head = n;
	   }
   }
   
   public void addTail(Node<T> n) {
	   n.setNext(null);
	   
	   if (n.getData() == null) { // nothing happens if the new node has no data
		   return;
	   }
	   
       if (head == null) {
    	   head = n;
    	   tail = n;
       } else {
    	   Node<T> current = head;
    	   while (current.getNext() != null) {
    		   current = current.getNext();
    	   }
    	   current.setNext(n);
    	   tail = n;
       }
       
   }

   public void add(T t) {
	   Node<T> n = new Node<>(t);
	   if (n.getData() == null) {
		   return;
	   }
	   
	   if (head == null || n.getData().compareTo(head.getData()) <= 0) {
		   addHead(n);
	   } else {
		   Node<T> curr = head;
		   while (curr.getNext() != null && n.getData().compareTo(curr.getNext().getData()) > 0) {
			   curr = curr.getNext();
		   }
		   
		   if (curr.getNext() == null) {
			   addTail(n);
		   } else {
			   n.setNext(curr.getNext());
			   curr.setNext(n);
		   }
	   }
	   size++;
   }
   
   public void printList() {
       Node<T> curr = head;
       while (curr != null) {
           System.out.println(curr.toString());
           curr = curr.getNext();
       }
   }
   
   public void emptyList() {
       head = null;
       tail = null;
       size = 0;
   }
   
   public Node<T> getTail() {
	   return tail;
   }
   
   public int size() {
	   return size;
   }


   // Iterator completed with assistance from Nahuel Paladino
   // and Pedro Janikian.
   @Override
   public Iterator<T> iterator() {
	   return new Iterator<T>() {
		   
		   private Node<T> curr = head;
		   
		   @Override
		   public boolean hasNext() {
			   return curr != null;
		   }

		   @Override
		   public T next() {
			   T element = curr.getData();
			   curr = curr.getNext();
			   return element;
		   }
	   };
   } 
   
}
