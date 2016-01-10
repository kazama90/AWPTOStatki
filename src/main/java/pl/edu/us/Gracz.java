package pl.edu.us;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gracz {
	Plansza plansza;

	public Gracz(int rozmiarPlanszy) {

		List<Point> punkty = new ArrayList<Point>();

		punkty.add(new Point(1, 1));
		punkty.add(new Point(1, 2));
		punkty.add(new Point(1, 3));
		punkty.add(new Point(1, 4));

		List<Statek> statki = new ArrayList<Statek>();
		statki.add(new Statek(punkty));

		plansza = new Plansza(rozmiarPlanszy, statki);
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
