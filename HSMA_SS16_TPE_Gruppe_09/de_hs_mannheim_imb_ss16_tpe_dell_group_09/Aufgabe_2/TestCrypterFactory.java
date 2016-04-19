package Aufgabe_2;
import static org.junit.Assert.*;
import org.junit.*;

public class TestCrypterFactory {

	//Erstellung von drei neuen Objekten um gefragten Schluessel aus f.) zu entschlüsseln
	@Test
	public void factoryTest() throws CrypterException{
		CrypterXOR cx = new CrypterXOR("SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_", "EINSCHLUESSEL" );
		cx.entschluesselText();
		CrypterCaesar cc = new CrypterCaesar(cx.getVerschlText(), "V");
		cc.entschluesselText();
		CrypterSubstitution cs = new CrypterSubstitution(cc.getVerschlText(), "MNBVCXYLKJHGFDSAPOIUZTREWQ");
		cs.entschluesselText();
		assertEquals(cs.getVerschlText(), "UNDXWIEDERXEINXBLATTXERLEDIGT");
	}
}
