package Aufgabe_4;

/**
 * @author Sebastian Schuler, Melissa Zindl
 *
 */
public class Zug extends Thread implements Runnable {
	protected char name;
	protected int position;
	protected int geschwindigkeit;
	protected Block block;
	protected Strecke strecke;
	private boolean interrupted = false;

	/**
	 * Konstruktor für Zug mit den Parametern
	 * 
	 * @param name
	 * @param position
	 * @param geschwindigkeit
	 * @param block
	 */
	public Zug(char name, int position, int geschwindigkeit, Block block) {
		this.name = name;
		this.geschwindigkeit = geschwindigkeit;
		this.block = block;
		this.position = position;
		block.lock();

	}

	/**
	 * Getter- und Setter-Methoden
	 */
	public int getPosition() {
		return this.position;
	}

	public char getZugName() {
		return this.name;
	}

	public void setStrecke(Strecke strecke) {
		this.strecke = strecke;
	}

	/*
	 * run-Methode überprüft die Position des Zugs in Verhältnis zum Block, zur
	 * Strecke und zum Signal des nächsten Blocks und lässt ihn dann fahren oder
	 * warten
	 */
	@Override
	public void run() {
		while (!interrupted) {
			synchronized (block) {
				// Der Zug befindet sich innerhalb seines Blocks
				if (position <= block.getEnde()) {
					// neuePosition ist die Position, die der Zug nach dem
					// nächsten Zug hätte
					int neuePosition = position + 1;
					// Wenn der Zug am Ende des Blocks ist, muss geschaut
					// werden, wie das Signal dieses Blocks ist
					if (neuePosition > block.getEnde()) {
						// Wenn der Zug am Ende der Strecke ist, also im
						// nächsten Zug darüber hinaus fahren würde, wird er
						// beendet und der Block freigegeben.
						if (strecke.laenge < neuePosition) {
							neuePosition = strecke.laenge;
							interrupted = true;
							block.unlock();
							this.interrupt();
						} else {
							// Iteriert über alle Blöcke der Strecke um den
							// Block zu finden, den der Zug als nächstes befährt
							for (Block iteratorBlock : strecke.bloecke) {
								if (iteratorBlock.getStart() == block.getEnde()) {
									/*
									 * Wenn das Signal rot ist, darf der Zug
									 * nicht fahren. Der Zug muss warten!
									 */
									synchronized (iteratorBlock) {
										if (!iteratorBlock.signal) {
											try {
												iteratorBlock.wait();
											} catch (InterruptedException e) {
												e.printStackTrace();
												break;
											}
										} else
										/*
										 * Wenn das Signal grün ist, darf der
										 * Zug fahren. Der Zug wechselt den
										 * Block, der alte Block wird entsperrt,
										 * der neue Block wird gesperrt.
										 */
										{
											block.unlock();
											iteratorBlock.lock();
											this.block = iteratorBlock;
											this.position = neuePosition;
											// Das Char-Array zur Darstellung
											// der Strecke wird erneuert
											strecke.verlauf[neuePosition] = getZugName();
											// Die Strecke wird ausgegeben
											System.out.println(strecke);
											// die For-Schleife wird beendet, da
											// der nächste Block bereits
											// erreicht wurde
											break;
										}
									}
								}
							}
						}
					} else {
						// Wenn der Zug eine Position vor dem Ende ist fährt er
						// zum Ende
						if (neuePosition != strecke.laenge) {
							// Wenn an der neuen Position bereits ein Zug ist
							// kommt
							// es zum Zusammenstoß!
							if (strecke.verlauf[neuePosition - 1] >= 'A' && strecke.verlauf[neuePosition - 1] < 'Z') {
								interrupted = true;
								this.interrupt();
								try {
									throw new SimulationException("Zusammenstoß an Stelle " + getPosition() + "! Zug "
											+ getZugName() + " kann nicht mehr weiterfahren!");
								} catch (SimulationException e) {
									e.printStackTrace();
								}
								// Ist dort kein Zug, fährt der Zug eine Stelle
								// weiter
							} else {
								this.position = neuePosition;
							}
							// Der Zug fährt zum Ende
						} else {
							this.position = neuePosition;
						}
						// Die Strecke hat sich geändert, ein Zug hat sich
						// bewegt, also wird die Strecke neu ausgegeben
						System.out.println(strecke);
						try {
							// Der Zug wartet für 1 Sekunde / seine
							// Geschwindigkeit
							int toWait = (int) (1000 / geschwindigkeit);
							sleep(toWait);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				else {
					try {
						throw new SimulationException(this.getZugName() + " befindet sich nicht in seinem Block und wird beendet! ");
					} catch (SimulationException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
}