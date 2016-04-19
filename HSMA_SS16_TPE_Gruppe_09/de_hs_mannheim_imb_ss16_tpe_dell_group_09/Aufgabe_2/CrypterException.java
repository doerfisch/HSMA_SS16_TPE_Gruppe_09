package Aufgabe_2;

/**
 * @author Melissa Zindl, Sebastian Schuler
 * Klasse CrypterException zur Ausnahmebehandlung von Fehlern während der Verschlüsselung
 * 
 */
public class CrypterException extends Exception{
	/**
	 * Aufruf des super-Konstruktors mit der Nachricht message
	 */
	private static final long serialVersionUID = 3610158590031915956L;

	protected CrypterException(String message){
		super(message);
	}
}
