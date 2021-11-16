package RoundRobinScheduler;

interface scheduler<E> {
	int size();

	boolean isEmpty();

	void enqueue(E value);

	E first();

	E dequeue();

}

public class Queueprocess<E> implements scheduler<E> {
	E[] array;
	int rear;
	int front;
	int size;
	int currentsize;

	@SuppressWarnings("unchecked")
	Queueprocess(int size) {
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
			System.out.println(" Scheduler is Empty cannot remove elements !");
			return null;
		} else {
			currentsize--;
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
			System.out.println("Scheduler is Empty !");
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

}