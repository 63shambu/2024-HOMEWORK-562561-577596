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

	public DiaDia(IO io) {

		this.console = (IOConsole) io;
		this.partita = new Partita(this.console);
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

	
	/**
	 * Stampa informazioni di aiuto.
	
	private void aiuto() {
		console.mostraMessaggio("I comandi che puoi dare sono i seguenti:");
		for (int i = 0; i < elencoComandi.length; i++)
			console.mostraMessaggio(elencoComandi[i] + " ");
	}
 */
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa il
	 * nome, altrimenti stampa un messaggio di errore
	 
	private void vai(String direzione) {
		if (direzione == null)
			console.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu--);
		}
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());

	}*/

	/**
	 * Prende un attrezzo dalla stanza e lo mette in borsa, altrimenti stampa un
	 * messaggio di errore
	 
	private void prendi(String nomeAttrezzo) {
		if (nomeAttrezzo == null) {
			console.mostraMessaggio("Che attrezzo vuoi prendere ?");
			return;
		}
		if (!this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			console.mostraMessaggio("Attrezzo inesistente nella stanza");
			return;
		}
		if (!this.partita.getGiocatore().prendiAttrezzo(partita.getStanzaCorrente(), nomeAttrezzo))
			console.mostraMessaggio("Errore nel prendere un attrezzo");
		else
			console.mostraMessaggio("Ho preso " + nomeAttrezzo);
	}
*/
	/**
	 * Posa un attrezzo dalla borsa e lo mette nella stanza corrente altrimenti
	 * stampa un messaggio di errore
	
	private void posa(String nomeAttrezzo) {
		if (nomeAttrezzo == null) {
			console.mostraMessaggio("Che attrezzo vuoi posare ?");
			return;
		}

		if (!this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			console.mostraMessaggio("Attrezzo inesistente nella borsa");
			return;
		}

		if (!this.partita.getGiocatore().posaAttrezzo(partita.getStanzaCorrente(), nomeAttrezzo))
			console.mostraMessaggio("Errore nel posare un attrezzo");
		else
			console.mostraMessaggio("Ho posato " + nomeAttrezzo);
	} */

	/**
	 * Comando "Fine".
	
	private void fine() {
		console.mostraMessaggio("Grazie di aver giocato!"); // si desidera smettere
	}
 */
	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		// DiaDia gioco = new DiaDia();
		gioco.gioca();
	}

	
}