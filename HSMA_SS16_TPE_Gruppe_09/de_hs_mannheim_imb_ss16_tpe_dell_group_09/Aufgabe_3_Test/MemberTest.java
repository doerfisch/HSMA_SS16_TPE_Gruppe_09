package Aufgabe_3_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Aufgabe_3.Member;

public class MemberTest {
	//Testobjekte
	public static Member adam = new Member(3, "Adam", "Einser", 2);
	public static Member peter = new Member(6, "Peter", "Zweier", 5);
	public static Member peter2 = new Member(6, "Armgard", "Zweier", 6);

	@Test
	public void testCompareTo() {
		assertTrue(peter.compareTo(peter2));
	}

	@Test
	public void konstruktorTestEins() {
		Member adam = new Member(3, "Adam", "Einser", 2);
		assertEquals(MemberTest.adam.getMitgliedsID(), 3);
		assertEquals(MemberTest.adam.getVorname(), "Adam");
		assertEquals(MemberTest.adam.getNachname(), "Einser");
		assertEquals(MemberTest.adam.getAnzahlJahre(), 2);
	}

	@Test
	public void konstruktorTestZwei() {
		Member peter = new Member(6, "Peter", "Zweier");
		assertEquals(MemberTest.peter.getMitgliedsID(), 6);
		assertEquals(MemberTest.peter.getVorname(), "Peter");
		assertEquals(MemberTest.peter.getNachname(), "Zweier");
	}

}
