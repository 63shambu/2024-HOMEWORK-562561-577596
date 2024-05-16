package TestClassi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;


public class PartitaTest {
    IOConsole io = new IOConsole();
    Labirinto labirinto = new Labirinto();
	Partita p = new Partita(io, labirinto);
	Stanza s = new Stanza("Stanza");
	Stanza s1 = new Stanza("Biblioteca");

	@Before
	public void setUp() {
		labirinto.setStanzaVincente(s1);
		
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		p.getLabirinto().setStanzaCorrente(s);
		assertEquals(s, p.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {
		assertFalse(p.isFinita());
	}
	
}