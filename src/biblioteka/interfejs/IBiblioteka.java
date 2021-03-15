package biblioteka.interfejs;

import java.util.LinkedList;

/**
 * 
 *  Interfejs koji predstavlja biblioteku
 *  
 *  @author Jovan Saponjic
 *  
 *  */

import biblioteka.Autor;
import biblioteka.Knjiga;

public interface IBiblioteka {
	
	
	/**
	 * Dodaje novu knjigu u biblioteku
	 * 
	 * @param knjia Knjiga koja se dodaje u listu
	 * 
	 * @throws java.lang.NullPointerException ako je uneta knjiga null
	 * @throws java.lang.RuntimeException ako untea knjiga vec postoji u biblioteci
	 *  */
	
	public void dodajKnjigu(Knjiga knjiga);
	public void obrisiKnjigu(Knjiga knjiga);
	public LinkedList<Knjiga> vratiSveKnjige();
	public LinkedList<Knjiga> pronadjiKnjigu(
			Autor autor,
			String isbn,
			String naslov,
			String izdavaz);
}
