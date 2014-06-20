package stratego;

public class Reserve {
	private int[] piecesReserve;

	public Reserve() {
		piecesReserve = new int[TypePiece.values().length];
		initReserve();
	}

	public void initReserve() {
		piecesReserve[TypePiece.Mar�chal.getValeur()] = 1;
		piecesReserve[TypePiece.G�n�ral.getValeur()] = 1;
		piecesReserve[TypePiece.Colonel.getValeur()] = 2;
		piecesReserve[TypePiece.Major.getValeur()] = 3;
		piecesReserve[TypePiece.Capitaine.getValeur()] = 4;
		piecesReserve[TypePiece.Lieutenant.getValeur()] = 4;
		piecesReserve[TypePiece.Sergent.getValeur()] = 4;
		piecesReserve[TypePiece.D�mineur.getValeur()] = 5;
		piecesReserve[TypePiece.Eclaireur.getValeur()] = 8;
		piecesReserve[TypePiece.Espion.getValeur()] = 1;
		piecesReserve[TypePiece.Bombe.getValeur()] = 6;
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
		return this.piecesReserve[typePiece.getValeur()] != 0;
	}
	
	public int getNombrePieceDisponible(TypePiece typePiece){
		return this.piecesReserve[typePiece.getValeur()];
	}

}
