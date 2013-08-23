package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SearchAllUserException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SearchAllUserException(String msg){
		super(msg);
	}
	
	public SearchAllUserException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SearchAllUserException(){
		super();
	}    
}
