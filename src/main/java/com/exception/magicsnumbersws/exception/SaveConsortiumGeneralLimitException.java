package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SaveConsortiumGeneralLimitException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SaveConsortiumGeneralLimitException(String msg){
		super(msg);
	}
	
	public SaveConsortiumGeneralLimitException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SaveConsortiumGeneralLimitException(){
		super();
	}    
}
