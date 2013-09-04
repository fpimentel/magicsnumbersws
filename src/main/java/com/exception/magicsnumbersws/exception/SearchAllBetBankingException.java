package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SearchAllBetBankingException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SearchAllBetBankingException(String msg){
		super(msg);
	}
	
	public SearchAllBetBankingException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SearchAllBetBankingException(){
		super();
	}    
}
