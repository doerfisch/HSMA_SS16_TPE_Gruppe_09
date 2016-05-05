package Aufgabe_2;

public abstract class CrypterBasic implements Crypter {
	protected String text;
	protected Key<String> key;
	protected String verschlText;
	protected int iGlobal;
	final int ALPHALAENGE = 26;
	final int ASCIIAT = 64;
	final int ASCIIA = 65;
	final int ASCIIZ = 90;
	final int ASCII_ = 95;
	final int ZERO = 0;

	// Getter und Setter Methoden
	/**
	 * Getter Methode für den verschlüsselten Text
	 * @return verschlText
	 */
	public String getVerschlText() {
		return verschlText;
	}

	/**
	 * Setter Methode für verschlüsselten Text mit einem String
	 * @param verschlText
	 */
	public void setVerschlText(String verschlText) {
		this.verschlText = verschlText;
	}
	/**
	 * Getter Methode für den Klartext
	 * @return text
	 */
	public String getText() {
		return text;
	}
	/**
	 * Getter Methode für den Key vom Typ String
	 * @return key
	 */
	public Key<String> getKey() {
		return key;
	}
	/**
	 * Getter Methode für iGlobal
	 * @return iGlobal
	 */
	public int getIGlobal() {
		return iGlobal;
	}

	/**
	 * Setter Methode für iGlobal
	 * @param i
	 */
	public void setIGlobal(int i) {
		this.iGlobal = i;
	}
	@Override
	public void reset() {
		verschlText = "";
	}

	/**
	 * verschluesselText-Methode mit FOR-Schleife zum Durchlaufen
	 * bis Länge des zu verschluesselnden Textes erreicht.
	 * Ruft für jeden Char die Methode verschlüsseln auf und speichert 
	 * Ergebnis als String
	 * @return verschlüsselten Text als String
	 * 
	 */
	public String verschluesselText() {
		//Durchlaufen des Strings text
		for (int i = 0; i < this.getText().length(); i++) {
			char hilfe = text.charAt(i);
			try {
				//Ausführen der Methode verschluesseln mit jedem Char des Strings text
				hilfe = this.verschluesseln(hilfe);
			} catch (CrypterException e) {
				throw new RuntimeException("Fehler in der Entschlüsselung!");
			}
			verschlText = verschlText + hilfe;
		}
		return verschlText;
	}
	
	/**
	 * entschluesselText-Methode mit FOR-Schleife zum Durchlaufen
	 * bis Länge des zu entschluesselnden Textes erreicht.
	 * Ruft für jeden Char die Methode entschlüsseln auf und speichert 
	 * Ergebnis als String
	 * @return entschluesselten Text als String
	 */
	public String entschluesselText() {
		for (int i = 0; i < this.getText().length(); i++) {
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
	@Override
	public abstract char verschluesseln(char klartextZeichen) throws CrypterException; //Abstrakte Methode, wird erst später verwendet

	@Override
	public abstract char entschluesseln(char cypherTextZeichen) throws CrypterException;

}
