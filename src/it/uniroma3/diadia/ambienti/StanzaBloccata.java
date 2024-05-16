package it.uniroma3.diadia.ambienti;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {

	private String strumentoSblocca;
	private String direzioneBloccata;

	public StanzaBloccata(String nome, String direzioneBloccata,String strumentoCheSblocca) {
		super(nome);
		this.strumentoSblocca = strumentoCheSblocca;
		this.direzioneBloccata = direzioneBloccata;
	}

	public String getStrumentoSblocca() {
		return strumentoSblocca;
	}

	public void setStrumentoSblocca(String strumentoSblocca) {
		this.strumentoSblocca = strumentoSblocca;
	}

	public String getDirezioneBloccata() {
		return direzioneBloccata;
	}

	public void setDirezioneBloccata(String direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}

	public boolean getSbloccataLaDirezione() {

		// controllo che sia presente lo strumento che sblocca la stanza
		
		Iterator<Attrezzo> it = this.getAttrezzi().iterator();

		while (it.hasNext()) {
			if (it.next().getNome().equals(this.strumentoSblocca))
				return true;
		}
		return false;

	}

	@Override
	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * 
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		
		// direzione bloccata e non c'è lo strumento sbloccante nella stanza restituisco
		// lei stessa
		if ((this.direzioneBloccata == direzione) && (!getSbloccataLaDirezione()))
			return this;

		return super.getStanzaAdiacente(direzione);
	}
	
	

	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("Stanza attuale: " + this.getNome());
		
		risultato.append("\nUscite: ");
		
		Set<String> direz = new HashSet<>();
		String direzione;
		direz = this.getDirezioni();
		Iterator<String> it = direz.iterator(); 
		while (it.hasNext()) {
			direzione = it.next();
			// se la direzione non è bloccata OR la direzione è sbloccata - faccio vedere la direzione
			if ((direzione != this.getDirezioneBloccata()) || (this.getSbloccataLaDirezione()))
				risultato.append(" " + direzione);
		}		
		
		risultato.append("\nAttrezzi nella stanza: ");
		Iterator<Attrezzo> it1 = this.getAttrezzi().iterator();
		while (it1.hasNext()) {
			risultato.append(it1.next().toString() + " ");
		}

		risultato.append("\nAttrezzo sbloccante della stanza: " + this.getStrumentoSblocca());
		return risultato.toString();
	}
}
