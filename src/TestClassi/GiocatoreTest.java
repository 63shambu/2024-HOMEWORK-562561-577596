package TestClassi;
import static org.junit.Assert.*;

import org.junit.Test;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

import it.uniroma3.diadia.giocatore.*;

public class GiocatoreTest {
Giocatore g = new Giocatore();
Stanza s = new Stanza("prova");
Attrezzo bastone = new Attrezzo("bastone", 7);
Borsa b;
	
	@Test
	public void testGetCfuDefault() {
		assertEquals(20, g.getCfu());
	}
	
	@Test
	public void testSetCfu() {
		g.setCfu(3);
		assertEquals(3, g.getCfu());
	}

	@Test
	public void testGetBorsaDefault() {
		assertNotNull(g.getBorsa());
	}
	
	@Test
	public void posaAttrezzoStanzaSenzaAttrezzo() {
		b=g.getBorsa();
		b.addAttrezzo(bastone);
		assertTrue(g.posaAttrezzo(s, "bastone"));
	}
	
	@Test
	public void posaAttrezzoStanzaConAttrezzo() {
		b=g.getBorsa();
		b.addAttrezzo(bastone);
		g.posaAttrezzo(s, "bastone");
		assertFalse(g.posaAttrezzo(s, "bastone"));
	}
}
