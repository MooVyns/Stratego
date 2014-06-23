package ihm;

import java.util.Scanner;

import stratego.AbstractJoueur;
import stratego.IHM;
import stratego.Plateau;
import stratego.TypePiece;

public class ConsoleIHM implements IHM {
	private Scanner sc;

	public ConsoleIHM() {
		sc = new Scanner(System.in);
	}

	@Override
	public void afficherPlateau(Plateau plateau) {
		System.out.println(plateau.testdessin());
	}

	@Override
	public String[] saisieNomJoueur() {
		String[] noms = new String[2];
		for (int i = 1; i <= noms.length; i++) {
			System.out.println("Joueur " + i + ", Entrez votre nom");
			noms[i - 1] = sc.next();
		}
		return noms;
	}

	@Override
	public TypePiece choixPiece(AbstractJoueur j) {
		System.out.println("Quelle pi�ce voulez vous placer ?");
		for (int i = 0; i < TypePiece.values().length; i++)
			System.out.println(TypePiece.values()[i].representation()
					+ "  => "
					+ TypePiece.values()[i].toString()
					+ "  "
					+ (j.getReserve().getNombrePieceDisponible(TypePiece
							.values()[i])) + " pi�ce(s) disponible(s)");
		String choix = sc.next().toUpperCase();
		/*while () {
			System.out
					.println("La pi�ce non identifi�e. Tapez un nombre entre 0 et 12.");

		}*/
		return TypePiece.getTypePiece(choix);
	}

	public String choixCoordonnees() {
		System.out.println("A quelle endroit ?");
		return sc.next().toUpperCase();
	}

	public void afficherString(String str) {
		System.out.println(str);
	}
	
	public String  retirerPieces (String coord, String coordp) {
		System.out.println("Quelle pi�ce voulez vous retirer ?");
		return coordp= this.choixCoordonnees();
		
		
		
	}

	@Override
	public void retirerPiece(String coord) {
		// TODO Auto-generated method stub
		
	}
}
