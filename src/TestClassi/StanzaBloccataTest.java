package TestClassi;
import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	//(String nome,String strumentoCheSblocca, String direzioneBloccata)
	StanzaBloccata s;
	Stanza     sEst = new Stanza("stanzaEst");
	Stanza     sOvest = new Stanza("stanzaOvest");
	
	Attrezzo piedeDiPorco;
	Attrezzo spada;
	
	@Before
	public void setUp() {//(String nome,String strumentoCheSblocca, String direzioneBloccata)
		piedeDiPorco = new Attrezzo("piedeDiPorco", 7);
		spada = new Attrezzo("spada", 20);
		s = new StanzaBloccata("Bloccata", "piedeDiPorco", "ovest");
		s.setStrumentoSblocca("piedeDiPorco");
		s.impostaStanzaAdiacente("est", sEst);
		s.impostaStanzaAdiacente("ovest", sOvest);
		s.setDirezioneBloccata("ovest");
	}
	
	
	@Test // non c'è lo strumento che sblocca
	public void testGetDescrizioneStrumentoSbagliato() {
		s.addAttrezzo(spada);
		assertEquals(s,s.getStanzaAdiacente("ovest"));
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
