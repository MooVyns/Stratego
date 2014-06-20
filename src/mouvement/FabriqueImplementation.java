package mouvement;

import stratego.ImplementationMouvement;
import stratego.TypePiece;

public class FabriqueImplementation {
	public static ImplementationMouvement creer(int i){
		if(i == TypePiece.Bombe.getValeur() || i == TypePiece.Drapeau.getValeur())
			return new PieceImmobile();
		if(i == TypePiece.Eclaireur.getValeur())
			return new PieceRapide();
		else
			return new PieceLente();		
	}
	

}