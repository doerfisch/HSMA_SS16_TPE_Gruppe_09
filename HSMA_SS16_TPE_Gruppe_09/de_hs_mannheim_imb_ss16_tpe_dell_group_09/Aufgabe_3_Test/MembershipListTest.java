package Aufgabe_3_Test;

import static org.junit.Assert.*;
import org.junit.Test;

import Aufgabe_3.*;


public class MembershipListTest {

	public static MembershipList vereinsListe = new MembershipList(5);
	public static Member adam = new Member(3, "Adam", "Einser");
	public static Member peter = new Member(6, "Peter", "Zweier");
	
	@Test
	public void test() {
		vereinsListe.put(adam);
		vereinsListe.put(peter);
		assertEquals(vereinsListe.get("3"), adam);
		System.out.println(vereinsListe);
	}
	
	@Test
	public void putGetTest(){
		vereinsListe.put(peter);
		assertEquals(vereinsListe.get("6"), peter);
	}
	
	@Test
	public void removeTest(){
		vereinsListe.remove(3);
		assertEquals(vereinsListe.get(3), null); 
	}
	
	@Test
	public void mitgliedsIDtest(){
		assertEquals(vereinsListe.get(6).mitgliedsID, 6);
	}
	
	@Test
	public void clearTest(){
		vereinsListe.clear();
		assertEquals(vereinsListe.size(), 0);
	}
	
	@Test
	public void cloneTest(){
		assertEquals(vereinsListe.clone(), vereinsListe);
	}
	
	@Test
	public void konstruktorEinsTest(){
		MembershipList vereinsListeTest = new MembershipList(5);
		assertNotEquals(vereinsListeTest, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void exceptionKonstruktorTest(){
		MembershipList vL = new MembershipList(-1);
		
		
	}

}
