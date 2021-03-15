package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {
	
	Autor a;

	@BeforeEach
	void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		
		a = null;
		
	}

	@Test
	void testAutor() {
		a = new Autor();
		
		assertNotNull(a);
	}

	@Test
	void testAutorStringString() {
		a = new Autor("Mika", "Mikic");
		assertNotNull(a);
		assertEquals("Mika", a.getIme());
		assertEquals("Mikic", a.getPrezime());
	}

	@Test
	void testSetIme() {
		
		
		a.setIme("Pera");
		
		assertEquals("Pera", a.getIme());
	}
	
	@Test
	void testSetImeNull() {
		
		assertThrows(java.lang.NullPointerException.class, () -> a.setIme(null));
	}
	
	@Test
	void testSetImeKratakString() {
		
		assertThrows(java.lang.RuntimeException.class, () -> a.setIme("P"));
	}

	@Test
	void testSetPrezime() {
		a.setPrezime("Peric");
		
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, () -> a.setPrezime(null));
	}
	
	@Test
	void testSetPrezimeKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setPrezime("P"));
	}

	@Test
	void testToString() {
		a.setIme("Zika");
		a.setPrezime("Zikic");
		
		String s = a.toString();
		
		assertTrue(s.contains("Zika"));
		assertTrue(s.contains("Zikic"));
		
	}

	@ParameterizedTest
	@CsvSource({
		"Pera, Peric, Pera, Peric, true",
		"Pera, Zikic, Pera, Peric, false",
		"Pera, Peric, Zika, Peric, false",
		"Zika, Peric, Pera, Zikic, false",
	})
	void testEqualsObject(String ime1, String prezime1, String ime2, String prezime2, boolean eq) {
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor b = new Autor(ime2, prezime2);
		
		assertEquals(eq, a.equals(b));
		
	}

}
