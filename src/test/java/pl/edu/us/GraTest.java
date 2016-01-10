package pl.edu.us;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GraTest {

	Gra gra;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Before
	public void initialize() {
		initializeGra();
		setUpStreams();
	}

	public void initializeGra() {
		gra = new Gra();
	}

	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void piszWynikTest1() throws Exception {
		
		assertEquals("trafiony", gra.pobierzWynik(1));	
		
	}

	@Test
	public void piszWynikTest2() throws Exception  {
		
		assertEquals("zatopiony", gra.pobierzWynik(2));		
	}
	
	@Test(expected = Exception.class) 
	public void piszWynikTest3() throws Exception {
		
		gra.pobierzWynik(3);		
	}
}
