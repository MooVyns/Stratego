package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import plateau.Direction;

public class DirectionTest {

	@Test
	public void test() {
		/**/
		assertEquals(Direction.Sud.getDirection("S"), Direction.Sud);
		assertEquals(Direction.Sud.getDirection("NE"), Direction.NordEst);
		assertEquals(Direction.Sud.getDirection("SO"), Direction.SudOuest);
		
	}

}
