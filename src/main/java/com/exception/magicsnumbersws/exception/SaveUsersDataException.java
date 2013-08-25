package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SaveUsersDataException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SaveUsersDataException(String msg){
		super(msg);
	}
	
	public SaveUsersDataException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SaveUsersDataException(){
		super();
	}    
}
