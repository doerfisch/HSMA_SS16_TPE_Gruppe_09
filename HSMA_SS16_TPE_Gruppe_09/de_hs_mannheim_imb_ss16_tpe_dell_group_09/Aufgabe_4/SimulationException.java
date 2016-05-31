package Aufgabe_4;

/**
 * @author Sebastian Schuler, Melissa Zindl SimulationException zur
 *         Fehlerbehandlung in der Simulation
 */
public class SimulationException extends Exception {

	private static final long serialVersionUID = 4528821930136233001L;

	/**
	 * Aufruf des super-Konstruktors einmal mit der Nachricht message und einmal
	 * ohne Parameter
	 */

	protected SimulationException(String message) {
		super(message);
	}

	protected SimulationException() {
		super();
	}
}
