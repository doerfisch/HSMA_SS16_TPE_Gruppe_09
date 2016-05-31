package Aufgabe_4;

public class Strecke {
	protected int laenge;
	protected char[] verlauf;
	protected Block[] bloecke;
	protected Zug[] zuege;

	public Strecke(int laenge, Block[] bloecke, Zug[] zuege) {
		this.laenge = laenge;
		this.bloecke = bloecke;
		this.zuege = zuege;
		this.verlauf = new char[laenge];

		for (Zug zug : zuege) {
			if (zug.getPosition() != zug.block.getStart()) {
				verlauf[zug.getPosition() - 1] = zug.getZugName();
			} else {
				verlauf[zug.getPosition()] = zug.getZugName();
			}
			zug.setStrecke(this);
		}
	}

	@Override
	public String toString() {
		String ergebnis = "";
		for (int i = 0; i < verlauf.length; i++) {
			verlauf[i] = 0;
		}
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
		for (Zug zug : zuege) {
			if (zug.position == zug.block.getEnde()) {
				verlauf[zug.position - 2] = zug.getZugName();
			} else {
				verlauf[zug.position - 1] = zug.getZugName();
			}
		}
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
