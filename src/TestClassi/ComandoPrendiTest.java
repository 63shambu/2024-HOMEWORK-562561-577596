package TestClassi;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPrendiTest {
	IOConsole io = new IOConsole();
	Labirinto labirinto = new Labirinto();
	Partita p = new Partita(io, labirinto);

	ComandoPrendi c = new ComandoPrendi();
	
	Attrezzo moneta;
	Attrezzo spada;
	Stanza prova;
	@Before
	public void setUp() {
		moneta = new Attrezzo("moneta", 7);
		spada = new Attrezzo("spada", 20);
		
		prova = new Stanza("prove");
		prova.addAttrezzo(moneta);
		p.setStanzaCorrente(prova);
		
	}
	
	
 	@Test
	public void testPrendiAttrezzoSbagliato() {
        c.setParametro("spada");
        c.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("moneta"));
	}
 	
	@Test
	public void testPrendiAttrezzoGiusto() {

		assertTrue(p.getStanzaCorrente().hasAttrezzo("moneta"));
        c.setParametro("moneta");
        c.esegui(p);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("moneta"));
	}
	
}
