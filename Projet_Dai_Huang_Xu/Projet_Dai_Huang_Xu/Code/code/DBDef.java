package code;
import java.util.ArrayList;

import java.util.List;

public class DBDef {

	//il en existe une seule et unique instance DBDef
	private static final DBDef INSTANCE = new DBDef();

	//Attributes
	private ArrayList<RelDef> liste = new ArrayList<RelDef>();
	private int compteur;

	/**Constructor
	 * 
	 */
	public DBDef() {
		this.liste = (ArrayList<RelDef>) liste;
		//this.liste = new ArrayList<RelDef>(null);
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
	 * 
	 */
	public void init() {
	}

	/**
	 * 
	 */
	public void finish() {
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