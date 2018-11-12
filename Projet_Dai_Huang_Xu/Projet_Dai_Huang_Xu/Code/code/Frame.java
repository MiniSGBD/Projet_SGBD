package code;

import java.nio.Buffer;

public class Frame {

	Byte [] contenue;
	PageId pageId;
	int pin_count;
	boolean dirty;

	public Frame(PageId pageId){
		this.pageId=pageId;
		pin_count=0;
		dirty=false;
	}

	//les m¨¦thodes pour PinCount
	public void increPinCount(){
		pin_count++;
	}
	public void decrePinCount(){
		pin_count--;
	}
	public void setPinCount(int valeur){
		pin_count=valeur;
	}
	public int getPinCount(int valeur){
		return(pin_count);
	}
	

	//les m¨¦thodes pour Byte [] contenue
	public void setContenue(Byte [] contenue){
		this.contenue=contenue;
	}
	public Byte[] getContenue(){
		return contenue;	
	}
	
	//les m¨¦thodes pour Dirty
	public void setDirty(Boolean iIsDirty){
		 this.dirty=iIsDirty;
	}
	public boolean getDirty(){
		return this.dirty;
	}
	
	////les m¨¦thodes pour pageId
	public PageId getPageId(){
		return this.pageId;
	}
	


}
