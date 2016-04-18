package Aufgabe_2;

public class CrypterCaesar implements Crypter {

	//Klassenvariablen
	private String text;
	private Key key;
	private String verschlText;
	final int ASCIIAT = 64;
	final int ASCIIA = 65;
	final int ASCIIZ = 90;
	final int ASCII_ = 95;
	final int ZERO = 0;
	final int EINS = 1;

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

	//Konstruktor
	public CrypterCaesar(String text, Key key) {
		this.text = text;
		this.key = key;
		this.verschlText = "";
	}
	
	public CrypterCaesar(String text, String key) {
		this(text, new Key(key));
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
		char hilfe = (char) (klartextZeichen + (this.key.getKey().charAt(ZERO)-ASCIIAT));
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
		char hilfe = (char) (cypherTextZeichen - (this.key.getKey().charAt(ZERO)-ASCIIAT));
		while (hilfe < ASCIIA) {
			hilfe = (char) (hilfe + (ASCIIZ - ASCIIAT));
		}
		while (hilfe > ASCIIZ) {
			hilfe = (char) (hilfe - (ASCIIZ - ASCIIAT));
		}
		return hilfe;
	}
	public static void main(String[] args){
		CrypterCaesar cc = new CrypterCaesar("ZYX", "V");
		cc.verschluesselText();
		System.out.println(cc.getVerschlText());
		CrypterCaesar cc2 = new CrypterCaesar(cc.getVerschlText(), "V");
		cc2.entschluesselText();
		System.out.println(cc2.getVerschlText());
		
	}
	
	
}
