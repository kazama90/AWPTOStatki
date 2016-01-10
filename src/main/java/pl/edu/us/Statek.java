package pl.edu.us;

import java.awt.Point;
import java.util.List;

public class Statek {
		
	List<Point> punktyStatku;
	
	public Statek(List<Point> punktyStatku) {
		this.punktyStatku = punktyStatku;
	}

	public boolean Strzel(Point punkt)
	{
		if(punktyStatku.contains(punkt))
		{
			punktyStatku.remove(punkt);
			return true;
		}
		return false;
	}
	
	public boolean Zatopiony()
	{
		return punktyStatku.isEmpty();
	}
	
	public boolean CzyPunktWStatku(Point punkt)
	{
		return punktyStatku.contains(punkt);
	}	
}
