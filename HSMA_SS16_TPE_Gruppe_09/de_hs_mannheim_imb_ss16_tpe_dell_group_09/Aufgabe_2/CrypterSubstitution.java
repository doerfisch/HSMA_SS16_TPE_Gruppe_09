package Aufgabe_2;

/**
 * @author Melissa Zindl, Sebastian Schuler
 *
 */
public class CrypterSubstitution extends CrypterBasic implements Crypter {

	// Klassenvariablen in Superklasse

	// Getter und Setter Methoden in Superklasse

	// Konstruktor
	/**
	 * @param text: Übergibt später zu verschölüsselnden Klartext
	 * @param key: übergibt Schlüssel der generischen Klasse Key
	 * @throws CrypterException: Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *                            auftreten.
	 */
	public CrypterSubstitution(String text, Key<String> key) throws CrypterException {
		this.text = text;
		if (key.getKey().equals("") == true) {
			throw new CrypterException("Schlüssel darf nicht leer sein");
		} else {
			this.key = key;
			this.verschlText = "";
		}
	}

	public CrypterSubstitution(String text, String key) throws CrypterException {
		this(text, new Key<String>(key.toUpperCase()));
	}


	
	@Override
	public char verschluesseln(char klartextZeichen) throws CrypterException {
		int arrayIndex = klartextZeichen - ASCIIA;
		int subWert = this.getKey().getKey().charAt(arrayIndex);
		char hilfe = (char) (subWert);
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
		// char hilfe = (char) (cypherTextZeichen -
		// Integer.parseInt(this.key.getKey()));
		int subWert = 0;
		for (int i = 0; i < this.getKey().getKey().length(); i++) {
			if (cypherTextZeichen == this.getKey().getKey().charAt(i)) {
				subWert = i;
				break;
			}
		}
		char hilfe = (char) (subWert + ASCIIA);
		while (hilfe < ASCIIA) {
			hilfe = (char) (hilfe + (ASCIIZ - ASCIIAT));
		}
		while (hilfe > ASCIIZ) {
			hilfe = (char) (hilfe - (ASCIIZ - ASCIIAT));
		}
		return hilfe;
	}

	public static void main(String[] args) throws CrypterException {
		CrypterSubstitution cs1 = new CrypterSubstitution("CS", "");
		System.out.println(cs1.getKey().getKey());
	}
}
