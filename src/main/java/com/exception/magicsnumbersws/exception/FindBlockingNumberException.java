package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class FindBlockingNumberException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public FindBlockingNumberException(String msg){
		super(msg);
	}
	
	public FindBlockingNumberException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public FindBlockingNumberException(){
		super();
	}    
}
