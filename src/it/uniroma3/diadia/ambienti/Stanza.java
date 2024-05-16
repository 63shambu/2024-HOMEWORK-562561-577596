package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Classe Stanza - una stanza in un gioco di ruolo. Una stanza e' un luogo
 * fisico nel gioco. E' collegata ad altre stanze attraverso delle uscite. Ogni
 * uscita e' associata ad una direzione.
 * 
 * @author docente di POO
 * @see Attrezzo
 * @version base
 */

public class Stanza  {

	// static final private int NUMERO_MASSIMO_DIREZIONI = 4;

	private String nome;
	// private ArrayList<Attrezzo> attrezzi;
	private HashSet<Attrezzo> attrezzi;
	private Map<String, Stanza> stanzeAdiacenti;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * 
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.attrezzi = new HashSet<>();
		this.stanzeAdiacenti = new HashMap<>();

		// this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
		// this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];

	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * 
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la nome della stanza.
	 * 
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * 
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * 
	 * @return la collezione di attrezzi nella stanza.
	 */
	public HashSet<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * 
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti. Se esiste
	 *         già un attrezzo con lo stesso nome non lo faccio inserire (lo
	 *         controllo col metodo hasAttrezzo
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.add(attrezzo);

	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza, stampadone la
	 * descrizione, le uscite e gli eventuali attrezzi contenuti
	 * 
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("Stanza attuale: " + this.nome);

		risultato.append("\nUscite: ");
		Set<String> direz = new HashSet<>();
		direz = this.stanzeAdiacenti.keySet();
		Iterator<String> it = direz.iterator();
		while (it.hasNext()) {
			risultato.append(" " + it.next());
		}

		risultato.append("\nAttrezzi nella stanza: ");
		Iterator<Attrezzo> it1 = this.attrezzi.iterator();

		while (it1.hasNext()) {
			risultato.append(it1.next().toString() + " ");
		}

		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * 
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {

		if (this.attrezzi != null) {
			Iterator<Attrezzo> it = this.attrezzi.iterator();
			while (it.hasNext()) {
				if (it.next().getNome().equals(nomeAttrezzo))
					return true;
			}
		}
		return false;

	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * 
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza. null se l'attrezzo non e' presente.
	 */
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

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * 
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzoDaCancellare) {

		if (this.attrezzi != null) {
			Iterator<Attrezzo> it = this.attrezzi.iterator();
			while (it.hasNext()) {
				if (it.next().getNome().equals(attrezzoDaCancellare.getNome())) {
					it.remove();
					return true;
				}
			}
		}
		return false;
	}

	public Set<String> getDirezioni() {
		Set<String> direzioni = new HashSet<>();
		direzioni = this.stanzeAdiacenti.keySet();
		return direzioni;
	}

	public int getNumeroMassimoAttrezzi() {
		int rit = 0;
		if (this.attrezzi != null) {
			rit = this.attrezzi.size();
		}
		return rit;
	}

	public int getNumeroStanzeAdiacenti() {
		int rit = 0;
		if (this.stanzeAdiacenti != null) {
			rit = this.stanzeAdiacenti.size();
		}
		return rit;
	}

	public void impostaStanzaAdiacente(String direzione, Stanza stanzaAdiacente) {
		this.stanzeAdiacenti.put(direzione, stanzaAdiacente);
	}

	public Map<String, Stanza> getMapStanzeAdiacenti() {
		return stanzeAdiacenti;
	}

	public void setStanzeAdiacenti(Map<String, Stanza> stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}

}