package DataStructure;

public class CircularlyLinkedList<E> {

	private static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E element, Node<E> n) {

			this.element = element; // reference to the element stored at this node
			this.next = n; // reference to the subsequent node in the list
		}

		public E getelement() {
			return element;
		}

		public Node<E> getnext() {
			return next;
		}

		public void setnext(Node<E> n) {
			next = n;
		}
	}

	private Node<E> tail = null; // we store tail (but not head)
	private int size = 0; // number of nodes initially 0

	public CircularlyLinkedList() {
		// create an initially empty circularly linked list
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty()) {
			return null;
		} else {
			return tail.getnext().getelement(); // the head is after tail
		}
	}

	public E last() { // returns but does not remove the last element
		if (isEmpty()) {
			return null;
		} else {
			return tail.getelement();
		}
	}

	public void rotate() { // rotate the first element to the back of the list
		if (!isEmpty()) {
			tail = tail.getnext();
		}
	}

	public void addfirst(E e) { // adds element E to the front of the list

		if (isEmpty()) {
			tail = new Node<E>(e, null);
			tail.setnext(tail); // links to itself circularly
		} else {
			Node<E> newfirst = new Node<E>(e, tail.getnext());
			tail.setnext(newfirst);
		}
		size++;
	}

	public void addlast(E e) {

		// Basically add a new node at front of link (addfirst method) and then
		// rotate the circularly list (set new tail as new element)
		// addfirst(e);
		// rotate();

		if (isEmpty()) {
			tail = new Node<E>(e, null);
			tail.setnext(tail); // links to itself circularly
		} else {
			Node<E> newlast = new Node<E>(e, tail.getnext());
			tail.setnext(newlast);
			rotate();
		}
		size++;
	}

	public E removeFirst() { // removes and returns first element
		if (isEmpty()) {
			return null;
		}

		E n = tail.getnext().getelement();
		if (size() == 1) {
			tail = null; // only one Node present case
		} else {
			tail.setnext(tail.getnext().getnext()); // removing first/"head" node by skipping its link
		}
		size--;
		return n;
	}

}
