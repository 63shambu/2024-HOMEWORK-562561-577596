package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.*;
import java.util.Comparator;

public class ComparatorePerPeso implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		// TODO Auto-generated method stub
		
		int  cmp = Integer.compare(o1.getPeso() , o2.getPeso());
	
		if (cmp==0)
			cmp = o1.getNome().compareTo(o2.getNome());	
		
		
	//	int cmp = o2.getPeso() - o1.getPeso();
	//		if (cmp==0)
	//			cmp = o1.getNome().compareTo(o2.getNome());
		return cmp;
	}

}
