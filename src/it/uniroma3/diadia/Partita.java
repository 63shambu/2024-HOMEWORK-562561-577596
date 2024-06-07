package it.uniroma3.diadia;
import java.util.ArrayList;


import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;


/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	
	private ArrayList<String> comandi;
	
	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;
	private IO console;


	public Partita(IO io, Labirinto labirinto) {
		this.console = io;
		this.labirinto = labirinto;
		Giocatore giocatore = new Giocatore();
		this.giocatore=giocatore;
		this.finita = false;
		
		comandi = new ArrayList<String>();
		comandi.add(new String("aiuto"));
		comandi.add(new String("fine"));
		comandi.add(new String("prendi"));
		comandi.add(new String("posa"));
		comandi.add(new String("vai"));
		comandi.add(new String("guarda"));
		
		/**
	     *  le stanze le crea labirinto
	     */
	}


	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.getLabirinto().setStanzaCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return this.getLabirinto().getStanzaCorrente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return labirinto.getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	public int getCfu() {
		return giocatore.getCfu();
	}


	public void setCfu(int i) {
		giocatore.setCfu(i);
		
	}


	public Giocatore getGiocatore() {
		return giocatore;
	}


	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}


	public void setFinita(boolean finita) {
		this.finita = finita;
	}


	public Labirinto getLabirinto() {
		return labirinto;
	}


	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}


	public IO getConsole() {
		return console;
	}


	public void setConsole(IO console) {
		this.console = console;
	}


	public boolean giocatoreIsVivo() {
		int cfu;
		cfu = getCfu();
		if (cfu == 0)
		    return false;
		return true;
	}


	public ArrayList<String> getElencocomandi() {
		return this.comandi;
	}
	
}
