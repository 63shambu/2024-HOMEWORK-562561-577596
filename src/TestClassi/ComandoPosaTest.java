package TestClassi;
import it.uniroma3.diadia.comandi.ComandoPosa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPosaTest {

	IOConsole io = new IOConsole();
	Labirinto labirinto = new Labirinto();
	Partita p = new Partita(io, labirinto);
	
	
	ComandoPosa c = new ComandoPosa();
	
	Attrezzo moneta;
	Attrezzo spada;
	Stanza prova;
	@Before
	public void setUp() {
		moneta = new Attrezzo("moneta", 7);
		spada = new Attrezzo("spada", 20);
		prova = new Stanza("prove");
		p.getGiocatore().getBorsa().addAttrezzo(moneta);
		p.setStanzaCorrente(prova);
		
		
	}
	

	@Test
	public void testPosaAttrezzoGiusto() {
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("moneta"));
        c.setParametro("moneta");
        c.esegui(p); 
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("moneta"));
	}

 	@Test
	public void testPosaAttrezzoSbagliato() {
        c.setParametro("spada");
        c.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("moneta"));
	}
 
}
