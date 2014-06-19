package exceptions;

public class CoordonneeInconnuException extends Exception{
	public CoordonneeInconnuException(){
		System.err.println("Les coordonnés n'existent pas !\n");
	}

}
