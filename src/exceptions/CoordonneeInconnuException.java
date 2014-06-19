package exceptions;

@SuppressWarnings("serial")
public class CoordonneeInconnuException extends Exception{
	public CoordonneeInconnuException(){
		System.out.println("Les coordonnés n'existent pas !\n");
	}

}
