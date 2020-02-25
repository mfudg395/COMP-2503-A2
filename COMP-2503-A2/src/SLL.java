import java.util.Iterator;

public class SLL<T extends Comparable<T>> implements Iterable<T> {
   private Node<T> head;
   private Node<T> tail; 
 
   public void addHead(Node<T> n) {
	   n.setNext(null);
	   
	   if (n.getData() == null) { // nothing happens if the new node has no data
		   return;
	   }
	   
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

   public void add(Node<T> n) {
	   // TODO: add an element in the appropriate position of
	   // the list (by natural sorting, ascending, or descending)
   }
   
   public void printList() {
       System.out.println();
       Node<T> currentNode = head;
       while (currentNode != null) {
           System.out.println(currentNode.toString());
           currentNode = currentNode.getNext();
       }
   }
   
   public void emptyList() {
       head = null;
       tail = null;
   }
   
   public Node<T> getTail() {
	   return tail;
   }


   // Iterator completed with assistance from Nahuel Paladino
   // and Pedro Janikian.
   @Override
   public Iterator<T> iterator() {
	   return new Iterator<T>() {
		   
		   Node<T> curr = head;
		   
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
