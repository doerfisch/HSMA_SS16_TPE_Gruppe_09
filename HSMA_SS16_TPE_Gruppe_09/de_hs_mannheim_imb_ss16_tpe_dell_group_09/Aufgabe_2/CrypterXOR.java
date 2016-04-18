package Aufgabe_2;

public class CrypterXOR implements Crypter {

	//Klassenvariablen
	private String text;
	private Key key;
	private String verschlText;
	private int iGlobal;
	final int ALPHALAENGE = 26;
	final int ASCIIAT = 64;
	final int ASCIIA = 65;
	final int ASCIIZ = 90;
	final int ASCII_ = 95;
	
	//Konstruktor
	public CrypterXOR(String text, Key key) {
		String superkey = "";
		this.text = text;
		this.verschlText = "";
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
		
		if (superkey.isEmpty() == true) {
			this.key = key;
		} else {
			this.key = new Key(superkey);
		}
	}
	
	public CrypterXOR (String text, String key){
		this(text, new Key(key));
	}

	//Getter und Setter Methoden
	public String getVerschlText() {
		return verschlText;
	}

	public void setVerschlText(String verschlText) {
		this.verschlText = verschlText;
	}

	public String getText() {
		return text;
	}

	public Key getKey() {
		return key;
	}
	public int getIGlobal() {
		return iGlobal;
	}
	public void setIGlobal(int i) {
		this.iGlobal = i;
	}
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		verschlText = "";

	}

	public String verschluesselText() {
		for (int i = 0; i < this.getText().length(); i++) {
			char hilfe = text.charAt(i);
			try {
				hilfe = this.verschluesseln(hilfe);
			} catch (CrypterException e) {
				throw new RuntimeException("Fehler in der Entschlüsselung!");
			}
			verschlText = verschlText + hilfe;

		}
		return verschlText;
	}

	@Override
	public char verschluesseln(char klartextZeichen) throws CrypterException {
		// TODO Auto-generated method stub
		int arrayIndex = klartextZeichen - ASCIIA;
		int subWert = this.getKey().getKey().charAt(arrayIndex);
		klartextZeichen = (char)( klartextZeichen - ASCIIAT );
		subWert = (char)( subWert - ASCIIAT);
		char hilfe = (char) (klartextZeichen ^ subWert);
		hilfe = (char) (hilfe + ASCIIAT);
		return hilfe;
	}

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

	@Override
	public char entschluesseln(char cypherTextZeichen) throws CrypterException {
		// TODO Auto-generated method stub
		int arrayIndex = this.getIGlobal();
		char zurueck = (char)(cypherTextZeichen - ASCIIAT ^ (this.getKey().getKey().charAt(arrayIndex) - ASCIIAT));
		zurueck = (char)(zurueck + ASCIIAT);
		return zurueck;
	}

	public static void main(String[] args) {
		CrypterXOR c1 = new CrypterXOR("IJKLMNOPQR", new Key("TPERULES"));
		c1.verschluesselText();
		System.out.println(c1.verschlText);
		CrypterXOR c2 = new CrypterXOR("]ZN^XBJCEB", new Key("TPERULES"));
		c1.reset();
		c2.entschluesselText();
		System.out.println(c2.verschlText);

	}

}
