package exceptions;

@SuppressWarnings("serial")
public class CoordonneeInconnuException extends Exception{
	public CoordonneeInconnuException(){
		System.out.println("Les coordonn�s n'existent pas !\n");
	}

}
