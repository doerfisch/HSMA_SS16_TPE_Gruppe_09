package Aufgabe_2;
import static org.junit.Assert.*;

import org.junit.*;

public class TestCrypterCaesar {
	
	//Erstellung eines neuen Objektes zur Prüfung der verschlüssel-Text-Methode
	@Test
	public void verschlTest() throws CrypterException{
	CrypterCaesar cc = new CrypterCaesar("ZYX", "ASD");
	assertEquals(cc.verschluesselText(), "VUT");
	}
	
	//Erstellung eines neuen Objektes zur Prüfung der entschlüssel-Text-Methode
	@Test
	public void entschlTest() throws CrypterException{
	CrypterCaesar cc2 = new CrypterCaesar("VUT", "V");
	assertEquals(cc2.entschluesselText(), "ZYX");
	}

}
