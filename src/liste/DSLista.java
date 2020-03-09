package liste;

public class DSLista {
	private Cvor prvi;

	public DSLista() {
		super();
		this.prvi = null;
	}

	public void unesiNaPocetak(int podatak) {
		Cvor novi = new Cvor(podatak);
		if (prvi == null) {
			prvi = novi;
			return;
		}
		prvi.setPrethodni(novi);
		novi.setSledeci(prvi);
		prvi = novi;
	}

	public void unesiNaKraj(int podatak) {
		if (prvi == null)
			unesiNaPocetak(podatak);
		else {
			Cvor novi = new Cvor(podatak), pom = this.prvi;
			while (pom.getSledeci() != null) {
				pom = pom.getSledeci();
			}
			pom.setSledeci(novi);
			novi.setPrethodni(pom);
		}
	}

	public Integer izbaciSaPocetka() {
		if (this.prvi == null) {
			System.err.println("Lista je prazna, nema sta da se izbaci sa pocetka");
			return null;
		}
		if (this.prvi.getSledeci() == null) {
			int izbaceni = prvi.getPodatak();
			prvi = null;
			return izbaceni;
		}
		int izbaceni = prvi.getPodatak();
		prvi.getSledeci().setPrethodni(null);
		prvi = prvi.getSledeci();
		return izbaceni;

	}

	public int izbaciSaKraja() {
		if (this.prvi == null)
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("Lista je prazna, nema sta da se izbaci sa pocetka");
			}
		if (this.prvi.getSledeci() == null) {
			int izbaceni = prvi.getPodatak();
			prvi = null;
			return izbaceni;
		}

		Cvor pom = this.prvi;
		while (pom.getSledeci() != null) {
			pom = pom.getSledeci();
		}
		pom.getPrethodni().setSledeci(null);
		return pom.getPodatak();
	}

	public void unesiNaZadatuPoziciju(int podatak, int pozicija) {
		Cvor novi = new Cvor(podatak), pom = this.prvi;
		if (pozicija == 1) {
			unesiNaPocetak(podatak);
			return;
		}
		int i;
		for (i = 0; pom != null && i < pozicija -1; i++) {
			pom = pom.getSledeci();
		}
		if (pom != null) {
			pom.getPrethodni().setSledeci(novi);
			novi.setPrethodni(pom.getPrethodni());
			novi.setSledeci(pom);
			pom.setPrethodni(novi);
		} else
			unesiNaKraj(podatak);
	}

	public Integer izbaciSaZadatePozicije(int pozicija) {
		if (this.prvi == null) {
			System.err.println("Lista je prazna, nema sta da se izbaci");
			return null;
		}
		if (pozicija == 1)
			return izbaciSaPocetka();

		Cvor pom = this.prvi;
		int i;
		for (i = 1; pom.getSledeci() != null && i < pozicija; i++)
			pom = pom.getSledeci();

		if (pom.getSledeci() != null) {
			pom.getPrethodni().setSledeci(pom.getSledeci());
			pom.getSledeci().setPrethodni(pom.getPrethodni());
			return pom.getPodatak();
		} else if (i < pozicija)
			return null;
		return izbaciSaKraja();
	}

	public void izlistaj() {
		Cvor pom = this.prvi;
		while (pom != null) {
			System.out.println(pom.getPodatak());
			pom = pom.getSledeci();
		}
		System.out.println("=========================");
	}
}
