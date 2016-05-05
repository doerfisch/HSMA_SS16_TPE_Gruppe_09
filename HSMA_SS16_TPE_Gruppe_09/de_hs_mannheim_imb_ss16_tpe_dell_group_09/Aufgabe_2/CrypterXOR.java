package Aufgabe_2;

/**
 * @author Melissa Zindl, Sebastian Schuler
 *
 */
public class CrypterXOR extends CrypterBasic implements Crypter {

	// Klassenvariablen in Superklasse

	// Konstruktor wird überschrieben
	/**
	 * @param text:
	 *            Übergibt später zu verschlüsselnden Klartext
	 * @param key:
	 *            übergibt Schlüssel der generischen Klasse Key
	 * @throws CrypterException:
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */
	public CrypterXOR(String text, Key<String> key) throws CrypterException {
		this.text = text;
		if (key.getKey().equals("") == true) {
			throw new CrypterException("Schlüssel darf nicht leer sein");
		} else {
			String superkey = "";
			this.verschlText = "";
			// Anpassung des Schlüsseltexts.
			// Der Schlüssel muss mindestens so lang sein wie das Alphabet und
			// der Klartext
			if (text.length() > ALPHALAENGE) {
				if (key.getKey().length() < text.length()) {
					superkey = key.getKey() + key.getKey();
					while (superkey.length() < text.length()) {
						superkey = superkey + key.getKey();
					}
				}
			} else {
				if (key.getKey().length() <= ALPHALAENGE) {
					superkey = key.getKey() + key.getKey();
					while (superkey.length() < ALPHALAENGE) {
						superkey = superkey + key.getKey();
					}
				}
			}
			// Wenn kein superkey existiert, dann ist der ursprüngliche key
			// ausreichend
			if (superkey.isEmpty() == true) {
				this.key = key;
			} else {
				this.key = new Key<String>(superkey);
			}
		}
	}

	/**
	 * @param text:
	 *            Zu verschlüsselnder Text
	 * @param key:
	 *            key generisch, Benutzung als String
	 * @throws CrypterException
	 */
	public CrypterXOR(String text, String key) throws CrypterException {
		this(text, new Key<String>(key.toUpperCase()));
	}

	// Getter und Setter Methoden in Superklasse


	// verschlüsseln des Characters
	//
	@Override
	public char verschluesseln(char klartextZeichen) throws CrypterException {
		int arrayIndex = klartextZeichen - ASCIIA;
		int subWert = this.getKey().getKey().charAt(arrayIndex);
		klartextZeichen = (char) (klartextZeichen - ASCIIAT);
		subWert = (char) (subWert - ASCIIAT);
		char hilfe = (char) (klartextZeichen ^ subWert);
		hilfe = (char) (hilfe + ASCIIAT);

		// Überprüfung ob hilfe-char kleiner als ASCII-Wert 64 (@) und Anpassung
		while (hilfe < ASCIIAT) {
			hilfe = (char) (hilfe + (ASCII_ - ASCIIAT));
		}
		// Überprüfung ob hilfe größer als ASCII-Wert 95 (_) und Anpassung
		while (hilfe > ASCII_) {
			hilfe = (char) (hilfe - (ASCII_ - ASCIIAT));
		} 
		return hilfe;
	}

	/**
	 * entschluesselText-Methode mit FOR-Schleife zum Durchlaufen bis Länge des
	 * zu entschluesselnden Textes erreicht. Ruft für jeden Char die Methode
	 * entschlüsseln auf und speichert Ergebnis als String
	 * Zusätzlich wird das Feld IGlobal gefüllt, das die Position im String angibt
	 * @return entschluesselten Text als String
	 */
	@Override
	public String entschluesselText() {
		for (int i = 0; i < this.getText().length(); i++) {
			this.setIGlobal(i);
			char hilfe = text.charAt(i);

			try {
				hilfe = this.entschluesseln(hilfe);
			} catch (CrypterException e) {
				throw new RuntimeException("Fehler in der Entschlüsselung!");
			}
			verschlText = verschlText + hilfe;
		}
		return verschlText;
	}

	//
	@Override
	public char entschluesseln(char cypherTextZeichen) throws CrypterException {
		// Weist arrayIndex den aktuellen IGlobal-Wert zu, um Position des
		// Buchstabens im Text zu ermitteln
		int arrayIndex = this.getIGlobal();
		char zurueck = (char) (cypherTextZeichen - ASCIIAT ^ (this.getKey().getKey().charAt(arrayIndex) - ASCIIAT));
		zurueck = (char) (zurueck + ASCIIAT);

		// Überprüfung ob zurueck-char kleiner als ASCII-Wert 64 (@) und
		// Anpassung
		while (zurueck < ASCIIAT) {
			zurueck = (char) (zurueck + (ASCII_ - ASCIIAT));
		}
		// Überprüfung ob zurueck größer als ASCII-Wert 95 (_) und Anpassung
		while (zurueck > ASCII_) {
			zurueck = (char) (zurueck - (ASCII_ - ASCIIAT));
		}
		return zurueck;
	}

}
