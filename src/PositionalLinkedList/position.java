package PositionalLinkedList;

public interface position<E> {

	/*
	 * returns the element stored at this particular position but throws
	 * illegalStateException if Position is no Longer Valid
	 */
	E getElement() throws IllegalStateException;
}