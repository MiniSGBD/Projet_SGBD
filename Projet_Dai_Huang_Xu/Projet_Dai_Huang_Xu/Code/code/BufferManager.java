package code;

public class BufferManager {

	private static final BufferManager INSTANCE = new BufferManager();

	public static BufferManager getINSTANCE() {

		return INSTANCE;
	}

	/**
	 * 
	 * @param iNSTANCE
	 */
	public static void setINSTANCE(BufferManager iNSTANCE) {

		iNSTANCE = INSTANCE;
	}

}