package Aufgabe_4;

/**
 * @author Sebastian Schuler, Melissa Zindl
 *
 */
public class Strecke {
	protected int laenge;
	protected char[] verlauf;
	protected Block[] bloecke;
	protected Zug[] zuege;

	/**
	 * Konstruktor für die Strecke mit den Parametern
	 * 
	 * @param laenge
	 * @param bloecke
	 * @param zuege
	 */
	public Strecke(int laenge, Block[] bloecke, Zug[] zuege) {
		this.laenge = laenge;
		this.bloecke = bloecke;
		this.zuege = zuege;
		this.verlauf = new char[laenge];
		// Die Züge werden im Char-Array zur Darstellung der Strecke gesetzt
		for (Zug zug : zuege) {
			if (zug.getPosition() != zug.block.getStart()) {
				verlauf[zug.getPosition() - 1] = zug.getZugName();
			} else {
				verlauf[zug.getPosition()] = zug.getZugName();
			}
			// Dem Zug wird mitgeteilt, auf welcher Strecke er sich befindet
			zug.setStrecke(this);
		}
	}

	// Überschreiben der toString()-Methode zum Darstellen der Strecke
	// Hierzu wird das Char-Array "verlauf" genutzt
	@Override
	public String toString() {
		String ergebnis = "";
		for (int i = 0; i < verlauf.length; i++) {
			verlauf[i] = 0;
		}
		// Die Signale der Blöcke werden gesetzt, sie stehen am Anfang eines
		// Blocks
		for (Block block : bloecke) {
			if (block.getStart() != 0) {
				if (block.signal == false) {
					verlauf[block.getStart() - 1] = '|';
				} else {
					verlauf[block.getStart() - 1] = '_';
				}
			} else {
				if (block.signal == false) {
					verlauf[block.getStart()] = '|';
				} else {
					verlauf[block.getStart()] = '_';
				}
			}
		}
		// Zur besseren Darstellung der Züge werden Züge nie auf das Feld eines
		// Signals gesetzt, sie halten (bildlich) immer ein Feld davor
		for (Zug zug : zuege) {
			if (zug.position == zug.block.getEnde()) {
				verlauf[zug.position - 2] = zug.getZugName();
			} else {
				verlauf[zug.position - 1] = zug.getZugName();
			}
			if (zug.position == this.laenge) {
				verlauf[zug.position - 2] = ('-');
			}
		}
		// Das Char-Array wird durchlaufen und die Werte werden in einen
		// String gesetzt, welcher zurückgegeben wird
		for (char punkt : verlauf) {
			if ("".equals(punkt) || punkt == 0) {
				ergebnis = ergebnis + Character.toString('-');
			} else {
				ergebnis = ergebnis + Character.toString(punkt);
			}
		}
		return ergebnis;
	}
}
