package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SearchAllSystemOptionException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SearchAllSystemOptionException(String msg){
		super(msg);
	}
	
	public SearchAllSystemOptionException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SearchAllSystemOptionException(){
		super();
	}    
}
