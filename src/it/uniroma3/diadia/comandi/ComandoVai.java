package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.ambienti.Stanza;


public class ComandoVai implements Comando {
	
	 private String direzione;
	 //public ComandoVai(String direzione) {
	 //this.direzione = direzione;
	 //}
	 /**
	 * esecuzione del comando
	 */
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if (direzione == null) {
			partita.getConsole().mostraMessaggio("Dove vuoi andare ?");
		    return;}
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			partita.getConsole().mostraMessaggio("Direzione inesistente");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = partita.getCfu();
			partita.setCfu(cfu--);
		}
		partita.getConsole().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		
	}
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
		
	}

}

