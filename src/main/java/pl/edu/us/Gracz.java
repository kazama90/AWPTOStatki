package pl.edu.us;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gracz {
	String nazwa;
	Plansza plansza;
	int rozmiarPlanszy;

	public Gracz(String nazwa, int rozmiarPlanszy) {
		this.nazwa=nazwa;
		this.rozmiarPlanszy = rozmiarPlanszy;

		List<Statek> statki = generujStatki(new int[] { 2, 2, 2, 3, 3, 4 });

		plansza = new Plansza(rozmiarPlanszy, statki);
	}

	private List<Statek> generujStatki(int[] wymiaryStatkow) {
		List<Statek> statki = new ArrayList<Statek>();
		for (int i = 0; i < wymiaryStatkow.length; i++) {
			Statek statek = generujStatek(wymiaryStatkow[i]);

			if (!czyKolizja(statki, statek)) {
				statki.add(statek);
			} else {
				i--;
			}
		}
		return statki;
	}

	private boolean czyKolizja(List<Statek> statki, Statek statekNowy) {
		for (Statek statek : statki) {
			for (Point punkt : statekNowy.punktyStatku) {
				if (statek.CzyPunktWStatku(punkt))
					return true;
			}
		}
		return false;
	}

	private Statek generujStatek(int wymiarStatku) {
		Random randomizer = new Random();
		List<Point> punkty = new ArrayList<Point>();

		Point punkt1 = new Point(randomizer.nextInt(rozmiarPlanszy),
				randomizer.nextInt(rozmiarPlanszy));

		int kierunek = randomizer.nextInt(2);

		if (kierunek == 0) {
			if (punkt1.x + wymiarStatku >= rozmiarPlanszy) {
				punkt1.x -= wymiarStatku;
			}
			punkty.add(punkt1);
			for (int i = 1; i < wymiarStatku; i++) {
				punkty.add(new Point(punkt1.x + i, punkt1.y));
			}
		} else {
			if (punkt1.y + wymiarStatku >= rozmiarPlanszy) {
				punkt1.y -= wymiarStatku;
			}
			punkty.add(punkt1);
			for (int i = 1; i < wymiarStatku; i++) {
				punkty.add(new Point(punkt1.x, punkt1.y + i));
			}
		}
		return new Statek(punkty);
	}

	public int Ruch(Plansza planszaPrzeciwnika) {
		int wynikStrzalu = -1;
		while (wynikStrzalu == -1) {
			try {
				Random randomizer = new Random();
				int punktX = randomizer.nextInt(planszaPrzeciwnika.rozmiar);
				int punktY = randomizer.nextInt(planszaPrzeciwnika.rozmiar);

				wynikStrzalu = planszaPrzeciwnika.Strzel(new Point(punktX,
						punktY));
			} catch (Exception ex) {
			}
		}
		return wynikStrzalu;
	}
}
