package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import plateau.Direction;
import plateau.Plateau;
import stratego.OperationCoordonn�es;

public class OperationCoordonn�esTest {

	@Test
	public void test() {
		Plateau plateau = new Plateau(7, 9);
		
		/* calculNouvellesCoordonn�e */
		assertEquals(OperationCoordonn�es.calculNouvellesCoordonn�e("A1",
				Direction.Sud, 1), "A2");

		/* stringToCoord */
		assertEquals(OperationCoordonn�es.stringToCoord("A2")[0], 0);
		assertEquals(OperationCoordonn�es.stringToCoord("A2")[1], 1);

		assertEquals(OperationCoordonn�es.stringToCoord("C5")[0], 2);
		assertEquals(OperationCoordonn�es.stringToCoord("C5")[1], 4);

		/* coordToString */
		assertEquals(OperationCoordonn�es.coordToString(0, 1), "A2");
		assertEquals(OperationCoordonn�es.coordToString(2, 4), "C5");
		
		/* TEST verifcoordonn�e*/
		assertEquals(OperationCoordonn�es.verfiCoordonnees("A1",plateau),true);
		assertEquals(OperationCoordonn�es.verfiCoordonnees("B4",plateau),true);
		assertEquals(OperationCoordonn�es.verfiCoordonnees("A9",plateau),false);
		assertEquals(OperationCoordonn�es.verfiCoordonnees("C9",plateau),false);
		assertEquals(OperationCoordonn�es.verfiCoordonnees("D9",plateau),true);
		assertEquals(OperationCoordonn�es.verfiCoordonnees("A7",plateau),true);
	}
}
