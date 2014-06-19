package exceptions;

public class MauvaisCampException extends Exception{
	public MauvaisCampException(){
		System.err.println("Vous ne placez pas votre pièce dans votre camp !\n");
	}

}
