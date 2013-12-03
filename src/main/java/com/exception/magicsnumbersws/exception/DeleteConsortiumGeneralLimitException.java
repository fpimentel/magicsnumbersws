package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class DeleteConsortiumGeneralLimitException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public DeleteConsortiumGeneralLimitException(String msg){
		super(msg);
	}
	
	public DeleteConsortiumGeneralLimitException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public DeleteConsortiumGeneralLimitException(){
		super();
	}    
}
