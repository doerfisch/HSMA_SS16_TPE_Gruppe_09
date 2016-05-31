package Aufgabe_4_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Aufgabe_4.Block;
import Aufgabe_4.Zug;

public class ZugTest {

	Block b1 = new Block(0, 10);
	Zug a = new Zug('A', 6, 5, b1);
	
	@Test
	public void testZug() {
		assertEquals(Zug.class, new Zug('C', 0, 10, b1).getClass());
		assertEquals('A', a.getZugName());
		assertEquals(6, a.getPosition());
	}
	
	public void testRun() {
		a.run();
		assertTrue(a.isAlive());
		assertFalse(a.isInterrupted());
		a.interrupt();
		assertTrue(a.isInterrupted());
		assertFalse(a.isAlive());
	}

}
