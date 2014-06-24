package stratego;

import plateau.Plateau;





public class OperationCoordonnées {
	// ok
	public static String coordToString(int i, int j) {
		String res = new String();
		res += (char) (i + 65);
		res += Integer.toString(j+1);
		return res;
	}

	// a verifier
	public static int[] stringToCoord(String coord) {
		int[] res = new int[2];
		res[0] = coord.charAt(0) - 65;
		res[1] = coord.charAt(1) - 49;
		return res;
	}

	public static boolean verfiCoordonnees(String coord, AbstractPlateau plateau) {
		for (int i = 0; i < plateau.getNbColonnes(); ++i) {
			for (int j = 0; j < plateau.getNbLignes(); ++j) {
				if (coord.equals(plateau.getCase(coord).getCoordonnees())) {
					return true;
				}
			}
		}
		return false;
	}

	public static String calculNouvellesCoordonnée(String coord, IEnumDirection direction,
			int nbrCases) {
		int coordInt[] = stringToCoord(coord);
		coordInt[0] += (direction.getColonne() * nbrCases);
		coordInt[1] += (direction.getLigne()* nbrCases);
		return coordToString(coordInt[0],coordInt[1]);
	}

}
