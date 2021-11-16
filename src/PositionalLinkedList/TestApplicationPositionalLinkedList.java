package PositionalLinkedList;

import java.util.Iterator;

public class TestApplicationPositionalLinkedList {
	public static void main(String[] args) {

		LinkedPositionalList<Integer> L1 = new LinkedPositionalList<>();
		System.out.println("Is the List Empty ? :" + L1.isEmpty());
		System.out.println("Adding 1,2,3 and 4 to the List :\n");
		L1.addFirst(1);
		L1.addAfter(2, L1.first());
		L1.addLast(4);
		L1.addBefore(3, L1.last());

		System.out.println("The current size of Positional List is : " + L1.size());
		System.out.println("Is the List Empty ? :" + L1.isEmpty());

		Iterable<position<Integer>> iterb = L1.positions();
		Iterator<position<Integer>> itertr1 = iterb.iterator();
		System.out.println("The Positional Linked List now in order is :");
		while (itertr1.hasNext()) {
			System.out.print(itertr1.next().getElement() + " ");
		}

		System.out.println("\n");
		System.out.println("The first Element of The Positional List is : " + L1.first().getElement());
		System.out.println("The Last Element of The Positional List is : " + L1.last().getElement());
		System.out.println("");

		Iterator<position<Integer>> itertr2 = iterb.iterator();
		System.out.println("------ The Positional Linked List with each position's corresponding Elements ------ ");
		position<Integer> p2 = null;
		while (itertr2.hasNext()) {
			position<Integer> p1 = itertr2.next();
			if (p1.getElement() == 3)
				p2 = p1;
			System.out.println(p1 + " : " + p1.getElement());
		}

		System.out.println("\nReplacing Element 3 with Element 5 Using Set Function of LinkedPositionalList<E> Class:");
		L1.set(p2, 5);
		System.out.println("The Positional Linked List now in order is :");
		Iterator<position<Integer>> itertr3 = iterb.iterator();
		while (itertr3.hasNext()) {
			position<Integer> p1 = itertr3.next();
			if (p1.getElement() == 5)
				p2 = p1;
			System.out.print(p1.getElement() + " ");
		}

		System.out.println("\nRemoving 5 from the List");
		L1.remove(p2);
		System.out.println("The Positional Linked List now in order is :");
		Iterator<position<Integer>> itertr4 = iterb.iterator();
		while (itertr4.hasNext()) {
			System.out.print(itertr4.next().getElement() + " ");
		}

		System.out.println("\n");

		System.out.print("The Element before 1 is : " + L1.before(L1.first()));

		System.out.print("\nThe Element after 1 is : " + L1.after(L1.first()).getElement() + " at the position : "
				+ L1.after(L1.first()));

	}
}
