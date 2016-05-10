package Aufgabe_3;

import java.util.HashMap;
import com.sun.javafx.collections.MappingChange.Map;

/**
 * Klasse der Vereinsliste Erbt von HashMap und implementiert Map Da nur Strings
 * für den Key und Member als Objekte zugelassen sind, werden keine Generics
 * benutzt
 * 
 * @author Melissa Zindl, Sebastian Schuler
 *
 */
public class MembershipList extends HashMap<String, Member> implements Map<String, Member> {

	/**
	 * Konstruktoraufruf von Oberklasse HashMap ohne Parameter
	 */
	public MembershipList() {
		super();
	}

	/**
	 * Konstruktoraufruf von Oberklasse HashMap mit Parameter int i
	 */
	public MembershipList(int i) {
		super(i);
	}

	private static final long serialVersionUID = 202395904055089545L;

	@Override
	public Member map(String original) {
		return null;
	}

	/**
	 * Fügt ein mitglied der Liste hinzu Der Key wird aus der MitgliedsID
	 * ausgelesen
	 * 
	 * @param mitglied
	 */
	public void put(Member mitglied) {
		put(Integer.toString(mitglied.getMitgliedsID()), mitglied);
	}

	// toString Methode, ruft die Methode iteriere auf
	public String toString() {
		return this.iteriere();
	}

	/**
	 * iteriert durch die MembershipList und fügt jeden Eintrag zu einem String
	 * hinzu, welcher als result zurückgegeben wird Da key durch die mitgliedsID
	 * bestimmt wird, verzichten wir auf eine zusätzliche Ausgabe des keys, da
	 * das Objekt member die mitgliedsID an erster Position besitzt
	 * 
	 * @return String result
	 */
	public String iteriere() {
		String result = "";
		for (Entry<String, Member> e : this.entrySet()) {
			result = result + e.getValue() + "\n";

		}
		return result;
	}

	/**
	 * Entfernt member aus der Liste mit Hilfe des
	 * 
	 * @param key
	 */
	public void remove(int key) {
		remove(Integer.toString(key));
	}

	/**
	 * Methode zum Zugreifen auf member mit Hilfe eines int-keys zur
	 * Vereinfachung der Eingabe
	 * 
	 * @param key
	 * @return member mit dem Schlüssel key
	 */
	public Member get(int key) {
		return get(Integer.toString(key));
	}

}
