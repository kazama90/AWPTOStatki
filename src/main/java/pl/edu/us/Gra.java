package pl.edu.us;

public class Gra {

	int rozmiarPlanszy = 10;

	boolean aktualnyGracz;

	int tura;

	Gracz gracz1;

	Gracz gracz2;

	public Gra() {
		tura = 1;
		gracz1 = new Gracz(rozmiarPlanszy);
		gracz2 = new Gracz(rozmiarPlanszy);
	}

	public String Graj() {
		boolean koniecGry = false;
		while (!koniecGry) {
			int wynik;
			System.out.println("Tura " + tura);
			if (aktualnyGracz) {
				wynik = gracz1.Ruch(gracz2.plansza);
				
				if(wynik==1)
				{
					System.out.println("trafiony");
				}
				else if(wynik==2)
				{
					System.out.println("zatopiony");
				}
				else if(wynik==0)
				{
					System.out.println("pudlo");
				}
				
				if (!gracz2.plansza.IstniejeStatek()) {
					koniecGry = true;
					return "Wygral gracz1";
				}

			} else {
				wynik = gracz2.Ruch(gracz1.plansza);
				
				if(wynik==1)
				{
					System.out.println("trafiony");
				}
				else if(wynik==2)
				{
					System.out.println("zatopiony");
				}
				else if(wynik==0)
				{
					System.out.println("pudlo");
				}
				if (!gracz1.plansza.IstniejeStatek()) {
					koniecGry = true;
					return "Wygral gracz2";
				}
			}
			if(wynik==0)
				aktualnyGracz = !aktualnyGracz;
			tura++;
		}
		return "Nikt nie wygral";
	}
}
