package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import plateau.Direction;
import stratego.OperationCoordonn�es;

public class OperationCoordonn�esTest {

	@Test
	public void test() {
		/*calculNouvellesCoordonn�e*/
		System.out.println(OperationCoordonn�es.calculNouvellesCoordonn�e("A1", Direction.bas,1));
		assertEquals(OperationCoordonn�es.calculNouvellesCoordonn�e("A1", Direction.bas,1), "A2"); 
		
		
		
		/*stringToCoord*/
		System.out.println(OperationCoordonn�es.stringToCoord("A2")[0]);
		System.out.println(OperationCoordonn�es.stringToCoord("A2")[1]);
		
		System.out.println(OperationCoordonn�es.stringToCoord("C5")[0]);
		System.out.println(OperationCoordonn�es.stringToCoord("C5")[1]);
		System.out.println("hello");
		
		
		/*coordToString*/
		System.out.println(OperationCoordonn�es.coordToString(0, 1));
		System.out.println(OperationCoordonn�es.coordToString(2, 4));		
	}
}
