package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;

public abstract class IBibliotekaTest {
	
	
	protected IBiblioteka biblioteka;

	@Test
	void testDodajKnjigu() {
		Knjiga k = new Knjiga();
		k.setNaslov("Knjiga 1");
		
		biblioteka.dodajKnjigu(k);
		
		assertEquals(1, biblioteka.vratiSveKnjige().size());
		assertEquals(k, biblioteka.vratiSveKnjige().get(0));
		
	}
	
	@Test
	void testDodajKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class, () -> biblioteka.dodajKnjigu(null));
	}
	
	@Test
	void testDodajKnjiguVecPostoji() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		Knjiga k2 = new Knjiga();
		k2.setIsbn("12345");
		biblioteka.dodajKnjigu(k2);
		
		assertThrows(java.lang.RuntimeException.class, () -> biblioteka.dodajKnjigu(k2));
	}

	@Test
	void testObrisiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		
		biblioteka.dodajKnjigu(k);
		biblioteka.obrisiKnjigu(k);
		
		assertEquals(0, biblioteka.vratiSveKnjige().size());
	}
	
	@Test
	void testObrisiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class, () -> biblioteka.obrisiKnjigu(null));
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("54321");
		
		assertThrows(java.lang.RuntimeException.class, () -> biblioteka.obrisiKnjigu(k2));
	}
	
	

	@Test
	void testVratiSveKnjige() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		
		biblioteka.dodajKnjigu(k);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(1, knjige.size());
		assertEquals(k, knjige.get(0));
		
	}
	
	@Test
	void testPronadjiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn("1234");
		k.setNaslov("Knjiga o dzungli");
		Knjiga k2 = new Knjiga();
		k2.setIsbn("5678");
		k2.setNaslov("Dzungla zivota");
		Knjiga k3 = new Knjiga();
		k.setIsbn("91011");
		k3.setNaslov("Evgenije Onjegin");
		
		biblioteka.dodajKnjigu(k);
		biblioteka.dodajKnjigu(k2);
		biblioteka.dodajKnjigu(k3);
		
		List<Knjiga> knjige = biblioteka.pronadjiKnjigu(null, null, "zung", null);
		
		assertEquals(2, knjige.size());
		assertTrue(knjige.contains(k));
		assertTrue(knjige.contains(k2));
	}

	@Test
	void testPronadjiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class, () -> biblioteka.pronadjiKnjigu(null, null, null, null));
	}

}
