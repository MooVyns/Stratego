package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import plateau.Direction;
import stratego.OperationCoordonn�es;

public class OperationCoordonn�esTest {

	@Test
	public void test() {
		/*calculNouvellesCoordonn�e*/
		assertEquals(OperationCoordonn�es.calculNouvellesCoordonn�e("A1", Direction.Sud,1), "A2"); 
		
		
		
		/*stringToCoord*/
		assertEquals(OperationCoordonn�es.stringToCoord("A2")[0],0);
		assertEquals(OperationCoordonn�es.stringToCoord("A2")[1],1);
		
		assertEquals(OperationCoordonn�es.stringToCoord("C5")[0],2);
		assertEquals(OperationCoordonn�es.stringToCoord("C5")[1],4);
		
		
		/*coordToString*/
		assertEquals(OperationCoordonn�es.coordToString(0, 1),"A2");
		assertEquals(OperationCoordonn�es.coordToString(2, 4),"C5");		
	}
}
