package Aufgabe_2;

public class CrypterXOR implements Crypter {

	private String text;
	private Key key;
	private String verschlText;
	final int AlphaLaenge = 26;
	final int ASCIIAT = 64;
	final int ASCIIA = 65;
	final int ASCIIZ = 90;
	final int ASCII_ = 95;
	
	public CrypterXOR(String text, Key key) {
		String superkey = "";
		this.text = text;
		if (key.getKey().length() < AlphaLaenge) {
			System.out.println(superkey.length());
			superkey = key.getKey() + key.getKey();
			while (superkey.length() < AlphaLaenge) {
				superkey = superkey + key.getKey();
			}
		}
		if (superkey.isEmpty() == true) {
			this.key = key;
		} else {
			this.key = new Key(superkey);
		}
	}

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

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		verschlText = "";

	}

	public String verschluesselText() {
		for (int i = 0; i < this.getText().length(); i++) {
			char hilfe = text.charAt(i);
			System.out.println("Hier verschlüsseltext");
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
		System.out.println("Hier verschlüsseln");
		int arrayIndex = klartextZeichen - ASCIIA;
		int subWert = this.getKey().getKey().charAt(arrayIndex);
		char hilfe = (char) (klartextZeichen ^ subWert);
		hilfe = (char) (hilfe + ASCIIAT);
		return hilfe;
	}

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
	public char entschluesseln(char cypherTextZeichen) throws CrypterException {
		// TODO Auto-generated method stub
		int arrayIndex = cypherTextZeichen-ASCIIAT;
		int subWert = this.getKey().getKey().charAt(arrayIndex);
		System.out.println(arrayIndex + " bla " + subWert );
		char hilfe = (char) (arrayIndex ^ subWert);
		hilfe = (char) (hilfe + ASCIIA);
		return hilfe;
	}

	public static void main(String[] args) {
		CrypterXOR c1 = new CrypterXOR("ABISZ", new Key("TPERULES"));
		c1.verschluesselText();
		System.out.println(c1.verschlText);
		CrypterXOR c2 = new CrypterXOR("UR]VJ", new Key("TPERULES"));
		c1.reset();
		c2.entschluesselText();
		System.out.println(c2.verschlText);

	}

}
