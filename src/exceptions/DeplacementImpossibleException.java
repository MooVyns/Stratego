package exceptions;

@SuppressWarnings("serial")
public class DeplacementImpossibleException extends Exception{	
	public DeplacementImpossibleException(){
		System.out.println("Cette piece ne peut pas etre d�placer � l'endroit voulu !\n");
	}


}
