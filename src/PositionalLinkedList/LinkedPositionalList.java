package PositionalLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E> {

	// Nested Node Class for Positional Linked list
	private static class Node<E> implements position<E> {

		private E element;// reference to the element stored at this node
		private Node<E> prev;// reference to the previous node in list
		private Node<E> next;// reference to the next node in list

		// Constructor to create General Node
		public Node(E e, Node<E> prev, Node<E> next) {
			this.prev = prev;
			this.element = e;
			this.next = next;
		}

		public E getElement() throws IllegalStateException {
			if (next == null)
				throw new IllegalStateException("Position is no Longer Valid");
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setElement(E e) {
			element = e;
		}

		public void setNext(Node<E> n) {
			next = n;
		}

		public void setPrev(Node<E> p) {
			prev = p;
		}

	}
	// End of the Nested Node Class

	// instance variable of the LinkedPositionalList
	private Node<E> header; // header sentinel
	private Node<E> trailer; // trailer sentinel
	private int size = 0;

	// constructor to create an empty List
	public LinkedPositionalList() {
		header = new Node<E>(null, null, null); // create header
		trailer = new Node<E>(null, header, null);
		header.setNext(trailer); // header next is trailer
	}

	// Private functions specifically for this class
	// Function1-Validates a Position and returns "it as a Node"
	private Node<E> validate(position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node<E>))
			throw new IllegalArgumentException("invalid Position p");

		Node<E> node = (Node<E>) p;// we are safe casting here

		if (node.getNext() == null)
			throw new IllegalArgumentException("Position p is no longer Valid");
		return node;
	}

	// Function2-Returns the given Node "as a Position" or null if Node is Sentinal
	private position<E> Position(Node<E> node) {
		if ((node == trailer) || (node == header)) {
			return null; // we can't expose sentinel Nodes
		}
		return node;
	}

	// Function3-Adds Element e to linked List between two given Nodes
	private position<E> addBetween(E e, Node<E> p, Node<E> n) {
		Node<E> newnode = new Node<E>(e, p, n); // create Node to be inserted
		p.setNext(newnode);
		n.setPrev(newnode);
		size++;
		return newnode;
	}

	// End of Group of private functions specific to LinkedPositionalList<E> class

	// Publicly accessible functions as same declared in PositionalList<E> interface
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// Returns Position of first element in List
	public position<E> first() {
		return Position(header.getNext());
	}

	// Returns Position of last element in List
	public position<E> last() {
		return Position(trailer.getPrev());
	}

	// Returns Position immediately before Position p
	public position<E> before(position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return Position(node.getPrev());
	}

	// Returns Position immediately after Position p
	public position<E> after(position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return Position(node.getNext());
	}

//	inserts element e at End of the list and returns its position
	public position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

//	inserts element e at Front of the list and returns its position
	public position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	/*
	 * inserts an element e just before position p and returns position of newly
	 * inserted element
	 */
	public position<E> addBefore(E e, position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	/*
	 * inserts an element e just after position p and returns position of newly
	 * inserted element
	 */
	public position<E> addAfter(E e, position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	// Sets element e at the position E and returns the replaced element
	public E set(position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E replaced = node.getElement();
		node.setElement(e);
		return replaced;
	}

	// removes and return Element at Position p invalidating p also
	public E remove(position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E removed = node.getElement();
		Node<E> prevnode = node.getPrev();
		Node<E> nextnode = node.getNext();
		prevnode.setNext(nextnode);
		nextnode.setPrev(prevnode);
		size--;
		node.setElement(null); // to help with garbage collection
		node.setNext(null); // Convention for defunct Node
		node.setPrev(null);
		return removed;
	}

	// ----------------nested PositionIterator Class------------------
	private class PositionIterator implements Iterator<position<E>> {
		private position<E> cursor = first(); // position of next element to report
		private position<E> recent = null; // position of last reported element

		// To check if Iterator has a next Object
		@Override
		public boolean hasNext() {
			return (cursor != null);
		}

		// Returning the Next Position in the Iterator
		@Override
		public position<E> next() throws NoSuchElementException {
			if (cursor == null)
				throw new NoSuchElementException("No more nodes left in the Positional Linked List");
			recent = cursor; // Element at this position
			cursor = after(cursor);
			return recent;
		}

		// Removes the element returned by most recent call to next
		public void remove() throws IllegalStateException {
			if (recent == null)
				throw new IllegalStateException("Reached end of List cant remove anything");
			LinkedPositionalList.this.remove(recent);// remove from outer List
			recent = null; // Do not allow remove again until next is called
		}

	}
	// ---------------End of nested PositionIterator Class-------------

	// ---------------Nested PositionIterable Class----------------
	private class PositionIterable implements Iterable<position<E>> {
		public Iterator<position<E>> iterator() {
			return new PositionIterator();
		}
	}
	// ---------------End of Nested PositionIterable Class---------------

	// Returns an iterable representation of the lists positions
	public Iterable<position<E>> positions() {
		return new PositionIterable(); // create a new instance of the inner class
	}

	// ------------Nested ElementIterator class------------
	// this class adapts the iteration produced by positions() to return elements
	private class ElementIterator implements Iterator<E> {
		Iterator<position<E>> positerator = new PositionIterator();

		public boolean hasNext() {
			return positerator.hasNext();
		}

		public E next() {
			return positerator.next().getElement();
		} // return element

		public void remove() {
			positerator.remove();
		}
	}

}
