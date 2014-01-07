package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SaveWinningNumberDataException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SaveWinningNumberDataException(String msg){
		super(msg);
	}
	
	public SaveWinningNumberDataException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SaveWinningNumberDataException(){
		super();
	}    
}
