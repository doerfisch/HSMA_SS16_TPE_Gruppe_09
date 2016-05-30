package Aufgabe_4;

public class Zug extends Thread implements Runnable {
	protected char name;
	protected int position;
	protected int geschwindigkeit;
	protected Block block;
	protected Strecke strecke;
	private boolean cont = true;

	public Zug(char name, int position, int geschwindigkeit, Block block) {
		this.name = name;
		this.position = position;
		this.geschwindigkeit = geschwindigkeit;
		this.block = block;

	}

	public int getPosition() {
		return this.position;
	}

	public char getZugName() {
		return this.name;
	}

	public void setStrecke(Strecke strecke) {
		this.strecke = strecke;
	}

	@Override
	public void run() {
		while (true) {
//			synchronized (block) {
				while (position <= block.getEnde()) {
					int neuePosition = position + 1;
					if ((neuePosition) > block.getEnde()) {
						if (strecke.laenge < neuePosition) {
							neuePosition = strecke.laenge;
						} else {
							for (Block iteratorBlock : strecke.bloecke) {
								if (iteratorBlock.getStart() == block.getEnde()) {
									block.switchSignal();
									notify();
									this.block = iteratorBlock;
									block.switchSignal();
									this.position = neuePosition;
									strecke.verlauf[neuePosition] = getZugName();
								}
							}
						}
						try {
							wait();
						} catch (InterruptedException e) {
						}
					} else {

						this.position = neuePosition;
						System.out.println(getName());
						System.out.println(this.getZugName() + "\n" + this.position);
						System.out.println(strecke);
						try {
							int toWait = (int) (1000 / geschwindigkeit);
							sleep(toWait);
						} catch (InterruptedException e) {
						}
					}
				}
			}
		}

	}
//}