package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
 
	@Override
	public void esegui(Partita partita) {
		if (nomeAttrezzo == null) {
			partita.getConsole().mostraMessaggio("Che attrezzo vuoi posare ?");
			return;
		}

		if (!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			partita.getConsole().mostraMessaggio("Attrezzo inesistente nella borsa");
			return;
		}

		if (!partita.getGiocatore().posaAttrezzo(partita.getStanzaCorrente(), nomeAttrezzo))
			partita.getConsole().mostraMessaggio("Errore nel posare un attrezzo");
		else
			partita.getConsole().mostraMessaggio("Ho posato " + nomeAttrezzo);

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}

}
