package code;

import java.util.List;
import java.util.Scanner;

public class DBManager {

	//j'ai ajoute ca
	//il en existe une seule et unique instance DBManager 
	private static final DBManager INSTANCE = new DBManager();

	/**Constructor
	 * 
	 */
	public DBManager() {
		//pas d'argument 
	}

	/**Main de DBManager comprend
	 *une boucle prend des commandes utilisateur
	 * si la commande est "exit", 
	 * alors il y a appel de Finish sur le DBManager, 
	 * puis sortie de la boucle
	 * sinon, la commande est simplement passee au DBManager, 
	 * via ProcessCommand (et la boucle continue)
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("hello");

		//creation de l'instance DBManager
		DBManager dbmanager = new DBManager();
		String input = null;

		do {

			Scanner cmd = new Scanner(System.in);
			System.out.println("enter une commande");
			input = cmd.nextLine();
			System.out.println("votre commande : "+input);
			cmd.close();

			if(input == "exit") dbmanager.Finish();

			else dbmanager.ProcessCommand(input);

		}while(input != "exit");
	}

	/**method Init
	 * 
	 */
	public void Init() {

	}

	/**method Finish
	 * 
	 */
	public void Finish() {

	}

	/**method ProcessCommand
	 * 
	 * @param str
	 */
	public void ProcessCommand(String str) {

	}

	/**cr¨¦e une RelDef suivant les arguments 
	 * et qui la rajoute au DBDef
	 * @param nomRelation
	 * @param NombreColonnes
	 * @param typesDeColonne
	 */	
	public void CreateRelation(String nomRelation, int NombreColonnes, List<String> typesDeColonne) {

		RelDef reldef = new RelDef();
		reldef.setNomRelation(nomRelation);
		reldef.setNbCol(NombreColonnes);
		for(int i=0; i<typesDeColonne.size(); i++) reldef.setTypeCol(typesDeColonne);

		DBDef dbdef = new DBDef();
		dbdef.addRelation(reldef);
	}

	/**
	 * 
	 * @return
	 */
	public static DBManager getInstance() {
		return INSTANCE;
	}

	/**
	 * 
	 * @param iNSTANCE
	 */
	public static void setINSTANCE(DBManager iNSTANCE) {
		iNSTANCE = INSTANCE;
	}

}