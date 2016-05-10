package Aufgabe_3_Test;

import static org.junit.Assert.*;
import org.junit.Test;

import Aufgabe_3.*;

/**
 * @author Melissa Zindl, Sebastian Schuler
 *
 */
public class MembershipListTest {
	// Testobjekte
	public static MembershipList vereinsListe = new MembershipList(5);
	public static Member adam = new Member(3, "Adam", "Einser");
	public static Member peter = new Member(6, "Peter", "Zweier");

	@Test
	public void putGetTest() {
		vereinsListe.put(peter);
		assertEquals(vereinsListe.get("6"), peter);
	}

	@Test
	public void eindeutigeIDTest() {
		MembershipList idListe = new MembershipList();
		Member m1 = new Member("Harald", "Meier");
		Member m2 = new Member("Ricardo", "Michaels");
		Member m3 = new Member("Liselotte", "Turing");
		idListe.put(m1);
		idListe.put(m2);
		idListe.put(m3);
		assertEquals(idListe.get(1).getMitgliedsID(), 1);
		assertEquals(idListe.get(2).getVorname(), "Ricardo");
		assertEquals(idListe.get(3).getAnzahlJahre(), 0);
	}

	@Test
	public void removeTest() {
		vereinsListe.remove(3);
		assertEquals(vereinsListe.get(3), null);
	}

	@Test
	public void mitgliedsIDtest() {
		assertEquals(vereinsListe.get(6).mitgliedsID, 6);
	}

	@Test
	public void clearTest() {
		vereinsListe.clear();
		assertEquals(vereinsListe.size(), 0);
	}

	@Test
	public void cloneTest() {
		assertEquals(vereinsListe.clone(), vereinsListe);
	}

	@Test
	public void konstruktorEinsTest() {
		MembershipList vereinsListeTest = new MembershipList(5);
		assertNotEquals(vereinsListeTest, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void exceptionKonstruktorTest() {
		MembershipList vL = new MembershipList(-1);
	}

}
