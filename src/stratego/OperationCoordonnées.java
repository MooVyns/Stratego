package stratego;

public class OperationCoordonnées {
	// ok
		public static String coordToString(int i, int j) {
			String res = new String();
			res += (char) (i + 64);
			res += Integer.toString(j);
			return res;
		}

		// a verifier
		public static int[] stringToCoord(String coord) {
			int[] res = new int[2];
			res[0] = coord.charAt(0) - 65;
			res[1] = coord.charAt(1) - 49;
			return res;
		}
		
		public static boolean verfiCoordonnees(String coord, Plateau plateau) {
			for (int i = 0; i < plateau.getNbColonnes(); ++i) {
				for (int j = 0; j < plateau.getNbLignes(); ++j) {
					if (coord.equals(plateau.getCase(coord).getCoordonnees())) {
						return true;
					}
				}
			}
			return false;

		}


}
