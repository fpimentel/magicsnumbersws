package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SearchAllConsortiumException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SearchAllConsortiumException(String msg){
		super(msg);
	}
	
	public SearchAllConsortiumException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SearchAllConsortiumException(){
		super();
	}    
}
