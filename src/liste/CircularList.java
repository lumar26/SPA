package liste;

public class CircularList<E> implements List {

	private int count;
	private Node start;

	@Override
	public void insertAtTheBeginning(Object e) {
		Node<E> node = new Node<E>((E) e);
		if (start == null) {
			start = node;
			start.setNext(start);
			start.setPrevious(start);
			count++;
			return;
		}
		node.setNext(start);
		node.setPrevious(start.getPrevious());
		start.getPrevious().setNext(node);
		start.setPrevious(node);
		start = node;
		count++;
	}

	@Override
	public void insertAtTheEnd(Object e) {
		Node<E> node = new Node<E>((E) e);
		if (start == null) {
			start = node;
			start.setNext(start);
			start.setPrevious(start);
			count++;
			return;
		}
		start.getPrevious().setNext(node);
		node.setPrevious(start.getPrevious());
		node.setNext(start);
		start.setPrevious(node);
		count++;
	}

	@Override
	public Object deleteAtTheBeginning() {
		if (isEmpty())
			return null;
		if (start.getNext() == start && start == start.getPrevious()) {
			E temp = (E) start.getData();
			start = null;
			count--;
			return temp;
		}
		start.getNext().setPrevious(start.getPrevious());
		start.getPrevious().setNext(start.getNext());
		E temp = (E) start.getData();
		start = start.getNext();
		count--;
		return temp;
	}

	@Override
	public Object deleteAtTheEnd() {
		if (isEmpty())
			return null;
		if (start.getNext() == start && start == start.getPrevious()) {
			E temp = (E) start.getData();
			start = null;
			count--;
			return temp;
		}
		E temp = (E) start.getPrevious().getData();
		start.setPrevious(start.getPrevious().getPrevious());
		start.getPrevious().getPrevious().setNext(start);
		count--;
		return temp;
	}

	@Override
	public void view() {
		Node temp = start;
		System.out.println("The content of the list is: ");
		for (int i = 0; i < count && temp != null; i++) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

	@Override
	public void insertAt(Object e, int position) {
		if (count + 1 < position || position < 1) {
			System.err.println("You have given wrong position");
			return;
		}
		Node temp = start, node = new Node((E) e);
		if (position == 1) {
			insertAtTheBeginning(e);
			return;
		}
		for (int i = 0; i < position - 1; i++) {
			temp = temp.getNext();
		}
		temp.getPrevious().setNext(node);
		node.setPrevious(temp.getPrevious());
		temp.setPrevious(node);
		node.setNext(temp);
		count++;

	}

	@Override
	public Object deleteAt(int position) {
		if (isEmpty() || position > count)
			return null;
		if (count == 1) {
			E temp = (E) start.getData();
			start = null;
			count--;
			return temp;
		}
		if (position == 1)
			return deleteAtTheBeginning();
		Node temp = start;
		for (int i = 0; i < position - 1; i++)
			temp = temp.getNext();
		temp.getPrevious().setNext(temp.getNext());
		temp.getNext().setPrevious(temp.getPrevious());
		count--;
		return temp.getData();
	}

	@Override
	public boolean isEmpty() {
		if (count == 0)
			return true;
		return false;
	}

}
