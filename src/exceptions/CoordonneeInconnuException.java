package exceptions;

public class CoordonneeInconnuException extends Exception{
	public CoordonneeInconnuException(){
		System.err.println("Les coordonn�s n'existent pas !\n");
	}

}
