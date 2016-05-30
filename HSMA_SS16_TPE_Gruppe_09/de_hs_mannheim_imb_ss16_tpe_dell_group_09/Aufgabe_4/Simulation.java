package Aufgabe_4;

public class Simulation {

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

//		Thread t1 = new Thread(a, "thrugA");
//		Thread t2 = new Thread(b, "thrugB");
//		Thread t3 = new Thread(c, "thrugC");
//		Thread t4 = new Thread(d, "thrugD");
//		Thread t5 = new Thread(e, "thrugE");

		Strecke s1 = new Strecke(70, new Block[] { b1, b2, b3, b4, b5, b6, b7, b8 }, new Zug[] { a, b, c, d, e });
		System.out.println(s1);

		for (Zug zug : s1.zuege) {
			zug.start();
		}

//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();

		try {
			a.join();
			System.out.println(a.getName() + " beendet!");
			b.join();
			System.out.println(b.getName() + " beendet!");
			c.join();
			System.out.println(c.getName() + " beendet!");
			d.join();
			System.out.println(d.getName() + " beendet!");
			e.join();
			System.out.println(e.getName() + " beendet!");
//			t1.join();
//			t2.join();
//			t3.join();
//			t4.join();
//			t5.join();
		} catch (InterruptedException e2) {
		}
		System.out.println("Die Simulation ist beendet");
	}
	
	
}
