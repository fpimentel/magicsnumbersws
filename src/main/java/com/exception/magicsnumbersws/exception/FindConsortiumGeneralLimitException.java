package com.exception.magicsnumbersws.exception;
import java.io.Serializable;

/**
 *
 * @author fpimentel
 */
public class FindConsortiumGeneralLimitException extends Exception implements Serializable{
    private static final long serialVersionUID = 7032871751856788157L;
	
	public FindConsortiumGeneralLimitException(String msg){
		super(msg);
	}
	
	public FindConsortiumGeneralLimitException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public FindConsortiumGeneralLimitException(){
		super();
	} 
}
