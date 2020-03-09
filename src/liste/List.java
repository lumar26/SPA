package liste;

public interface List<E> {
	public void insertAtTheBeginning(E e);
	public void insertAtTheEnd(E e);
	public E deleteAtTheBeginning();
	public E deleteAtTheEnd();
	public void view();
	public void insertAt(E e, int position);
	public E deleteAt(int position);
	public boolean isEmpty();
}
