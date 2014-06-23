package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import plateau.Direction;

public class DirectionTest {

	@Test
	public void test() {
		/**/
		assertEquals(Direction.bas.getDirection("B"), Direction.bas);
		assertEquals(Direction.bas.getDirection("HD"), Direction.hautDroite);
		assertEquals(Direction.bas.getDirection("BG"), Direction.basGauche);
		
	}

}
