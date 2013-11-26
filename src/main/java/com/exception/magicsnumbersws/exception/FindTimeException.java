package com.exception.magicsnumbersws.exception;
import java.io.Serializable;

/**
 *
 * @author fpimentel
 */
public class FindTimeException extends Exception implements Serializable{
    private static final long serialVersionUID = 7032871751856788157L;
	
	public FindTimeException(String msg){
		super(msg);
	}
	
	public FindTimeException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public FindTimeException(){
		super();
	} 
}
