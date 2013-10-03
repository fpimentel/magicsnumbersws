package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SaveBetBankingBetLimitException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SaveBetBankingBetLimitException(String msg){
		super(msg);
	}
	
	public SaveBetBankingBetLimitException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SaveBetBankingBetLimitException(){
		super();
	}    
}
