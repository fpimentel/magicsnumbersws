package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SaveSystemOptionsDataException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SaveSystemOptionsDataException(String msg){
		super(msg);
	}
	
	public SaveSystemOptionsDataException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SaveSystemOptionsDataException(){
		super();
	}    
}
