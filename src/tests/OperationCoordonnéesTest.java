package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import plateau.Direction;
import plateau.Plateau;
import stratego.OperationCoordonnées;

public class OperationCoordonnéesTest {

	@Test
	public void test() {
		Plateau plateau = new Plateau(7, 9);
		
		/* calculNouvellesCoordonnée */
		assertEquals(OperationCoordonnées.calculNouvellesCoordonnée("A1",
				Direction.Sud, 1), "A2");

		/* stringToCoord */
		assertEquals(OperationCoordonnées.stringToCoord("A2")[0], 0);
		assertEquals(OperationCoordonnées.stringToCoord("A2")[1], 1);

		assertEquals(OperationCoordonnées.stringToCoord("C5")[0], 2);
		assertEquals(OperationCoordonnées.stringToCoord("C5")[1], 4);

		/* coordToString */
		assertEquals(OperationCoordonnées.coordToString(0, 1), "A2");
		assertEquals(OperationCoordonnées.coordToString(2, 4), "C5");
		
		/* TEST verifcoordonnée*/
		assertEquals(OperationCoordonnées.verfiCoordonnees("A1",plateau),true);
		assertEquals(OperationCoordonnées.verfiCoordonnees("B4",plateau),true);
		assertEquals(OperationCoordonnées.verfiCoordonnees("A9",plateau),false);
		assertEquals(OperationCoordonnées.verfiCoordonnees("C9",plateau),false);
		assertEquals(OperationCoordonnées.verfiCoordonnees("D9",plateau),true);
		assertEquals(OperationCoordonnées.verfiCoordonnees("A7",plateau),true);
	}
}
