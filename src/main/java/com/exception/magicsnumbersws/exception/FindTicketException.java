package com.exception.magicsnumbersws.exception;
import java.io.Serializable;

/**
 *
 * @author fpimentel
 */
public class FindTicketException extends Exception implements Serializable{
    private static final long serialVersionUID = 7032871751856788157L;
	
	public FindTicketException(String msg){
		super(msg);
	}
	
	public FindTicketException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public FindTicketException(){
		super();
	} 
}
