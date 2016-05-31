package Aufgabe_4;

public class Block {
	// rot = false, grün = true
	protected boolean signal = true;
	private int start;
	private int ende;

	public Block(int start, int ende) {
		this.start = start;
		this.ende = ende;
	}

	public int getEnde() {
		return this.ende;
	}

	public int getStart() {
		return this.start;
	}
	
	public synchronized void lock(){
		this.signal = false;
	}

	public synchronized void unlock() {
		synchronized (this) {
			this.signal = true;
			this.notify();
		}
	}
}
