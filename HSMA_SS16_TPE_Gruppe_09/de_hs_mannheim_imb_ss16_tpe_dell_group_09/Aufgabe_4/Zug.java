package Aufgabe_4;

public class Zug implements Runnable{
	protected char name;
	protected int position;
	protected int geschwindigkeit;
	protected Block block;
	
	public Zug(char name, int position, int geschwindigkeit){
		this.name = name;
		this.position = position;
		this.geschwindigkeit = geschwindigkeit;
	}
	
	public int getPosition(){
		return  this.position;
	}
	public char getName(){
		return this.name;
	}
	@Override
	public void run() {
		while (position<block.getEnde()){
			this.position = position + geschwindigkeit/10;
			try {
				this.wait(100);
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	
}
