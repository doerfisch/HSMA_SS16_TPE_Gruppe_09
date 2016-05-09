package Aufgabe_3;

import java.util.HashMap;
import com.sun.javafx.collections.MappingChange.Map;

public class MembershipList extends HashMap<String, Member> implements Map<String, Member> {

	private String key;
	private Member value;

	public MembershipList() {
		super();
	}

	public MembershipList(int i) {
		super(i);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 202395904055089545L;

	@Override
	public Member map(String original) {
		return null;
	}

	public void put(Member mitglied) {
		put(Integer.toString(mitglied.getMitgliedsID()), mitglied);
	}

	public String toString() {
		return this.iteriere();
	}

	public String iteriere() {
		String result = "";
		for (Entry<String, Member> e : this.entrySet()) {
			result = result + e.getValue() + "\n";

		}
		return result;
	}

	public void remove(int key) {
		remove(Integer.toString(key));
	}

	public Member get(int key) {
		return get(Integer.toString(key));

	}

}
