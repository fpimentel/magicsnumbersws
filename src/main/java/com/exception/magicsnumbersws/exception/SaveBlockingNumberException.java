package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SaveBlockingNumberException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SaveBlockingNumberException(String msg){
		super(msg);
	}
	
	public SaveBlockingNumberException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SaveBlockingNumberException(){
		super();
	}    
}
