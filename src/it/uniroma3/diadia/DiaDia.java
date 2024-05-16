package it.uniroma3.diadia;
import it.uniroma3.diadia.comandi.*;
import java.util.Scanner;
import it.uniroma3.diadia.ambienti.*;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * 
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	

	private Partita partita;
	private IOConsole console;

	public DiaDia(IO io, Labirinto labirinto) {

		this.console = (IOConsole) io;
		this.partita = new Partita(io, labirinto);
		
	}

	public void gioca() {
		String istruzione;
		Scanner scannerDiLinee;

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);

		do
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione));
	}

	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {

		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			console.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			console.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();

	}


	public static void main(String[] argc) {
		IO console = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("moneta", 3)
				.addStanza("N11")
				.addStanza("N18")
				.addStanza("N13")
				.addStanza("N15") 
				.addAttrezzo("Lampada", 4)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Atrio", "N11", "sud")
				.addAdiacenza("N11","Atrio","nord")
				.addAdiacenza("Atrio", "N13", "est")
				.addAdiacenza("N13", "Atrio", "ovest")
				.addAdiacenza("N13", "N15", "ovest")
				.addAdiacenza("N15", "N13", "est")
				
				.getLabirinto();
		DiaDia gioco = new DiaDia(console, labirinto);
		gioco.gioca();
	}

	
}