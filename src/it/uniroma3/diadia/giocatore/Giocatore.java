package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.ambienti.Stanza;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	int cfu;
	Borsa borsa;

public Giocatore(){
	
	this.cfu=CFU_INIZIALI;
	Borsa borsa = new Borsa();
	this.borsa=borsa;
	
}

public boolean prendiAttrezzo(Stanza stanza, String nomeAttrezzo) {
	boolean ritorno= false;
	
	//Il controllo che l'attrezzo sia nella stanza l'ho fatto in DiaDia
	//controllo che l'attrezzo non sia  nella borsa
	//se i controlli sono andati metto l'attrezzo nella borsa e lo levo dalla stanza
	
	if(!borsa.hasAttrezzo(nomeAttrezzo)){
		ritorno=borsa.addAttrezzo(stanza.getAttrezzo(nomeAttrezzo));
		if (ritorno)
			ritorno=stanza.removeAttrezzo(stanza.getAttrezzo(nomeAttrezzo));
	}
	return ritorno;
}

public boolean posaAttrezzo(Stanza stanza, String nomeAttrezzo) {
	boolean ritorno= false;
	
	//controllo che l'attrezzo sia nella borsa l'ho fatto a livello DiaDia
	//controllo che l'attrezzo non sia nella stanza 
	//se i controlli sono andati metto l'attrezzo nella stanza e lo levo dalla borsa
	
	if(!stanza.hasAttrezzo(nomeAttrezzo)){
		ritorno=stanza.addAttrezzo(borsa.getAttrezzo(nomeAttrezzo));
		if (ritorno)
			ritorno=borsa.removeAttrezzo(nomeAttrezzo);
	}
	return ritorno;
}

public int getCfu() {
	return cfu;
}

public void setCfu(int cfu) {
	this.cfu = cfu;
}

public Borsa getBorsa() {
	return borsa;
}

public void setBorsa(Borsa borsa) {
	this.borsa = borsa;
}
}
