package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class SaveLotteryException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public SaveLotteryException(String msg){
		super(msg);
	}
	
	public SaveLotteryException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public SaveLotteryException(){
		super();
	}    
}
