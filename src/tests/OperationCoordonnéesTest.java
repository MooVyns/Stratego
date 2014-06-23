package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import stratego.Direction;
import stratego.OperationCoordonnées;

public class OperationCoordonnéesTest {

	@Test
	public void test() {
		/*calculNouvellesCoordonnée*/
		System.out.println(OperationCoordonnées.calculNouvellesCoordonnée("A1", Direction.bas,1));
		assertEquals(OperationCoordonnées.calculNouvellesCoordonnée("A1", Direction.bas,1), "A2"); 
		
		
		
		/*stringToCoord*/
		System.out.println(OperationCoordonnées.stringToCoord("A2")[0]);
		System.out.println(OperationCoordonnées.stringToCoord("A2")[1]);
		
		System.out.println(OperationCoordonnées.stringToCoord("C5")[0]);
		System.out.println(OperationCoordonnées.stringToCoord("C5")[1]);
		System.out.println("hello");
		
		
		/*coordToString*/
		System.out.println(OperationCoordonnées.coordToString(0, 1));
		System.out.println(OperationCoordonnées.coordToString(2, 4));		
	}
}
