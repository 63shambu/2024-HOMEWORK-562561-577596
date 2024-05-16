package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Borsa {

	private int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;

	private int pesoMax;

	public Borsa() {
		this.attrezzi = new ArrayList<Attrezzo>();
		this.DEFAULT_PESO_MAX_BORSA = 10;
	}

	public Borsa(int pesoMax) {
		this.attrezzi = new ArrayList<Attrezzo>();
		this.pesoMax = pesoMax;
		this.DEFAULT_PESO_MAX_BORSA = 10;
		// this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if ((this.getPeso() + attrezzo.getPeso()) > this.DEFAULT_PESO_MAX_BORSA) {
			return false;
		} else {
			return this.attrezzi.add(attrezzo);
		}

	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if (this.attrezzi != null) {
			Iterator<Attrezzo> it = this.attrezzi.iterator();
			while (it.hasNext()) {
				attrezzoCercato = it.next();
				if (attrezzoCercato.getNome().equals(nomeAttrezzo))
					return attrezzoCercato;
			}
		}
		return attrezzoCercato;
	}

	public int getPeso() {
		int peso = 0;
		// controllo che ci sia almeno un elemento nella borsa
		if (this.attrezzi != null) {
			Iterator<Attrezzo> it = this.attrezzi.iterator();
			while (it.hasNext()) {
				peso += it.next().getPeso();
			}
		}
		return peso;
	}

	public boolean isEmpty() {
		return attrezzi.size() == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {

		// controllo che ci sia almeno un elemento nella borsa
		if (this.attrezzi != null) {
			Iterator<Attrezzo> it = this.attrezzi.iterator();
			while (it.hasNext()) {
				if (it.next().getNome().equals(nomeAttrezzo)) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean removeAttrezzo(String nomeAttrezzo) {

		// controllo che ci sia almeno un elemento nella borsa
		if (this.attrezzi != null) {
			Iterator<Attrezzo> it = this.attrezzi.iterator();
			while (it.hasNext()) {
				if (it.next().getNome().equals(nomeAttrezzo)) {
					it.remove();
					return true;
				}
			}
		}
		return false;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		// Iterator<Attrezzo> it = this.attrezzi.iterator();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			if (this.attrezzi.size() == 0)
				s.append("Borsa vuota");
			else {
				Iterator<Attrezzo> it = this.getContenutoOrdinatoPerPeso().iterator();
				while (it.hasNext()) {
				}
			}
		}
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		final List<Attrezzo> ordinata = new ArrayList<>(this.attrezzi);
		final ComparatorePerPeso cmp = new ComparatorePerPeso();
		Collections.sort(ordinata, cmp);
		return ordinata;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		final SortedSet<Attrezzo> ordinata = new TreeSet<>(this.attrezzi);

		return ordinata;
	}

	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> peso2attrezzi = new HashMap<>();
		for (Attrezzo attrezzo : this.attrezzi) {
			if (peso2attrezzi.containsKey(attrezzo.getPeso())) {
				// questo attrezzo ha un peso gia visto
				// pesco il vecchio Set con lo stesso peso e aggiungo il nuovo arrivato
				final Set<Attrezzo> stessoPeso = peso2attrezzi.get(attrezzo.getPeso());
				stessoPeso.add(attrezzo);
				// non serve la put
			} else {
				// questo attrezzo ha un peso non visto
				// creo un nuovo Set per ospitare tutti gli attrezzi correnti e futuri con
				// questo peso
				final Set<Attrezzo> nuovoSet = new HashSet<Attrezzo>();
				nuovoSet.add(attrezzo);
				peso2attrezzi.put(attrezzo.getPeso(), nuovoSet);

			}

		}
		return peso2attrezzi;

	}

	public int getDEFAULT_PESO_MAX_BORSA() {
		return DEFAULT_PESO_MAX_BORSA;
	}

	public void setDEFAULT_PESO_MAX_BORSA(int dEFAULT_PESO_MAX_BORSA) {
		this.DEFAULT_PESO_MAX_BORSA = dEFAULT_PESO_MAX_BORSA;
	}
}
