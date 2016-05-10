package Aufgabe_3_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Aufgabe_3.Member;

/**
 * @author Melissa Zindl, Sebastian Schuler
 *
 */
public class MemberTest {
	//Testobjekte
	public static Member klaus = new Member(6, "Klaus", "Zweier", 5);
	public static Member irmgard = new Member(6, "Irmgard", "Zweier", 6);

	@Test
	public void testCompareTo() {
		assertTrue(klaus.compareTo(irmgard));
	}
	
	@Test
	public void testEquals() {
		assertFalse(klaus.equals(irmgard));
	}

	@Test
	public void konstruktorTestEins() {
		Member adam = new Member(3, "Adam", "Einser", 2);
		assertEquals(adam.getMitgliedsID(), 3);
		assertEquals(adam.getVorname(), "Adam");
		assertEquals(adam.getNachname(), "Einser");
		assertEquals(adam.getAnzahlJahre(), 2);
	}

	@Test
	public void konstruktorTestZwei() {
		Member peter = new Member(6, "Peter", "Zweier");
		assertEquals(peter.getMitgliedsID(), 6);
		assertEquals(peter.getVorname(), "Peter");
		assertEquals(peter.getNachname(), "Zweier");
	}

}
