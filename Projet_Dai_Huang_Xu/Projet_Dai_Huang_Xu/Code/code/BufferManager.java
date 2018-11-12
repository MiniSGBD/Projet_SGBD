package code;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class BufferManager {

	private static final BufferManager INSTANCE = new BufferManager();

	public static BufferManager getINSTANCE() {

		return INSTANCE;
	}

	private Frame[] BufferPool = new Frame[Constantes.FRAMECOUNT];

	/**
	 * set instance
	 * 
	 * @param iNSTANCE
	 */
	public static void setINSTANCE(BufferManager iNSTANCE) {

		iNSTANCE = INSTANCE;
	}



	/**
	 * permet de retourne un des buffers qui stockent le contenu d¡¯une page dans
	 * une des cases
	 * 
	 * @param iPageId???
	 * @return un des buffers qui stockent le contenu d¡¯une page dans une des
	 *         cases
	 * return null: si aucune valeur correspond ¨¤ ce iPageId et il n'est pas possible de getPage
	 */
	public Byte[] getPage(PageId iPageId) {
		for (int i = 0; i < Constantes.FRAMECOUNT; i++) {
			if (BufferPool[i].getPageId() == iPageId){
				BufferPool[i].increPinCount();
				return BufferPool[i].getContenue();
			}
		}
		for (int i = 0; i < Constantes.FRAMECOUNT; i++) {
			if(BufferPool[i]==null) {
				BufferPool[i]=new Frame(iPageId);
				BufferPool[i].increPinCount();
				return BufferPool[i].getContenue();
			}
		}
		return null; // a changer

	}

	
	/**
	 * freePage, cad decremente Pin_Count, et setDirty
	 * @param iPageId
	 * @param iIsDirty
	 */
	public void freePage(PageId iPageId, boolean iIsDirty) {
		for (int i = 0; i < Constantes.FRAMECOUNT; i++) {
			if (BufferPool[i].getPageId() == iPageId){
				BufferPool[i].decrePinCount();
				BufferPool[i].setDirty(iIsDirty);
			}
		}
	}

	/**
	 * quand on execucu cette methode,
	 * si dirty = 1; buffer et pin_count sont tous initialiser a 0
	 * 
	 * ps: risque d'etre fausse;
	 * rmq: a utiliser dans la m¨¦thode Finish du DBManager
	 */
	public void flushAll() {
		for (int i = 0; i < Constantes.FRAMECOUNT; i++) {
			if (BufferPool[i].getDirty()==true){
				BufferPool[i].setContenue(null);
				BufferPool[i].setPinCount(0);
			}
		}
	}

}