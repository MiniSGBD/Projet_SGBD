package code;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

public class DBDef implements Serializable {

	//il en existe une seule et unique instance DBDef
	private static final DBDef INSTANCE = new DBDef();

	//Attributes
	private ArrayList<RelDef> liste = new ArrayList<RelDef>();
	private int compteur;

	/**Constructor
	 * 
	 */
	public DBDef() {
		//this.liste = (ArrayList<RelDef>) liste;
		this.liste = null;
	}

	/**Method addRelation
	 * 
	 * @param reldef
	 */
	public void addRelation(RelDef reldef) {
		// TODO Auto-generated method stub
		this.liste.add(reldef);
		this.compteur++;
	}

	/**
	 * 
	 * @param num
	 */
	public void setCompteur(int num) {
		this.compteur = num;
	}

	/**
	 * 
	 * @return
	 */
	public int getCompteur() {
		return this.compteur;
	}

	/**
	 * 
	 * @param reldef
	 */
	public void setList(RelDef reldef) {
		this.liste.add(reldef);
	}

	/**
	 * 
	 * @return
	 */
	public List<RelDef> getList() {
		return this.liste;
	}

	/**
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * Vérifier si le catalog existe sinon ne rien faire
	 * lecture de l'objet DBDef écrite dans catalogue et mise à jour de l'instance unique de cette classe (this)
	 * 
	 */
	public void init() throws IOException, ClassNotFoundException {
		String current = new java.io.File( "." ).getCanonicalPath();
		String path = current+"\134DB\134Catalog.def";
		try{
			File f = new File(path);
			if(f.exists() && !f.isDirectory())
			{
				FileInputStream file = new FileInputStream(new File(path));
				ObjectInputStream catalogIn = new ObjectInputStream(file);
				
				this.setINSTANCE((DBDef)catalogIn.readObject());
				catalogIn.close();
				file.close();
			}
			
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		
		
	}

	/**
	 * @throws IOException 
	 * écriture de l'objet DBDef dans le catalog
	 * 
	 */
	public void finish() throws IOException {
		String current = new java.io.File( "." ).getCanonicalPath();
		String path = current+"\134DB\134Catalog.def";

		try {
			FileOutputStream file = new FileOutputStream(new File(path));
			ObjectOutputStream catalogOut = new ObjectOutputStream(file);
			catalogOut.writeObject(this);
			catalogOut.close();
			file.close();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		
		
	}

	/**
	 * 
	 * @return
	 */
	public static DBDef getINSTANCE() {
		return INSTANCE;
	}

	/**
	 * 
	 * @param iNSTANCE
	 */
	public static void setINSTANCE(DBDef iNSTANCE) {
		iNSTANCE = INSTANCE;
	}

}