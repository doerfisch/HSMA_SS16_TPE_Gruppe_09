package Aufgabe_2;

/**
 * @author Melissa Zindl, Sebastian Schuler
 *Generische Klasse Key, mit private key vom generischen Typ T,
 *private, um Zugriff auf Key nicht zu erlauben
 * @param <T>
 */
public class Key <T>{
	
	
	
	private T key;
	
	public Key (T key){
		this.key = key;
	}
	
	public T getKey (){
		return key;
	}
	
}
