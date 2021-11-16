package DataStructure;

public class SinglyLinkedList<E> {

	private static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n) {
			element = e; // reference to the element stored at this node
			next = n; // reference to the subsequent node in the list
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

	private Node<E> head = null; // head node of the list(null if empty)
	private Node<E> tail = null; // last node of the list(null if empty)
	private int size = 0; // number of nodes in list

	public SinglyLinkedList() { // makes an initially empty linked list
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
		}
		return head.getelement();
	}

	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getelement();
	}

	public void addfirst(E e) {
		// adds element e to the front of the list
		head = new Node<E>(e, head);
		// create and link a new node
		if (size == 0) {
			tail = head;
			// special case: new node becomes tail also
		}
		size++;
	}

	public void addlast(E e) {
		// adds element e to the end of the list
		Node<E> newnode = new Node<E>(e, null);
		// node will eventually be tail
		if (isEmpty()) {
			head = newnode;
			// special case:previously empty list
		} else {
			tail.setnext(newnode);
			// new node after existing tail
		}
		tail = newnode; /// new node becomes tail
		size++;
	}

	public E removefirst() { // removes and returns the first element
		if (isEmpty()) {
			return null; // nothing to remove
		}
		E answer = head.getelement();
		head = head.getnext(); // will become null if the list had previously one node only
		size--;
		if (size == 0) {
			tail = null; // special case as list is now empty
		}
		return answer;
	}

	public static void main(String[] args) {
	}

}
