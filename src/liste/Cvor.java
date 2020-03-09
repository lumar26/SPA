package liste;

public class Cvor {
	private int podatak;
	private Cvor sledeci;
	private Cvor prethodni;
	
	//konstruktori
	public Cvor(int podatak) {
		super();
		this.podatak = podatak;
		this.sledeci = null;
		this.prethodni = null;
	}
	public Cvor(int podatak, Cvor sledeci, Cvor prethodni) {
		super();
		this.podatak = podatak;
		this.sledeci = sledeci;
		this.prethodni = prethodni;
	}
	
	//geteri i seteri
	public int getPodatak() {
		return podatak;
	}
	public void setPodatak(int podatak) {
		this.podatak = podatak;
	}
	public Cvor getSledeci() {
		return sledeci;
	}
	public void setSledeci(Cvor sledeci) {
		this.sledeci = sledeci;
	}
	public Cvor getPrethodni() {
		return prethodni;
	}
	public void setPrethodni(Cvor prethodni) {
		this.prethodni = prethodni;
	}
	
}
