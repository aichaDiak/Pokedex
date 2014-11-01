package cartes;

/**
 * Cette classe repr&eacute;sente les cartes de type Dresseur. Ils en existe
 * trois types qui sont : Chaque carte poss&egrave;de un nom, un numero dans la
 * collection
 * 
 * @author aicha
 * 
 */
public class Dresseur extends Carte {
	private int type_dresseur;
	private String actions;
	private final String[] TYPE_DRESSEUR_NOM = { "Objet", "Supporter", "Stade" };
	private final String[] TYPE_DRESSEUR_REGLE = { "", "", "" };

	public Dresseur(int num, int type, String nom, String actions) {
		super(num, nom);
		this.type_dresseur = type;
		this.actions = actions;
	}

	@Override
	public String type_de_carte() {
		return "DRESSEUR";
	}

	public String toString() {
		String chaine = this.type_de_carte();
		chaine += "\t / \t" + this.TYPE_DRESSEUR_NOM[this.type_dresseur];
		chaine += "\n=========================";
		chaine += "\n" + this.nom;
		chaine += "\n=========================\n";
		chaine += "\n" + this.actions + "\n";
		chaine += "\n=========================";
		chaine += "\n" + this.TYPE_DRESSEUR_REGLE[this.type_dresseur];
		chaine += "\n=========================";
		chaine += "\n" + this.numero;

		return chaine;
	}
}
