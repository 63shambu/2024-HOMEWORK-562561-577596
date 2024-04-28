package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza {

	private String strumentoSblocca;

	public StanzaBuia(String nome) {
		super(nome);
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
		for (Attrezzo attrezzo : this.getAttrezzi()) {
			if (attrezzo == null)
				return false;
			if (attrezzo.getNome() == this.strumentoSblocca)
					return true;
			}
		return false;
		}
	


}
