package biblioteka;

import java.util.LinkedList;


/** 
 * Klasa Biblioteka implementira interfejsa IBilioteka
 * 
 * @author Jovan Saponjic
 * 
 * */

import javax.management.RuntimeErrorException;

import biblioteka.interfejs.IBiblioteka;

public class Biblioteka implements IBiblioteka {
	
	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		
		if(knjiga == null) {
			throw new NullPointerException("Knjiga ne sme biti null");
		}
		
		if(knjige.contains(knjiga)) {
			throw new RuntimeException("Knjiga vec postoji u listi");
		}

		knjige.add(knjiga);

	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {

		if(knjiga == null || !knjige.contains(knjiga)) {
			throw new RuntimeException("Kniga ne sme biti null i mora posotojati u biblioteci");
		}

		knjige.remove(knjiga);

	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavaz) {
		
		if(autor == null && isbn == null && naslov == null && izdavaz == null) {
			throw new RuntimeException("Morate uneti bar jedan kriterijum pretrage");
		}
		
		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();
		
		for (Knjiga knjiga : knjige) {
			if(knjiga.getNaslov().contains(naslov)) {
				rezultat.add(knjiga);	
			}
		}
		
		return rezultat;
	}

}
