package Aufgabe_4;

/**
 * @author Sebastian Schuler, Melissa Zindl Klasse Simulation, simuliert eine
 *         Strecke mit Blöcken und Zügen.
 *
 */
public class Simulation {

	/**
	 * @param args
	 *            Main-Methode. Es werden die benötigten Objekte für die
	 *            Simulation erstellt und danach die Simulation gestartet.
	 */
	public static void main(String[] args) {
		Block b1 = new Block(0, 10);
		Block b2 = new Block(10, 15);
		Block b3 = new Block(15, 25);
		Block b4 = new Block(25, 35);
		Block b5 = new Block(35, 50);
		Block b6 = new Block(50, 60);
		Block b7 = new Block(60, 65);
		Block b8 = new Block(65, 70);

		Zug a = new Zug('A', 6, 5, b1);
		Zug b = new Zug('B', 11, 15, b2);
		Zug c = new Zug('C', 20, 5, b3);
		Zug d = new Zug('D', 30, 10, b4);
		Zug e = new Zug('E', 45, 6, b5);

		Strecke s1 = new Strecke(70, new Block[] { b1, b2, b3, b4, b5, b6, b7, b8 }, new Zug[] { a, b, c, d, e });
		// Erstausgabe der Strecke
		System.out.println(s1);
		// die Zug-Threads werden gestartet
		for (Zug zug : s1.zuege) {
			zug.start();
		}
		// Es wird auf Beendigung der Zug-Threads gewartet, danach wird die
		// Simulation beendet.
		try {
			for (Zug zug : s1.zuege) {
				zug.join();
				System.out.println(zug.getName() + " mit Zug " + zug.getZugName() + " beendet!");
			}
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		System.out.println(s1);
		System.out.println("Die Simulation ist beendet");
	}

}
