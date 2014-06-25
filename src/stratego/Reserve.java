package stratego;

public class Reserve {
	private int[] piecesReserve;

	public Reserve() {
		piecesReserve = new int[TypePiece.values().length];
		initReserve();
	}

	public void initReserve() {
		piecesReserve[TypePiece.Bombe.getValeur()] = 4;
		piecesReserve[TypePiece.Maréchal.getValeur()] = 0;
		piecesReserve[TypePiece.Général.getValeur()] = 1;
		piecesReserve[TypePiece.Colonel.getValeur()] = 1;
		piecesReserve[TypePiece.Major.getValeur()] = 2;
		piecesReserve[TypePiece.Capitaine.getValeur()] = 2;
		piecesReserve[TypePiece.Lieutenant.getValeur()] = 0;
		piecesReserve[TypePiece.Sergent.getValeur()] = 4;
		piecesReserve[TypePiece.Démineur.getValeur()] = 4;
		piecesReserve[TypePiece.Eclaireur.getValeur()] = 4;
		piecesReserve[TypePiece.Espion.getValeur()] = 1;		
		piecesReserve[TypePiece.Drapeau.getValeur()] = 1;
	
	}

	public void retirerPiece(TypePiece typePiece) {
		this.piecesReserve[typePiece.getValeur()]--;
	}

	public void remettrePiece(TypePiece typePiece) {
		this.piecesReserve[typePiece.getValeur()]++;
	}

	public boolean estVide() {
		boolean res = true;
		for (int i = 0; i < this.piecesReserve.length; i++) {
			res = res && (this.piecesReserve[i] == 0);
		}
		return res;
	}

	public boolean pieceEstDisponible(TypePiece typePiece) {
		System.out.println(typePiece.getValeur());
		return this.piecesReserve[typePiece.getValeur()] != 0;
	}

	public int getNombrePieceDisponible(TypePiece typePiece) {
		return this.piecesReserve[typePiece.getValeur()];
	}

}
