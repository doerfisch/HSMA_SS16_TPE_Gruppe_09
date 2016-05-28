package Aufgabe_4;

public class Simulation {

	public static void main(String[] args){
		Block b1 = new Block(0, 10);
		Block b2 = new Block(10,15);
		Block b3 = new Block(15,25);
		Block b4 = new Block(25,35);
		Block b5 = new Block(35,50);
		Block b6 = new Block(50,60);
		Block b7 = new Block(60,65);
		Block b8 = new Block(65,70);

		Zug a = new Zug('A', 6, 5);
		Zug b = new Zug('B', 11, 15);
		Zug c = new Zug('C', 20, 5);
		Zug d = new Zug('D', 30, 10);
		Zug e = new Zug('E', 45, 6);
		
		Strecke s1 = new Strecke(70, new Block[]{b1, b2, b3, b4, b5, b6, b7, b8}, new Zug[]{a, b, c, d, e});
		System.out.println(s1);
		
		for (Zug zug:s1.zuege){
			zug.run();
		}
	}
}
