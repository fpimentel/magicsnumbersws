package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class DeleteBetBankingBetLimitException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public DeleteBetBankingBetLimitException(String msg){
		super(msg);
	}
	
	public DeleteBetBankingBetLimitException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public DeleteBetBankingBetLimitException(){
		super();
	}    
}
