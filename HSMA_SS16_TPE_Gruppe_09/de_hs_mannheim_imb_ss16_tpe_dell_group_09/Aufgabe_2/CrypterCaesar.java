package Aufgabe_2;

public class CrypterCaesar implements Crypter {

	private String text;
	private Key key;
	private String verschlText;
	final int ASCIIAT = 64;
	final int ASCIIA = 65;
	final int ASCIIZ = 90;
	final int ASCII_ = 95;

	public String getVerschlText() {
		return verschlText;
	}

	public void setVerschlText(String verschlText) {
		this.verschlText = verschlText;
	}

	public String getText() {
		return text;
	}

	public CrypterCaesar(String text, int key) {
		this.text = text;
		this.key = new Key(key);
		this.verschlText = "";
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
		char hilfe = (char) (klartextZeichen + Integer.parseInt(this.key.getKey()));
		while (hilfe < ASCIIA) {
			hilfe = (char) (hilfe + (ASCIIZ - ASCIIAT));
		}
		while (hilfe > ASCIIZ) {
			hilfe = (char) (hilfe - (ASCIIZ - ASCIIAT));
		}
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
		char hilfe = (char) (cypherTextZeichen - Integer.parseInt(this.key.getKey()));
		while (hilfe < ASCIIA) {
			hilfe = (char) (hilfe + (ASCIIZ - ASCIIAT));
		}
		while (hilfe > ASCIIZ) {
			hilfe = (char) (hilfe - (ASCIIZ - ASCIIAT));
		}
		return hilfe;
	}

	public static void main(String[] args) {
		CrypterCaesar c1 = new CrypterCaesar("JA", 3);
		c1.verschluesselText();
		System.out.println(c1.verschlText);
		CrypterCaesar c2 = new CrypterCaesar(c1.verschlText, 3);
		c1.reset();
		c2.entschluesselText();
		System.out.println(c2.verschlText);

	}
}
