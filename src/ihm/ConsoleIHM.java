package ihm;

import stratego.IHM;
import stratego.Plateau;

public class ConsoleIHM implements IHM{	

	@Override
	public void afficherPlateau(Plateau plateau) {
		System.out.println(plateau.toString());		
	}
	
}
