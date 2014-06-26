package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import stratego.Reserve;

public class ReserveTest {

	@Test
	public void test() {
		Reserve reserve = new Reserve();		
		assertFalse(reserve.estVide());
		
		
	}

}
