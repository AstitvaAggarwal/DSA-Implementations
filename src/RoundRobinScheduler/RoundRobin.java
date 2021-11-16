package RoundRobinScheduler;

import java.util.Scanner;

public class RoundRobin {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			int timetaken = 0;
			System.out.println("Enter the time Quantum of the system: ");
			int timequantum = Integer.parseInt(input.nextLine());
			System.out.println("Enter number of processes in CPU: ");
			int nprocess = Integer.parseInt(input.nextLine());
			Queueprocess<Integer> tocpu = new Queueprocess<Integer>(nprocess);
			Queueprocess<Integer> fromcpu = new Queueprocess<Integer>(nprocess);
			System.out.println("Enter the Burst time of each process in order:");
			for (int i = 0; i < nprocess; i++) {
				tocpu.enqueue(input.nextInt());
			}
			input.nextLine();
			while (!tocpu.isEmpty()) {
				System.out.println("Currently the processes and their burstime left is :");
				tocpu.display();
				while (tocpu.currentsize > 0) {
					int temp = tocpu.dequeue();
					if (temp > timequantum) {
						temp -= timequantum;
						timetaken += timequantum;
						fromcpu.enqueue(temp);
					} else {
						timetaken += temp;
					}
				}
				if (!fromcpu.isEmpty()) {
					while (fromcpu.currentsize > 0) {
						int temp = fromcpu.dequeue();
						tocpu.enqueue(temp);
					}
				}
			}
			System.out.println("Total time taken in processing is : " + timetaken);
			System.out.println("Do you want to continue ? (Yes(1) or No(any other integer)): ");
			if (input.nextInt() != 1) {
				break;
			}
		}
		System.out.println("---------Program has Ended---------");
		input.close();
	}
}