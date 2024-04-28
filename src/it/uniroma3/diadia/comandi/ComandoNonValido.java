package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getConsole().mostraMessaggio("Comando non valido, scrivi aiuto per saper i comandi validi");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
