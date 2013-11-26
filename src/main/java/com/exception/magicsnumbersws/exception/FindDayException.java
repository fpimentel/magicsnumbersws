package com.exception.magicsnumbersws.exception;
import java.io.Serializable;

/**
 *
 * @author fpimentel
 */
public class FindDayException extends Exception implements Serializable{
    private static final long serialVersionUID = 7032871751856788157L;
	
	public FindDayException(String msg){
		super(msg);
	}
	
	public FindDayException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public FindDayException(){
		super();
	} 
}
