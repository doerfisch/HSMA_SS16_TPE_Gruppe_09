package Aufgabe_4_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Aufgabe_4.Block;

public class BlockTest {

	@Test
	public void testBlock() {
		assertEquals(Block.class, new Block(0,10).getClass());
		assertEquals(10, new Block(10,20).getStart());
		assertEquals(50, new Block(20,50).getEnde());
	}
	
	public void testLock() {
		assertTrue(new Block(0,10).getSignal());
		Block lockBlock = new Block(1,2);
		lockBlock.lock();
		assertFalse(lockBlock.getSignal());
	}

}
