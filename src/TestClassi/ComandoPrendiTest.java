package TestClassi;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	IOConsole io = new IOConsole();
	Partita p = new Partita(io);

	ComandoPrendi c = new ComandoPrendi();
	
	Attrezzo moneta;
	Attrezzo spada;
	@Before
	public void setUp() {
		moneta = new Attrezzo("moneta", 7);
		spada = new Attrezzo("spada", 20);
		p.getStanzaCorrente().addAttrezzo(moneta);
		//p.getGiocatore().getBorsa().addAttrezzo(moneta);
		
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
