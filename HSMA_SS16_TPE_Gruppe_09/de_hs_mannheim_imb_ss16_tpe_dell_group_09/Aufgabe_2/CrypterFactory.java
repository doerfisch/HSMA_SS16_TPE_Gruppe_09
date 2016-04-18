package Aufgabe_2;

public class CrypterFactory {
	
	public static void main (String [] args){
		CrypterXOR cx = new CrypterXOR("SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_", new Key("EINSCHLUESSEL") );
		cx.entschluesselText();
		System.out.println("XOR Ergebnis: " + cx.getVerschlText());
		
		CrypterCaesar cc = new CrypterCaesar(cx.getVerschlText(), new Key ("V"));
		cc.entschluesselText();
		System.out.println("Caesar Ergebnis: " + cc.getVerschlText());
		
		CrypterSubstitution cs = new CrypterSubstitution(cc.getVerschlText(), new Key ("MNBVCXYLKJHGFDSAPOIUZTREWQ"));
		cs.entschluesselText();
		System.out.println("Finales Ergebnis: " + cs.getVerschlText());
	}
	
}
