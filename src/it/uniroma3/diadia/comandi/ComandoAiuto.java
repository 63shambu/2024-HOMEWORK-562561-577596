package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getConsole().mostraMessaggio("I comandi che puoi dare sono i seguenti:");
		for (int i = 0; i < partita.getElencocomandi().length; i++)
			partita.getConsole().mostraMessaggio(partita.getElencocomandi()[i] + " ");
	}
	

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
