package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		StringBuilder risultato = new StringBuilder();
		risultato.append(partita.getStanzaCorrente().getDescrizione());
		risultato.append("\n ");
		risultato.append("CFU rimanenti =  ");
		risultato.append(partita.getCfu());
		partita.getConsole().mostraMessaggio(risultato.toString());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
