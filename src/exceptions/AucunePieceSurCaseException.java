package exceptions;

@SuppressWarnings("serial")
public class AucunePieceSurCaseException  extends Exception{
	public AucunePieceSurCaseException(){
	    System.out.println("Il n'y a aucune piece à cet endroit!\n");
	}  

}
