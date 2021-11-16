package DataStructure;

import java.util.Scanner;

interface Queue<E> {
	int size();

	boolean isEmpty();

	void enqueue(E value);

	E first();

	E dequeue();

}

public class ArrayQueue<E> implements Queue<E> {
	E[] array;
	int rear;
	int front;
	int size;
	int currentsize;

	@SuppressWarnings("unchecked")
	ArrayQueue(int size) {
		this.size = size;
		this.array = (E[]) new Object[size];
		rear = -1;
		front = 0;
		currentsize = 0;
	}

	public void enqueue(E value) {
		if (isFull()) {
			System.out.println(" Queue is Full cannot add more elements !");
		} else {
			System.out.println(value + " has been enqueued in Queue !");
			if (rear == array.length - 1) {
				rear = 0;
			} else {
				rear++;
			}
			array[rear] = value;
			currentsize++;
		}
	}

	public E dequeue() {
		if (isEmpty()) {
			System.out.println(" Queue is Empty cannot remove elements !");
			return null;
		} else {
			currentsize--;
			System.out.println(" " + array[front] + " has been removed from Queue !");

			if (front == array.length - 1) {
				front = 0;
				return array[array.length - 1];
			} else {
				front++;
				return array[front - 1];
			}
		}
	}

	public E first() {
		if (currentsize == 0) {
			return null;
		} else {
			return array[front];
		}
	}

	public int size() {
		if (currentsize == 0) {
			return -1;
		}
		return currentsize;
	}

	public boolean isEmpty() {
		if (currentsize == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (currentsize == array.length) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		if (rear == -1) {
			System.out.println("Queue is Empty !");
		} else if (rear < front) {
			for (int i = front; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			for (int i = 0; i <= rear; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println("");
		} else {
			for (int i = front; i <= rear; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean cont = true;

		System.out.println("Enter size of Queue : ");
		int size = Integer.parseInt(input.nextLine());
		System.out.println("Taking data type of Queue as Integer : ");
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>(size);

		while (cont) {

			System.out.println("Enter choice of Operation on Queue : ");
			System.out.println(
					"Enqueue(e)|Deqeue(d)|check size(s)|get first element(f)|check if empty(E)|Display(D)|Exit(x): ");
			char type1 = input.next().charAt(0);
			input.nextLine();
			if (type1 == 'x') {
				cont = false;
			} else if (type1 == 'd') {
				System.out.println(queue.dequeue() + " has been dequeued from Queue !");
			} else if (type1 == 'e') {
				System.out.println("Enter element you want to enqueue in Queue : ");
				size = Integer.parseInt(input.nextLine());
				queue.enqueue(size);
			} else if (type1 == 's') {
				System.out.println("The currentsize of Queue is : " + queue.size());
			} else if (type1 == 'f') {
				System.out.println("The first element of Queue is : " + queue.first());
			} else if (type1 == 'E') {
				System.out.println("the Queue is empty ? : " + queue.isEmpty());
			} else if (type1 == 'D') {
				System.out.print("The Queue is as follows : ");
				queue.display();
			} else {
				System.out.println("Wrong input exiting program by default !");
				cont = false;
			}

		}
		input.close();
		System.out.println("-----------THE PROGRAM HAS ENDED-----------");
	}
}