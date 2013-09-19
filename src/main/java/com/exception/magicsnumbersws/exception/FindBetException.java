package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class FindBetException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public FindBetException(String msg){
		super(msg);
	}
	
	public FindBetException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public FindBetException(){
		super();
	}    
}
