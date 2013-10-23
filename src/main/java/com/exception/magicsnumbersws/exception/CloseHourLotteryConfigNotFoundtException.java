package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class CloseHourLotteryConfigNotFoundtException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public CloseHourLotteryConfigNotFoundtException(String msg){
		super(msg);
	}
	
	public CloseHourLotteryConfigNotFoundtException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public CloseHourLotteryConfigNotFoundtException(){
		super();
	}    
}
