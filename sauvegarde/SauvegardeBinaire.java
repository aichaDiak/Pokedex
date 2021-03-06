package sauvegarde;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URL;

/**
 * Cette classe va nous permettre la sauvegarde en binaire des classes filles
 * qui l'&eacute;tendront
 * 
 * @author aicha
 */
public abstract class SauvegardeBinaire implements Serializable {

	private static final long serialVersionUID = 1L;
	private transient String repertoire = "";
	private transient static final String FICHIER_PAR_DEFAUT = "pokemon";

	public SauvegardeBinaire() {
		URL chemin = this.getClass().getResource("");
		String uri = chemin.getPath();
		this.repertoire = uri.split("bin")[0];
		this.repertoire += "ressources/binaire/";
		boolean decoder = false;
		try {
			uri = java.net.URLDecoder.decode(this.repertoire, "UTF-8");
			decoder = true;
		} catch (UnsupportedEncodingException e) {
			decoder = false;
		}
		if(decoder)
			this.repertoire = uri;
		//System.out.println("1 . " + this.repertoire);
	}

	public boolean sauvegarder() {
		try {
			File temp = new File(this.repertoire);
			if(!temp.exists())
				temp.mkdirs();
			FileOutputStream fichier = new FileOutputStream(this.repertoire + FICHIER_PAR_DEFAUT);
			ObjectOutputStream stream = new ObjectOutputStream(fichier);
			stream.writeObject(this);
			stream.flush();
			stream.close();
			return true;
		} catch (IOException e) {
			//System.out.println(e);
			return false;
		}
	}

	protected boolean recuperer() {
		try {
			FileInputStream fichier = new FileInputStream(this.repertoire
					+ FICHIER_PAR_DEFAUT);
			ObjectInputStream stream = new ObjectInputStream(fichier);
			this.charger(stream.readObject());
			stream.close();
			return true;
		} catch (IOException | ClassNotFoundException e) {
			return false;
		}
	}

	protected abstract void charger(Object obj);
}
