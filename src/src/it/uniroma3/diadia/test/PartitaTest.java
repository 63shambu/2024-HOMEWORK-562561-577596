package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;



public class PartitaTest {

	private Partita partita;
	private IO io;
	Labirinto labirinto;
	Stanza s;

	@Before
	public void setUp() throws Exception {

		Scanner scanner = new Scanner(System.in);
		IO io = new IOConsole(scanner);

		labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();

		partita = new Partita(io,labirinto);
		s = new Stanza("Stanza");
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", partita.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		partita.getLabirinto().setStanzaCorrente(s);
		assertEquals(s, partita.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {

		assertFalse(partita.isFinita());
	}

}
