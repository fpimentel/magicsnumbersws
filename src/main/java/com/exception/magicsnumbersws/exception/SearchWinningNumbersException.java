package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author cpimentel
 */
public class SearchWinningNumbersException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SearchWinningNumbersException(String msg){
		super(msg);
	}
	
	public SearchWinningNumbersException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SearchWinningNumbersException(){
		super();
	}    
}
