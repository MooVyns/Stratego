package exceptions;

public class MauvaisCampException extends Exception{
	public MauvaisCampException(){
		System.err.println("Vous ne placez pas votre pi�ce dans votre camp !\n");
	}

}
