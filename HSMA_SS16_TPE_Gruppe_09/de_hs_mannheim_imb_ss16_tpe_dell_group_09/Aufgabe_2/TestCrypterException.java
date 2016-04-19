package Aufgabe_2;

import org.junit.*;

public class TestCrypterException {

	//CrypterException wird geworfen, bei Versuch einen leeren String als Schlüssel mitzugeben
	@Test(expected = CrypterException.class)
	public void testExSub() throws CrypterException {
		new CrypterSubstitution("TEST", "");
	}

	@Test(expected = CrypterException.class)
	public void testExXOR() throws CrypterException {
		new CrypterXOR("TEST", "");
	}

	@Test(expected = CrypterException.class)
	public void testExCae() throws CrypterException {
		new CrypterCaesar("TEST", "");
	}
}
