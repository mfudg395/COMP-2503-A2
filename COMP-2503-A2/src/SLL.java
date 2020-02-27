/**
 * COMP-2503 Assignment 2 SLL class
 * 
 * This class represents a singly-linked list with a tracked head and
 * size.
 * 
 * Nodes inserted into lists of this class will be sorted by their
 * natural order, or by a given order with a Comparator.
 * 
 * @author Matthew Fudge
 */
import java.util.Comparator;
import java.util.Iterator;

public class SLL<T extends Comparable<T>> implements Iterable<T> {

	private Node<T> head;
	private int size;

	/**
	 * Constructor for objects of class SLL.
	 */
	public SLL() {
		head = null;
		size = 0;
	}

	/**
	 * Adds a node to the head of a singly-linked list.
	 * 
	 * @param n the node to add to the list
	 */
	public void addHead(Node<T> n) {
		n.setNext(null);
		if (head == null) {
			head = n;
		} else {
			n.setNext(head);
			head = n;
		}
	}

	/**
	 * Adds a node to the tail of a singly-linked list.
	 * 
	 * @param n the node to add to the list
	 */
	public void addTail(Node<T> n) {
		n.setNext(null);

		if (n.getData() == null) { // nothing happens if the new node has no data
			return;
		}

		if (head == null) {
			head = n;
		} else {
			Node<T> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(n);
		}

	}

	/**
	 * Adds nodes with given data to a list based on
	 * natural ordering.
	 * 
	 * @param t data to be used in a node
	 */
	public void addInOrder(T t) {
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
	
	/**
	 * Overloaded method that adds nodes with given data 
	 * to a list in an order defined by a given comparator.
	 * 
	 * @param t data to be used in a node
	 * @param c Comparator with criteria to sort list by
	 */
	public void addInOrder(T t, Comparator<T> c) {
		Node<T> n = new Node<>(t);
		if (n.getData() == null) {
			return;
		}

		if (head == null || c.compare(n.getData(), head.getData()) <= 0) {
			addHead(n);
		} else {
			Node<T> curr = head;
			while (curr.getNext() != null && c.compare(n.getData(), curr.getNext().getData()) > 0) {
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
	
	/**
	 * Prints all elements in a singly linked list.
	 */
	public void printList() {
		Node<T> curr = head;
		while (curr != null) {
			System.out.println(curr.toString());
			curr = curr.getNext();
		}
	}
	
	/**
	 * Overloaded method that prints a given amount of
	 * elements in the list.
	 * 
	 * @param amount
	 */
	public void printList(int amount) {
		Node<T> curr = head;
		int i = 0;
		while (curr != null && i < amount) {
			System.out.println(curr.toString());
			curr = curr.getNext();
			i++;
		}
	}

	public void emptyList() {
		head = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	/**
	 * Iterator used for SLL that returns each object in the list.
	 * This was created to allow for use of a for-each loop on lists
	 * in the A2 class.
	 * 
	 * Completed with assistance from Nahuel Paladino and Pedro Janikian.
	 */
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
