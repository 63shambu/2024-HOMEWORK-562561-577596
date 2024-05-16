package it.uniroma3.diadia.comandi;

import java.util.Iterator;

import it.uniroma3.diadia.Partita;


public class ComandoAiuto implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.getConsole().mostraMessaggio("I comandi che puoi dare sono i seguenti:");
		
		Iterator<String> it = partita.getElencocomandi().iterator();
		while (it.hasNext()) {
			partita.getConsole().mostraMessaggio(it.next() + " ");
		}
	}
	

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
