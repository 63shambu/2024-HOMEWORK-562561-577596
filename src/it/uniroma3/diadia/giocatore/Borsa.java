package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.*;
import java.util.Arrays;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private Attrezzo[] attrezziComo;
	private int numeroAttrezzi;

	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.attrezziComo = new Attrezzo[10];
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi == 10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo==null)
				return attrezzoCercato;
			if (attrezzo.getNome().equals(nomeAttrezzo)) {
				attrezzoCercato = attrezzo;
				return attrezzoCercato;}
		}
		return attrezzoCercato;	
	}


	public int getPeso() {
		int peso = 0;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public boolean removeAttrezzo(String nomeAttrezzo) {

		// pulisco l'array di comodo
		Arrays.fill(attrezziComo, null);
		int j = 0;
		// sposto tutti gli attrezzi eccetto quello da rimuovere nell'array di comodo
		// poi risposto quello di comodo nell'originale

		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null) {
				if (!attrezzo.getNome().equals(nomeAttrezzo)) {
					this.attrezziComo[j] = attrezzo;
					j++;
				}
			}
		}
		this.attrezzi = this.attrezziComo;
		this.numeroAttrezzi--;
		return true;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (int i = 0; i < this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString() + " ");
		} else
			s.append("Borsa vuota");
		return s.toString();
	}
}
