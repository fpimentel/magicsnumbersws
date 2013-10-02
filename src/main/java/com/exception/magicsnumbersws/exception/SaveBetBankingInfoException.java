package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SaveBetBankingInfoException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SaveBetBankingInfoException(String msg){
		super(msg);
	}
	
	public SaveBetBankingInfoException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SaveBetBankingInfoException(){
		super();
	}    
}
