import java.util.Scanner;

class QueueTestClass {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Queue q = new Queue();
		int option;
		do {
			System.out.println("1. enqueue");
			System.out.println("2. dequeue");
			System.out.println("3. print queue");
			System.out.println("4. exit");
			System.out.println("Enter your selection : ");
			option = scan.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter Character : ");
				char ch = scan.next().charAt(0);
				q.enqueue(ch);
				break;
			case 2:
				try
				{
					System.out.println("The character dequeued is : " + q.dequeue());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("The characters in the queue are :");
				q.printQueue();
				break;
			}
		} while (option != 4);
	}
}

class CharNode {
	char ch;
	CharNode next;

	public CharNode(char ch, CharNode node) {
		this.ch = ch;
		this.next = node;
	}
}

class Queue {
	private CharNode head;
	private CharNode tail;
	private int size;

	public void enqueue(char ch) {
		if (size == 10) {
			System.out.println("10 characters are present in the queue already use dequeue before adding to the queue.");
			return;
		}
		if (head == null) {
			head = new CharNode(ch, null);
			tail = head;
		} else {
			tail.next = new CharNode(ch, null);
			tail = tail.next;
		}
		size++;
	}

	public char dequeue() throws Exception {

		if (size == 0)
			throw new Exception("Queue Underflow!");

		CharNode node = head;
		head = head.next;
		size--;
		return node.ch;
	}

	public void printQueue() {
		CharNode temp = head;
		while (temp != null) {
			System.out.print(temp.ch + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}