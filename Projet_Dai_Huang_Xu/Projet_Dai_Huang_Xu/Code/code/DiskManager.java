package code;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DiskManager {

	private static final DiskManager INSTANCE = new DiskManager();

	public static DiskManager getINSTANCE() {
		return INSTANCE;
	}


	public void createFile(int iFileIdx) throws IOException {

		String fileName = "Data_"+iFileIdx+".rf";
		String current = new java.io.File( "." ).getCanonicalPath();
		String path = current+"\134DB\134"+fileName;
		System.out.println(path);

		try {
			File file = new File(path);

			if(file.exists()) System.out.println("already exist");
			else {

				if(file.createNewFile())
					System.out.println("File creation successfull");
				else
					System.out.println("Error while creating File, file already exists in specified path");
			}
		}
		catch(IOException io) {
			io.printStackTrace();
		}

	}

	public static PageId addPage(PageId iFileIdx) throws IOException {

		String fileName = "Data_"+iFileIdx+".rf";
		String current = new java.io.File( "." ).getCanonicalPath();
		String path = current+"\134DB\134"+fileName;
		
		File file = new File(path);
		
		PageId oPageId = new PageId();
		
		//oPageId.setFileIdx(iFileIdx);
		//oPageId = ((file.length()) / (Constantes.PAGESIZE));
		oPageId.setPageIdx(oPageId);

		return oPageId;
	}



	
	public byte[] readPage(int iPageId, byte[] oBuffer) throws IOException{
		String current = new java.io.File( "." ).getCanonicalPath();
		String path = current+"\134DB\134"+"Data_0.rf";

		try {

			InputStream flux=new FileInputStream(path); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;

			while ((ligne=buff.readLine())!=null){
				System.out.println(ligne);
				oBuffer=ligne.getBytes();
			}
			buff.close(); 
		}		
		catch (Exception e) {
			System.out.println(e.toString());
		}

			
		return oBuffer;
		
	}

	public void writePage(int iPageId, String iBuffer) throws IOException{

		String current = new java.io.File( "." ).getCanonicalPath();
		String path = current+"\134DB\134"+"Data_0.rf";

		DataOutputStream bw = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(path,true)));
		bw.write(iBuffer.getBytes());
		bw.close();
	}
	
	/**
	 * 
	 * @param iNSTANCE
	 */
	public static void setINSTANCE(DiskManager iNSTANCE) {
		iNSTANCE = INSTANCE;
	}

}
