package TestClassi;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	StanzaBloccata s = new StanzaBloccata("bloccata");
	Stanza     sEst = new Stanza("stanzaEst");
	Stanza     sOvest = new Stanza("stanzaOvest");
	
	Attrezzo piedeDiPorco;
	Attrezzo spada;
	
	@Before
	public void setUp() {
		piedeDiPorco = new Attrezzo("piedeDiPorco", 7);
		spada = new Attrezzo("spada", 20);
		s.setStrumentoSblocca("piedeDiPorco");
		s.impostaStanzaAdiacente("est", sEst);
		s.impostaStanzaAdiacente("ovest", sOvest);
		s.setDirezioneBloccata("ovest");
	}
	
	
	@Test // non c'è lo strumento che sblocca
	public void testGetDescrizioneStrumentoSbagliato() {
		s.addAttrezzo(spada);
		assertNull(s.getStanzaAdiacente("ovest"));
	}
	
	@Test // non c'è lo strumento che sblocca ma non chiedo la direzione bloccata
	public void testGetDescrizioneStrumentoSbagliatoDirezioneNonBloccata() {
		s.addAttrezzo(spada);
		assertEquals("stanzaEst",s.getStanzaAdiacente("est").getNome());
	}
	
	@Test //  c'è lo strumento che illumina
	public void testGetDescrizioneStrumentoGiusto() {
		s.addAttrezzo(piedeDiPorco);
		assertEquals("stanzaOvest",s.getStanzaAdiacente("ovest").getNome());
	}
	
}
