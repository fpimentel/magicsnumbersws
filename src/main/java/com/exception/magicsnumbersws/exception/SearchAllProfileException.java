package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SearchAllProfileException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SearchAllProfileException(String msg){
		super(msg);
	}
	
	public SearchAllProfileException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SearchAllProfileException(){
		super();
	}    
}
