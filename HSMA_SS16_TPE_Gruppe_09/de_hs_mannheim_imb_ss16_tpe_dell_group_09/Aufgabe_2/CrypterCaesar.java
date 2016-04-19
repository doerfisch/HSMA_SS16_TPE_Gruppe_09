package Aufgabe_2;

/**
 * @author Melissa Zindl, Sebastian Schuler Klasse CrypterCaesar zur
 *         implementierung der Caesar-Verschlüsselung
 */
public class CrypterCaesar extends CrypterBasic implements Crypter {

	// Klassenvariablen in Superklasse

	// Getter und Setter Methoden in Superklasse

	// Konstruktoren
	/**
	 * @param text:
	 *            Übergibt später zu verschölüsselnden Klartext
	 * @param key:
	 *            übergibt Schlüssel der generischen Klasse Key
	 * @throws CrypterException:
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */
	public CrypterCaesar(String text, Key<String> key) throws CrypterException {
		this.text = text;
		// Prüft, ob Schlüssel leer ist
		if (key.getKey().equals("") == true) {
			throw new CrypterException("Schlüssel darf nicht leer sein");
		} else {
			this.key = key;
			this.verschlText = "";
		}
	}

	public CrypterCaesar(String text, String key) throws CrypterException {
		this(text, new Key<String>(key.toUpperCase()));
	}

	@Override
	public char verschluesseln(char klartextZeichen) throws CrypterException {
		char hilfe = (char) (klartextZeichen + (this.getKey().getKey().charAt(ZERO) - ASCIIAT));
		while (hilfe < ASCIIA) {
			hilfe = (char) (hilfe + (ASCIIZ - ASCIIAT));
		}
		while (hilfe > ASCIIZ) {
			hilfe = (char) (hilfe - (ASCIIZ - ASCIIAT));
		}
		return hilfe;
	}

	@Override
	public char entschluesseln(char cypherTextZeichen) throws CrypterException {
		char hilfe = (char) (cypherTextZeichen - (this.key.getKey().charAt(ZERO) - ASCIIAT));
		while (hilfe < ASCIIA) {
			hilfe = (char) (hilfe + (ASCIIZ - ASCIIAT));
		}
		while (hilfe > ASCIIZ) {
			hilfe = (char) (hilfe - (ASCIIZ - ASCIIAT));
		}
		return hilfe;
	}

}
