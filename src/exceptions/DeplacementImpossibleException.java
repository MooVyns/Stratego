package exceptions;

@SuppressWarnings("serial")
public class DeplacementImpossibleException extends Exception{	
	public DeplacementImpossibleException(){
		System.out.println("Cette piece ne peut pas etre déplacer à l'endroit voulu !\n");
	}


}
