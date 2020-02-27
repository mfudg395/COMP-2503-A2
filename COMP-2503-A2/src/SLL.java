import java.util.Comparator;
import java.util.Iterator;

public class SLL<T extends Comparable<T>> implements Iterable<T> {

	private Node<T> head;
	private int size;

	public SLL() {
		head = null;
		size = 0;
	}
	
	public SLL(SLL<T> list, Comparator<T> c) {
		head = null;
		size = 0;
		for (T t : list) {
			list.addInOrder(t, c);
		}
	}

	public void addHead(Node<T> n) {
		n.setNext(null);
		if (head == null) {
			head = n;
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
		} else {
			Node<T> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(n);
		}

	}
	// consider splitting into 2 methods (add natural, add comparator); add comparator is only called
	// if your SLL took in a Comparator parameter (either asc or desc). This method would be how it's
	// added naturally, but you'd need a new one for the Comparators
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
	
	public void addInOrder(T t, Comparator<T> c) {
		Node<T> n = new Node<>(t);
		if (n.getData() == null) {
			return;
		}

		if (head == null || c.compare(n.getData(), head.getData()) >= 0) {
			addHead(n);
		} else {
			Node<T> curr = head;
			while (curr.getNext() != null && c.compare(n.getData(), head.getData()) < 0) {
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

	public SLL<T> sort(Comparator<T> c) {
			if (isEmpty()) {
				return null;
			} else {
				Node<T> curr = head, index;
				T temp;
				while (curr != null) {
					index = curr.getNext();
					while (index != null) {
						if (c.compare(curr.getData(), index.getData()) < 0) {
							temp = curr.getData();
							curr.setData(index.getData());
							index.setData(temp);
						}
					index = index.getNext();
					}
				curr = curr.getNext();
				}
			}
			return this;
		
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
		size = 0;
	}

	public int size() {
		return size;
	}

	private boolean isEmpty() {
		return size == 0;
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
