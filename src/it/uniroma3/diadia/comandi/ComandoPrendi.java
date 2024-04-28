package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		if (nomeAttrezzo == null) {
			partita.getConsole().mostraMessaggio("Che attrezzo vuoi prendere ?");
			return;
		}
		if (!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			partita.getConsole().mostraMessaggio("Attrezzo inesistente nella stanza");
			return;
		}
		if (!partita.getGiocatore().prendiAttrezzo(partita.getStanzaCorrente(), nomeAttrezzo))
			partita.getConsole().mostraMessaggio("Errore nel prendere un attrezzo");
		else
			partita.getConsole().mostraMessaggio("Ho preso " + nomeAttrezzo);

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}

}
