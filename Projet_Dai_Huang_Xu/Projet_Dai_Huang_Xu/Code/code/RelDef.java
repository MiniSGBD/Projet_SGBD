package code;

import java.util.ArrayList;
import java.util.List;

public class RelDef {

	//Attribute
	private String nomRelation;
	private int nombreColonnes;
	private List<String> typeColonnes = new ArrayList<String>();
	private int recordSize;
	private int slotCount;
	private int fileIdx;
	

	/**Constructor
	 * 
	 */
	public RelDef() {
	}

	/**
	 * 
	 * @param typeColonnes
	 */
	public void setTypeCol(List<String> typeColonnes) {
		// TODO Auto-generated method stub
		this.typeColonnes.addAll(typeColonnes);
	}

	/**
	 * 
	 * @param nombreColonnes
	 */
	public void setNbCol(int nombreColonnes) {
		// TODO Auto-generated method stub
		this.nombreColonnes = nombreColonnes;
	}

	/**
	 * 
	 * @param nomRelation
	 */
	public void setNomRelation(String nomRelation) {
		// TODO Auto-generated method stub
		this.nomRelation=nomRelation;
	}

	/**
	 * 
	 * @return
	 */
	public String getNomRelation() {
		return nomRelation;
	}

	/**
	 * 
	 * @return
	 */
	public int getNbCol() {
		return nombreColonnes;
	}

	/**
	 * 
	 * @return
	 */
	public List<String> getTypeCol() {
		return typeColonnes; 
	}
	public void setSlotCount(int slotCount){
		this.slotCount = slotCount;
	}
	
	public int getSlotCount(){
		return this.slotCount;
	}
	
	public void setRecordSize(int recordSize){
		this.recordSize = recordSize;
	}
	
	public int getRecordSize(){
		return this.recordSize;
	}
	
	public void setFileIdx(int fileIdx){
		this.fileIdx = fileIdx;
	}
	
	public int getfileIdx(){
		return this.fileIdx;
	}

}