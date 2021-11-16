package DataStructure;

import java.util.Scanner;

interface Stack<E> {
	int size();

	boolean isEmpty();

	E top();

	E pop();

	void push(E value);

}

public class ArrayStack<E> implements Stack<E> {
	E[] array;
	int front;

	@SuppressWarnings("unchecked")
	public ArrayStack(int size) {
		this.array = (E[]) new Object[size];
		front = -1;
	}

	public int size() {
		return front + 1;

	}

	public boolean isEmpty() {
		if (front >= 0) {
			return false;
		}
		return true;
	}

	public E top() {
		if (front == -1) {
			return null;
		}
		return array[front];
	}

	public E pop() {
		if (isEmpty()) {
			return null;
		}
		front--;
		return array[front + 1];
	}

	public void push(E value) {
		if (isFull()) {
			System.out.println("Cannot Add more elements in Stack as it is full !");
		}
		front++;
		array[front] = value;
	}

	public boolean isFull() {
		if (front == array.length - 1) {
			return true;
		}
		return false;
	}

	public void display() {
		if (front == -1)
			System.out.println("Stack is Empty !");
		else {
			for (int i = 0; i <= front; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println("");
		}

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean cont = true;

		System.out.println("Enter size of Stack : ");
		int size = Integer.parseInt(input.nextLine());
		System.out.println("Taking data type of Stack as Integer : ");
		ArrayStack<Integer> stack = new ArrayStack<Integer>(size);

		while (cont) {

			System.out.println("Enter choice of Operation on Stack : ");
			System.out.println(
					"Pop element(p)|Push element(P)|check size(s)|get top element(t)|check if empty(e)|Display(d)|Exit(x): ");
			char type1 = input.next().charAt(0);
			input.nextLine();
			if (type1 == 'x') {
				cont = false;
			} else if (type1 == 'p') {
				System.out.println(stack.pop() + " has been popped from Stack !");
			} else if (type1 == 'P') {
				System.out.println("Enter element you want to push in stack : ");
				size = Integer.parseInt(input.nextLine());
				stack.push(size);
				System.out.println(size + " has been pushed onto the Stack !");
			} else if (type1 == 's') {
				System.out.println("The currentsize of stack is : " + stack.size());
			} else if (type1 == 't') {
				System.out.println("The top element of stack is : " + stack.top());
			} else if (type1 == 'e') {
				System.out.println("the Stack is empty ? : " + stack.isEmpty());
			} else if (type1 == 'd') {
				System.out.print("The Stack is as follows : ");
				stack.display();
			} else {
				System.out.println("Wrong input exiting program by default !");
				cont = false;
			}

		}
		input.close();
		System.out.println("-----------THE PROGRAM HAS ENDED-----------");
	}

}