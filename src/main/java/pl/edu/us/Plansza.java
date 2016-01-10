package pl.edu.us;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Plansza {

	int rozmiar;

	List<Statek> statki;

	List<Point> strzelonePunkty;

	public Plansza(int rozmiar, List<Statek> statki) {
		this.rozmiar = rozmiar;
		this.statki = statki;
		strzelonePunkty=new ArrayList<Point>();
	}

	public int Strzel(Point punkt) throws Exception {
		if (punkt.x >= rozmiar || punkt.y >= rozmiar) {
			throw new Exception("Punkt poza plansza");
		} else if (strzelonePunkty.contains(punkt)) {
			throw new Exception("Wybrany punkt juz zostal strzelony");
		} else {
			strzelonePunkty.add(punkt);
			for (Statek statek : statki) {
				if (statek.Strzel(punkt)) {
					if (statek.Zatopiony()) {
						statki.remove(statek);
						return 2;
					}

					return 1;
				}
			}
		}
		return 0;
	}

	public boolean IstniejeStatek() {
		return !statki.isEmpty();
	}
}
