package it.uniroma3.diadia.ambienti;

import java.util.Iterator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza {

	private String strumentoSblocca;

	public StanzaBuia(String nome,String strumentoPerVedere) {
		super(nome);
		this.strumentoSblocca = strumentoPerVedere;
	}

	public String getStrumentoSblocca() {
		return strumentoSblocca;
	}

	public void setStrumentoSblocca(String strumentoSblocca) {
		this.strumentoSblocca = strumentoSblocca;
	}

	@Override
	public String getDescrizione() {

		if (getLaStanzaSbloccata())
			return this.toString();

		String descrizione = "Qui c'è buio pesto";
		return descrizione;

	}
	

	public boolean getLaStanzaSbloccata() {

		// controllo che sia presente nella stanza lo strumento che sblocca la stanza
		Iterator<Attrezzo> it = this.getAttrezzi().iterator();

		while (it.hasNext()) {
			if (it.next().getNome().equals(this.strumentoSblocca))
				return true;
		}
		return false;
	}
		
		
	


}
