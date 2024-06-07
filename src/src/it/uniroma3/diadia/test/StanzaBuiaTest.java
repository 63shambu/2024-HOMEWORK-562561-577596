package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;


	public class StanzaBuiaTest {

		private StanzaBuia stanza;
		private Attrezzo lampada;
		@Before
		public void setUp() throws Exception {

			stanza = new StanzaBuia("StanzaBuia", "lampada");
			lampada = new Attrezzo("lampada", 1);
		}
		
	

		@Test
		public void testGetDescrizioneConAttrezzo() {
			stanza.addAttrezzo(lampada);
			assertEquals(stanza.toString(), stanza.getDescrizione());
		}
		
		@Test
		public void testGetDescrizioneSenzaAttrezzo() {
			String e = "Qui c'è buio pesto";
			assertEquals(e, stanza.getDescrizione());
		}


	
	
}
