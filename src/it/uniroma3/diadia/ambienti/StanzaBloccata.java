package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {

	private String strumentoSblocca;
	private String direzioneBloccata;
	
	public StanzaBloccata (String nome) {
		super(nome);
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
		
	for (Attrezzo attrezzo : this.getAttrezzi()) {
		if (attrezzo == null)
			return false;
		if (attrezzo.getNome() == this.strumentoSblocca)
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
		Stanza stanza = null;
		// direzione bloccata e non c'è lo strumento sbloccante nella stanza
		if ((this.direzioneBloccata == direzione) && (!getSbloccataLaDirezione())) 
			return stanza;
		
		for (int i = 0; i < this.getNumeroStanzeAdiacenti(); i++)
			if (this.getDirezioni()[i].equals(direzione))
				stanza = super.getStanzaAdiacente(direzione);
		return stanza;
	}
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("Stanza attuale: " + this.getNome());
		risultato.append("\nUscite: ");
		
		for (String direzione : this.getDirezioni()) {
			if (direzione != null) {
				if ((direzione == this.getDirezioneBloccata()) && (this.getSbloccataLaDirezione()))
					risultato.append(" " + direzione);
			}
		}
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.getAttrezzi()) {
			if (attrezzo != null)
				risultato.append(attrezzo.toString() + " ");
		}
		risultato.append("\nAttrezzo sbloccante della stanza: " + this.getStrumentoSblocca());
		return risultato.toString();
	}
}
