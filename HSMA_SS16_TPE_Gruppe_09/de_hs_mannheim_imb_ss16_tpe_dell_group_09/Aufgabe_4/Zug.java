package Aufgabe_4;

public class Zug extends Thread implements Runnable {
	protected char name;
	protected int position;
	protected int geschwindigkeit;
	protected Block block;
	protected Strecke strecke;
	private boolean cont = false;

	public Zug(char name, int position, int geschwindigkeit, Block block) {
		this.name = name;
		this.position = position;
		this.geschwindigkeit = geschwindigkeit;
		this.block = block;
		block.lock();

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
		while (!cont) {
			synchronized (block) {
				if (position <= block.getEnde()) {
					int neuePosition = position + 1;
					if ((neuePosition) > block.getEnde()) {
						if (strecke.laenge < neuePosition) {
							neuePosition = strecke.laenge;
							cont = true;
						} else {
							for (Block iteratorBlock : strecke.bloecke) {
								if (iteratorBlock.getStart() == block.getEnde()) {
									/*
									 * Wenn das Signal rot ist, darf der Zug
									 * nicht fahren. Der Zug muss warten!
									 */
									if (!iteratorBlock.signal) {
										synchronized (iteratorBlock) {
											try {
												iteratorBlock.wait();
											} catch (InterruptedException e) {
												break;
											}
										}
									} else
									/*
									 * Wenn das Signal grün ist, darf der Zug
									 * fahren. Der Zug wechselt den Block, der
									 * alte Block wird entsperrt, der neue Block
									 * wird gesperrt.
									 */
									{
										block.unlock();
										iteratorBlock.lock();
										this.block = iteratorBlock;
										this.position = neuePosition;
										strecke.verlauf[neuePosition] = getZugName();
									}
								}
							}
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
			yield();
			}
		}

	}
}