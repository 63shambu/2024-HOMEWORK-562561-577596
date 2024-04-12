package it.uniroma3.diadia;
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

	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;

	
	public Partita(){
		this.labirinto = new Labirinto();
		Giocatore giocatore = new Giocatore();
		this.giocatore=giocatore;
		
		/**
	     *  le stanze le crea labirinto
	     */
		
		labirinto.creaStanze();
		this.stanzaCorrente = labirinto.getStanzaCorrente();  
		this.stanzaVincente = labirinto.getStanzaVincente();
		
		this.finita = false;
		
	}

   
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
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


	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
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
	
}