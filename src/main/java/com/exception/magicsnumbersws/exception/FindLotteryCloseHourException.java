package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class FindLotteryCloseHourException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public FindLotteryCloseHourException(String msg){
		super(msg);
	}
	
	public FindLotteryCloseHourException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public FindLotteryCloseHourException(){
		super();
	}    
}
