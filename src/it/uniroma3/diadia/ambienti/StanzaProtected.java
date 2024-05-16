package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StanzaProtected {
	
	/**
	 * Classe StanzaProtected - una stanza in un gioco di ruolo. Una stanza e' un luogo
	 * fisico nel gioco. E' collegata ad altre stanze attraverso delle uscite. Ogni
	 * uscita e' associata ad una direzione.
	 * 
	 * Hai i campi protected e non private
	 * 
	 * @author docente di POO
	 * @see Attrezzo
	 * @version base
	 */

		
		protected String nome;
		protected ArrayList<Attrezzo> attrezzi;
		protected Map<String, Stanza> stanzeAdiacenti;

		/**
		 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
		 * 
		 * @param nome il nome della stanza
		 */
		public StanzaProtected(String nome) {
			this.nome = nome;
			this.attrezzi = new ArrayList<>();
			this.stanzeAdiacenti = new HashMap<>();
		}

		/**
		 * Imposta una stanza adiacente.
		 *
		 * @param direzione direzione in cui sara' posta la stanza adiacente.
		 * @param stanza    stanza adiacente nella direzione indicata dal primo
		 *                  parametro.
		 
		public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
			boolean aggiornato = false;
			for (int i = 0; i < this.direzioni.length; i++)
				if (direzione.equals(this.direzioni[i])) {
					this.stanzeAdiacenti[i] = stanza;
					aggiornato = true;
				}
			if (!aggiornato)
				if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
					this.direzioni[numeroStanzeAdiacenti] = direzione;
					this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
					this.numeroStanzeAdiacenti++;
				}
		}*/

		/// NEW public Stanza getStanzaAdiacente(String direzione) {
		

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
	public ArrayList<Attrezzo> getAttrezzi() {
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
		Iterator<Attrezzo> it = this.attrezzi.iterator();

		while (it.hasNext()) {
			if (it.next().getNome().equals(nomeAttrezzo)) 
				return true;
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
		Iterator<Attrezzo> it = this.attrezzi.iterator();

		while (it.hasNext()) {
			attrezzoCercato = it.next();
			if (attrezzoCercato.getNome().equals(nomeAttrezzo)) 
				return attrezzoCercato;
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

		Iterator<Attrezzo> it = this.attrezzi.iterator();

		while (it.hasNext()) {
			if (it.next().getNome().equals(attrezzoDaCancellare.getNome())) {
				it.remove();
				return true;
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
		return this.attrezzi.size();
	}

	public int getNumeroStanzeAdiacenti() {
		return this.stanzeAdiacenti.size();
	}

	void impostaStanzaAdiacente(String direzione, Stanza stanzaAdiacente) {
		this.stanzeAdiacenti.put(direzione, stanzaAdiacente);
	}


}
