package exceptions;

@SuppressWarnings("serial")
public class MauvaisCampException extends Exception{
	
	public MauvaisCampException(){
		System.out.println("Vous ne placez pas votre pièce dans votre camp !\n");
	}

}
