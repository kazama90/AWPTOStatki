package pl.edu.us;

public class Gra {

	int rozmiarPlanszy = 10;

	boolean aktualnyGracz;

	int tura;

	Gracz gracz1;

	Gracz gracz2;

	public Gra() {
		tura = 1;
		gracz1 = new Gracz("gracz1", rozmiarPlanszy);
		gracz2 = new Gracz("gracz2", rozmiarPlanszy);
	}

	public String Graj() {
		boolean koniecGry = false;
		while (!koniecGry) {
			System.out.println("Tura " + tura);
			if (aktualnyGracz) {

				koniecGry = ruchGracza(gracz1, gracz2.plansza);

				if (koniecGry) {
					return "Wygral " + gracz1.nazwa;
				}

			} else {

				koniecGry = ruchGracza(gracz2, gracz1.plansza);

				if (koniecGry) {
					return "Wygral " + gracz2.nazwa;
				}
			}

			tura++;
		}
		return "Nikt nie wygral";
	}

	private boolean ruchGracza(Gracz gracz, Plansza plansza) {
		int wynik = gracz.Ruch(plansza);

		piszWynik(wynik);

		if (wynik == 0)
			aktualnyGracz = !aktualnyGracz;

		if (!plansza.IstniejeStatek()) {
			return true;
		}
		return false;
	}

	void piszWynik(int wynik) {
		try {
			System.out.println(pobierzWynik(wynik));
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	String pobierzWynik(int wynik) throws Exception {
		if (wynik == 1) {
			return "trafiony";
		} else if (wynik == 2) {
			return "zatopiony";
		} else if (wynik == 0) {
			return "pudlo";
		}
		throw new Exception("Wynik poza zakresem");
	}
}
