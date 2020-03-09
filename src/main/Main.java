package main;

import liste.CircularList;
import liste.DSLista;
import liste.List;
import queue.ArrayQueue;
import queue.LinkedQueue;
import queue.Queue;

public class Main {

	public static void main(String[] args) {
		List<Integer> lista = new CircularList<Integer>();
		// lista.insertAtTheEnd(13);
		// lista.insertAtTheBeginning(1);
		// lista.insertAtTheBeginning(8);
		// lista.insertAtTheBeginning(9);
		//
		// lista.view();
		//
		lista.insertAt(100, 1);
		lista.view();
		lista.deleteAt(1);
		lista.view();

	}

}
