package Aufgabe_2;

public class Key {
	
	public String key;
	public Key(Character key){
		this.key = Character.toString(key);
	}
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
