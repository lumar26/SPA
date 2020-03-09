package liste;

public class Node<E> {
	private E data;
	private Node previous;
	private Node next;
	
	public Node(E data) {
		super();
		this.data = data;
		this.previous = null;
		this.next = null;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
