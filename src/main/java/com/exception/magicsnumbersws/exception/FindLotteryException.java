package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
/**
 *
 * @author fpimentel
 */
public class FindLotteryException extends Exception implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;
	
	public FindLotteryException(String msg){
		super(msg);
	}
	
	public FindLotteryException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public FindLotteryException(){
		super();
	}    
}
