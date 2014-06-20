package stratego;

public enum Camp {

	Nord("Nord"), 
	Sud("Sud"),
	Centre("Centre"),
	Indisponible("Indisponible");

	private String nom;
	
	Camp(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return this.nom;
	}

}
