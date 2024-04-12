package TestClassi;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class StanzaTest {	

	Stanza s1 = new Stanza("s1");
	Stanza s2= new Stanza("s2");

	Attrezzo bastone = new Attrezzo("bastone", 12);
	Borsa b;
	
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("sud"));
	}


	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente("sud", s2);
		assertEquals(s2, s1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testAddAttrezzoSenzaAttrezzo() {
		assertTrue(s1.addAttrezzo(bastone));
	}
	
	
	@Test
	public void testAddAttrezzoConAttrezzo() {
		s1.addAttrezzo(bastone);
		assertFalse(s1.addAttrezzo(bastone));
	}

}