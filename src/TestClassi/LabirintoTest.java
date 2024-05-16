package TestClassi;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	Labirinto l;
	Stanza biblioteca;
	Stanza N11;

	@Before
	public void setUp() {
		l = new Labirinto();
		
		biblioteca = new Stanza("Biblioteca");
		l.setStanzaVincente(biblioteca);
		N11 = new Stanza("N11");
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(N11);
		assertEquals(N11, l.getStanzaCorrente());
	}
	

}
