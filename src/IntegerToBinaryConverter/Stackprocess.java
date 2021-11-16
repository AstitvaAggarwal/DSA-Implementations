package IntegerToBinaryConverter;

interface Stack<E> {
	int size();

	boolean isEmpty();

	E top();

	E pop();

	void push(E value);

}

public class Stackprocess<E> implements Stack<E> {
	E[] array;
	int front;

	@SuppressWarnings("unchecked")
	public Stackprocess(int size) {
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

}