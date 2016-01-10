package pl.edu.us;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GraTest {

	Gra gra;

	@Before
	public void initialize() {
		gra = new Gra();
	}

	@Test
	public void piszWynikTest1() throws Exception {
		
		assertEquals("trafiony", gra.pobierzWynik(1));	
		
	}

	@Test
	public void piszWynikTest2() throws Exception  {
		
		assertSame("zatopiony", gra.pobierzWynik(2));		
	}
	
	@Test(expected = Exception.class) 
	public void piszWynikTest3() throws Exception {
		
		gra.pobierzWynik(3);		
	}
}
