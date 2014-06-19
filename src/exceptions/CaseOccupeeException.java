package exceptions;

@SuppressWarnings("serial")
public class CaseOccupeeException extends Exception{
	public CaseOccupeeException(){
	    System.out.println("La case est déja occupée!\n");
	  }  
}
