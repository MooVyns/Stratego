package exceptions;

@SuppressWarnings("serial")
public class MauvaisCampException extends Exception{
	
	public MauvaisCampException(){
		System.out.println("Vous ne placez pas votre pi�ce dans votre camp !\n");
	}

}
