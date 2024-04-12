package TestClassi;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BorsaTest {
	Borsa b = new Borsa();
	Attrezzo moneta;
	Attrezzo spada;
	
	@Before
	public void setUp() {
		moneta = new Attrezzo("moneta", 7);
		spada = new Attrezzo("spada", 20);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(moneta));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(spada));

	}
	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(moneta);
		assertEquals(moneta, b.getAttrezzo("moneta"));

	}
	
	@Test 
	public void rimuoviAttrezzo() {
		b.removeAttrezzo("moneta");
		assertFalse(b.equals(b.getAttrezzo("moneta")));
	
	}

}
