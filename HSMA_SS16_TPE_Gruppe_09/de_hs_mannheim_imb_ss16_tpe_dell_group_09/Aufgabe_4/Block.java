package Aufgabe_4;

/**
 * @author Sebastian Schuler, Melissa Zindl
 *
 */
public class Block {
	// rot = false, grün = true
	protected boolean signal = true;
	private int start;
	private int ende;

	/**
	 * Konstruktor von Block mit den Parametern
	 * @param start
	 * @param ende
	 */
	public Block(int start, int ende) {
		this.start = start;
		this.ende = ende;
	}
	
	/**
	 * Getter- und Setter-Methoden
	 */
	public int getEnde() {
		return this.ende;
	}

	public int getStart() {
		return this.start;
	}
	
	public boolean getSignal() {
		return this.signal;
	}
	/**
	 * Methode zum Sperren eines Blocks
	 */
	public synchronized void lock(){
		this.signal = false;	}

	/**
	 * Methode zum Entsperren eines Blocks
	 */
	public synchronized void unlock() {
		synchronized (this) {
			this.signal = true;
			this.notify();
		}
	}
}
