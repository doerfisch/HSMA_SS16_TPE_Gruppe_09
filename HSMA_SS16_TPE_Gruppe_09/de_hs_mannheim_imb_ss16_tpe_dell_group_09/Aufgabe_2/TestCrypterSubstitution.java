package Aufgabe_2;
import static org.junit.Assert.*;
import org.junit.*;

public class TestCrypterSubstitution{
	//Erstellung eines neuen Objektes zur Prüfung der verschl-Text-Methode
	@Test
	public void verschlTest() throws CrypterException{
		CrypterSubstitution c1 = new CrypterSubstitution("WIKIPEDIAISTINFORMATIV", "UFLPWDRASJMCONQYBVTEXHZKGI");
		assertEquals(c1.verschluesselText(), "ZSMSYWPSUSTESNDQVOUESH");
	}
	
	//Erstellung eines neuen Objektes zur Prüfung der entschl-Text-Methode
	@Test
	public void entschl() throws CrypterException{
		CrypterSubstitution c12 = new CrypterSubstitution("ZSMSYWPSUSTESNDQVOUESH", "UFLPWDRASJMCONQYBVTEXHZKGI");
		assertEquals(c12.entschluesselText(), "WIKIPEDIAISTINFORMATIV");
	}
	
}

