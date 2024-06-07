package it.uniroma3.diadia.test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private IO io;
	private Comando comando;
	Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		
	 	 Scanner scanner = new Scanner(System.in);
		 IO io = new IOConsole(scanner);
		 
		 labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();

		partita = new Partita(io,labirinto);
		attrezzo = new Attrezzo("moneta", 2);
		comando = new ComandoPosa();
		//io = new IOConsole(new Scanner(System.in));
		comando.setIo(io);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("moneta");
		comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("moneta"));
	}

	@Test
	public void testAttrezzoPosatoNull() {
		comando.setParametro("moneta");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("moneta"));
	}


	public void creatoreAttrezzi() {
		for(int i= 0; i<10;i++) {
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("utensile"+i, 1));
		}
	}
	
	@Test
	public void testTroppiAttrezzi() {
		this.creatoreAttrezzi();
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("moneta");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("moneta"));
	}

}
