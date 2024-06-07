package it.uniroma3.diadia.test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class BorsaTest {
	Borsa b = new Borsa();
	Borsa b1 = new Borsa();
	Attrezzo moneta;
	Attrezzo spada;
	Attrezzo Piombo;
	Attrezzo Ps;
	Attrezzo Piuma;
	Attrezzo Libro;
	Attrezzo Libro1;
	Attrezzo Piuma2;
	 
	@Before
	public void setUp() {
		moneta = new Attrezzo("moneta", 7);
		spada = new Attrezzo("spada", 20);
		Piombo = new Attrezzo("Piombo", 10);
		Ps = new Attrezzo("Ps", 5);
		Piuma = new Attrezzo("Piuma", 1);
		Libro = new Attrezzo("Libro", 5);
		Libro1 = new Attrezzo("Tomo", 5);
		Piuma2 = new Attrezzo("Piuma", 2);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(moneta));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(spada));

	}

	@Test
	public void testGetPeso() {
		b.addAttrezzo(moneta);
		assertEquals(moneta, b.getAttrezzo("moneta"));

	}
	
	@Test 
	public void rimuoviAttrezzo() {
		b.removeAttrezzo("moneta");
		assertFalse(b.equals(b.getAttrezzo("moneta")));
	
	}

	//piombo:10, ps:5, piuma:1, libro:5
		
	@Test
	public void testSortPeso() {
		
	b.setDEFAULT_PESO_MAX_BORSA(30);	
	
	assertTrue(b.addAttrezzo(Piombo));
	assertTrue(b.addAttrezzo(Ps));
	assertTrue(b.addAttrezzo(Piuma));
	assertTrue(b.addAttrezzo(Piuma2));
	assertTrue(b.addAttrezzo(Libro));
	assertEquals(5,b.getNumeroAttrezzi());
		
	List<Attrezzo> l = new LinkedList<>();
	l = b.getContenutoOrdinatoPerPeso();
	
   
	assertEquals(Piuma.getNome(), l.get(0).getNome());
	assertEquals(Libro.getNome(), l.get(1).getNome());
	
	}
	
	@Test
	public void testSortPesoUgualeNomeDiverso() {
		
	b.setDEFAULT_PESO_MAX_BORSA(30);
	
	
	b.addAttrezzo(Libro1);
	b.addAttrezzo(Libro);
		
	List<Attrezzo> l2 = new LinkedList<>();
	l2 = b.getContenutoOrdinatoPerPeso();
	
	assertEquals(Libro.getNome(), l2.get(0).getNome());
	assertEquals(Libro1.getNome(), l2.get(1).getNome());
		
	}
	
	@Test
	public void testSortNome() {
		
	b1.setDEFAULT_PESO_MAX_BORSA(30);	
	b1.addAttrezzo(Piombo);
	b1.addAttrezzo(Ps);
	b1.addAttrezzo(Piuma);
	b1.addAttrezzo(Libro);
	b1.addAttrezzo(Piuma2);
		
	Set<Attrezzo> s1 = new TreeSet<Attrezzo>();
	
	s1 = b1.getContenutoOrdinatoPerNome();
	
//	assertEquals(5,s1.size());
	Iterator<Attrezzo> it = s1.iterator();
	assertTrue(it.hasNext());
	assertEquals(Libro.getNome(), it.next().getNome());
	assertTrue(it.hasNext());
	assertEquals(Piombo.getNome() ,it.next().getNome());
 		
	}
	
	@Test
	public void testHashMap() {
		
	b.setDEFAULT_PESO_MAX_BORSA(30);	
	b.addAttrezzo(Piombo);
	b.addAttrezzo(Ps);
	b.addAttrezzo(Piuma);
	b.addAttrezzo(Libro);
	b.addAttrezzo(Libro1);
	b.addAttrezzo(Piuma2);
		
	Map<Integer, Set<Attrezzo>> peso2attrezzi = new HashMap<>();
	Set<Attrezzo> s1 = new TreeSet<Attrezzo>();
	peso2attrezzi= b.getContenutoRaggruppatoPerPeso();
	
	s1 = peso2attrezzi.get(5);
	Iterator<Attrezzo> it = s1.iterator();
	assertEquals(3,s1.size());
	assertTrue(it.hasNext());
	assertEquals(Libro.getNome(), it.next().getNome());
	assertTrue(it.hasNext());
	assertEquals(Ps.getNome(), it.next().getNome());
	assertTrue(it.hasNext());
	assertEquals(Libro1.getNome(), it.next().getNome());


	}
	
	
}
