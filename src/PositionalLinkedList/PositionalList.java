package PositionalLinkedList;

//An interface for Positional Linked Lists
public interface PositionalList<E> {

	int size();

	boolean isEmpty();

//  returns first position in the list or null if empty
	position<E> first();

//  returns last position in the list or null if empty
	position<E> last();

//	returns position immediately before position p or null if empty
	position<E> before(position<E> p) throws IllegalArgumentException;

//	returns position immediately after position p or null if empty
	position<E> after(position<E> p) throws IllegalArgumentException;

//	inserts element e at End of the list and returns its position
	position<E> addLast(E e);

//	inserts element e at Front of the list and returns its position
	position<E> addFirst(E e);

	/*
	 * inserts an element e just before position p and returns position of newly
	 * inserted element
	 */
	position<E> addBefore(E e, position<E> p) throws IllegalArgumentException;

	// inserts an element e just after position p and returns
//	position of newly inserted element
	position<E> addAfter(E e, position<E> p) throws IllegalArgumentException;

	// Sets element e at the position E and returns the replaced element
	E set(position<E> p, E e) throws IllegalArgumentException;

	// removes and return Element at Position p invalidating p also
	E remove(position<E> p) throws IllegalArgumentException;

}
