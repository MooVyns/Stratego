package exceptions;

@SuppressWarnings("serial")
public class PieceNonDisponibleException extends Exception {
	public PieceNonDisponibleException() {
		System.out.println("La piece n'est plus disponible !\n");
	}

}
