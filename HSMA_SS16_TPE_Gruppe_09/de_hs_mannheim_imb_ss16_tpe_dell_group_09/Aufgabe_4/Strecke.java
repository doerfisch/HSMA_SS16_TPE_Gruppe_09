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
		for (Block block : bloecke) {
			verlauf[block.getStart()] = '_';
		}
		for (Zug zug : zuege) {
			verlauf[zug.getPosition()] = zug.getName();
		}
	}

	@Override
	public String toString() {
		String ergebnis = "";
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
