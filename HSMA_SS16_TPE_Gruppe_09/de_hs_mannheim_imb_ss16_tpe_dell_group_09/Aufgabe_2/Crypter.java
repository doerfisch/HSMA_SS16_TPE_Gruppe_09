package Aufgabe_2;

/**
 * Grundlegendes Interface, um Verschl ̈usselung durchzuf ̈uhren. Mit Hilfe
 * dieses Interfaces kann man Nachrichten verschl ̈usseln ( ̈uber die
 * {@link #verschluesseln(char)} Methode) und wieder entschl ̈usseln ( ̈uber die
 * * {@link #entschluesseln(char)} Methode).
 *
 * Der Eingabetext, der Zeichenweise ̈ubergeben wird ({@literal klarTextZeichen}
 * ) * darf nur aus den Groß-Buchstaben A-Z bestehen. Kleinbuchstaben werden in
 * Großbuchstaben umgewandelt, alle anderen Zeichen f ̈uhren zu einer Ausnahme.
 * * Zwischen den beiden Methoden muss bei gleichem Schl ̈ussel folgendes
 * gelten: * {@code zeichen == decrypt(encrypt(zeichen))}.
 *
 */


public interface Crypter {
	/**
	 * Setzt die Verschl ̈usselung zur ̈uck. Diese Methode ist bei einigen
	 * Verfahren sinnvoll, bei denen eine Position im Schl ̈ussel verwaltet
	 * wird, da diese beim Wechsel von Ver- auf Entschl ̈usselung zur
	 * ̈uckgesetzt * werdem muss.
	 */
	public void reset();

	/**
	 * Verschlüsselt das gegebene Zeichen. *
	 * 
	 * @param klartextZeichen
	 *            Zeichen, das verschlüsselt werden soll. *
	 * @return verschlüsseltes Zeichen.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */
	
	
	public char verschluesseln(char klartextZeichen) throws CrypterException;

	/**
	 * Entschlüsselt das gegebenen Zeichen. *
	 * 
	 * @param cypherTextZeichen
	 *            Zeichen, das entschlüsselt werden soll.
	 *
	 * @return entschüsseltes Zeichen.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */
	public char entschluesseln(char cypherTextZeichen) throws CrypterException;
}
