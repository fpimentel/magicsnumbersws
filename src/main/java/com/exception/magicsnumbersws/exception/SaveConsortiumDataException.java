package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SaveConsortiumDataException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SaveConsortiumDataException(String msg){
		super(msg);
	}
	
	public SaveConsortiumDataException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SaveConsortiumDataException(){
		super();
	}    
}
