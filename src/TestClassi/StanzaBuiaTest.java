package TestClassi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;



import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaBuiaTest {
	
	StanzaBuia s = new StanzaBuia("buia");
	Stanza     sEst = new Stanza("stanzaEst");
	
	Attrezzo lampada;
	Attrezzo spada;
	
	@Before
	public void setUp() {
		lampada = new Attrezzo("lampada", 7);
		spada = new Attrezzo("spada", 20);
		s.setStrumentoSblocca("lampada");
		s.impostaStanzaAdiacente("est", sEst);
	}
	
	
	@Test // non c'è lo strumento che illumina
	public void testGetDescrizioneStrumentoSbagliato() {
		s.addAttrezzo(spada);
		String descrizione = "Qui c'è buio pesto";
		assertEquals(descrizione, s.getDescrizione());
	}
	
	@Test //  c'è lo strumento che illumina
	public void testGetDescrizioneStrumentoGiusto() {
		s.addAttrezzo(lampada);
		String descrizione = "Qui c'è buio pesto";
		assertNotEquals(descrizione, s.getDescrizione());
	}
}
