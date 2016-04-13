package Aufgabe_2;

public class CrypterSubstitution implements Crypter {
	
	private String text;
	private Key key;
	private String verschlText;
	final int ASCIIAT = 64;
	final int ASCIIA = 65;
	final int ASCIIZ = 90;
	final int ASCII_ = 95;
	final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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
	
	public CrypterSubstitution(String text, Key key){
		this.text = text;
		this.key = key;
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
//		char hilfe = (char) (cypherTextZeichen - Integer.parseInt(this.key.getKey()));
		int arrayIndex = cypherTextZeichen - ASCIIA;
		int subWert = this.ALPHABET.charAt(arrayIndex);
		char hilfe = (char) (subWert);
		while (hilfe < ASCIIA) {
			hilfe = (char) (hilfe + (ASCIIZ - ASCIIAT));
		}
		while (hilfe > ASCIIZ) {
			hilfe = (char) (hilfe - (ASCIIZ - ASCIIAT));
		}
		return hilfe;
	}
	public static void main (String [] args) {
		CrypterSubstitution c1 = new CrypterSubstitution("WIKIPEDIAISTINFORMATIV", new Key("UFLPWDRASJMCONQYBVTEXHZKGI"));
		CrypterSubstitution c2 = new CrypterSubstitution("ABCD", new Key("BCDE"));
		System.out.println(c1.getText() + " " + c1.getKey().getKey());
		c1.verschluesselText();
		System.out.println(c1.getVerschlText());
		c1.reset();
		c1.entschluesselText();
		System.out.println(c1.getVerschlText());
		System.out.println(c2.getText() + " " + c2.getKey().getKey());
		c2.verschluesselText();
		System.out.println(c2.getVerschlText());
		c2.reset();
		c2.entschluesselText();
		System.out.println(c2.getVerschlText());
	}
}
