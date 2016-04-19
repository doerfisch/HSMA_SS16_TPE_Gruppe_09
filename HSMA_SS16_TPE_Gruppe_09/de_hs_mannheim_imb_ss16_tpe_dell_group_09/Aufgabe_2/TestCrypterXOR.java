package Aufgabe_2;
import static org.junit.Assert.*;
import org.junit.*;

public class TestCrypterXOR {
	
	//Erstellung eines neuen Objektes zur Prüfung der verschlüssel-Methode  
	@Test
	public void verschlTest() throws CrypterException{
		CrypterXOR c1 = new CrypterXOR("IJKLMNOPQR", "TPERULES");
		assertEquals(c1.verschluesselText(), "]ZN^XBJCEB");
		
	}
	//Erstellung eines neuen Objektes zur Prüfung der verschlüssel-Methode (Kleinbuchstaben im Key!) 
		@Test
		public void verschlTestKlein() throws CrypterException{
			CrypterXOR c1klein = new CrypterXOR("IJKLMNOPQR", "tpErUlES");
			assertEquals(c1klein.verschluesselText(), "]ZN^XBJCEB");
			
		}

	//Erstellung eines neuen Objektes zur Prüfung der entschlüssel-Methode
	@Test
	public void entschlTest() throws CrypterException{
		CrypterXOR c2 = new CrypterXOR("]ZN^XBJCEB", "TPERULES");
		assertEquals(c2.entschluesselText(), "IJKLMNOPQR");
		
	}
	
}


