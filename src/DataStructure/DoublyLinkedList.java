package DataStructure;

public class DoublyLinkedList<E> {

	private static class Node<E> {
		private E element; // reference to the element stored at this node
		private Node<E> prev; // reference to the prev node in the doubly linked list
		private Node<E> next; // reference to the next node in the doubly linked list

		public Node(E e, Node<E> prev, Node<E> next) {
			this.element = e;
			this.prev = prev;
			this.next = next;
		}

		public E getelement() {
			return element;
		}

		public Node<E> getprev() {
			return prev;
		}

		public Node<E> getnext() {
			return next;
		}

		public void setnext(Node<E> next) {
			this.next = next;
		}

		public void setprev(Node<E> prev) {
			this.prev = prev;
		}
	}

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public DoublyLinkedList() {
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, header, null);
		header.setnext(trailer);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		return header.getnext().getelement();
	}

	public E last() {
		return trailer.getprev().getelement();
	}

	public void addbetween(E e, Node<E> prev, Node<E> next) {
		Node<E> betweenNode = new Node<E>(e, prev, next);
		prev.setnext(betweenNode);
		next.setprev(betweenNode);
		size++;
	}

	public void addfirst(E e) {
		addbetween(e, trailer.getprev(), trailer);
	}

	public void addlast(E e) {
		addbetween(e, header, header.getnext());
	}

	public E remove(Node<E> n) {
		E e = n.getelement();
		Node<E> prev = n.getprev();
		Node<E> next = n.getnext();
		next.setprev(prev);
		prev.setnext(next);
		size--;
		return e;
	}

	public E removefirst() {
		if (isEmpty()) {
			return null;
		}
		return remove(header.getnext());
	}

	public E removelast() {
		if (isEmpty()) {
			return null;
		}
		return remove(trailer.getprev());
	}

}
