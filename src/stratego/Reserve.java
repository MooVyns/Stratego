package stratego;

public class Reserve {
	private int[] piecesReserve;

	public Reserve() {
		piecesReserve = new int[TypePiece.values().length];
		initReserve();
	}

	public void initReserve() {
		/*piecesReserve[TypePiece.Maréchal.getValeur()] = 1;
		piecesReserve[TypePiece.Général.getValeur()] = 1;
		piecesReserve[TypePiece.Colonel.getValeur()] = 2;
		piecesReserve[TypePiece.Major.getValeur()] = 3;
		piecesReserve[TypePiece.Capitaine.getValeur()] = 4;
		piecesReserve[TypePiece.Lieutenant.getValeur()] = 4;
		piecesReserve[TypePiece.Sergent.getValeur()] = 4;
		piecesReserve[TypePiece.Démineur.getValeur()] = 5;
		piecesReserve[TypePiece.Eclaireur.getValeur()] = 8;
		piecesReserve[TypePiece.Espion.getValeur()] = 1;
		piecesReserve[TypePiece.Bombe.getValeur()] = 6;
		piecesReserve[TypePiece.Drapeau.getValeur()] = 1;*/
		
		piecesReserve[TypePiece.Maréchal.getValeur()] = 0;
		piecesReserve[TypePiece.Général.getValeur()] = 0;
		piecesReserve[TypePiece.Colonel.getValeur()] = 0;
		piecesReserve[TypePiece.Major.getValeur()] = 0;
		piecesReserve[TypePiece.Capitaine.getValeur()] = 0;
		piecesReserve[TypePiece.Lieutenant.getValeur()] = 0;
		piecesReserve[TypePiece.Sergent.getValeur()] = 0;
		piecesReserve[TypePiece.Démineur.getValeur()] = 0;
		piecesReserve[TypePiece.Eclaireur.getValeur()] = 0;
		piecesReserve[TypePiece.Espion.getValeur()] = 0;
		piecesReserve[TypePiece.Bombe.getValeur()] = 1;
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
