package Aufgabe_2;

public class Key {

	private String key;

	public Key(String key) {
		this.key = key;
	}
	public Key(int key){
		this.key = Integer.toString(key);
	}

	public String getKey() {
		return key;
	}
	
	
}
