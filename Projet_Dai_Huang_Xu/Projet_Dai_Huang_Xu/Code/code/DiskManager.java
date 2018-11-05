package code;

import java.io.File;
import java.io.IOException;

public class DiskManager {

	private static final DiskManager INSTANCE = new DiskManager();

	public static DiskManager getINSTANCE() {
		return INSTANCE;
	}


	public void createFile(int iFileIdx) throws IOException {

		String fileName = "Data_"+iFileIdx+".rf";
		String current = new java.io.File( "." ).getCanonicalPath();
		String path = current+"\134"+fileName;
		System.out.println(path);

		try {
			File file = new File(path);
			if(file.createNewFile())
				System.out.println("File creation successfull");
			else
				System.out.println("Error while creating File, file already exists in specified path");
		}
		catch(IOException io) {
			io.printStackTrace();
		}

	}

	public void  AddPage(int iFileIdx, int oPageId) {

	}
	

	/**
	 * 
	 * @param iNSTANCE
	 */
	public static void setINSTANCE(DiskManager iNSTANCE) {
		iNSTANCE = INSTANCE;
	}

	public void readPage(int iPageId, int oBuffer) {

	}
}
