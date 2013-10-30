package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
/**
 *
 * @author fpimentel
 */
public class FindBetException extends WebApplicationException implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;

    public FindBetException() {
    }

    public FindBetException(Response response) {
        super(response);
    }

    public FindBetException(int status) {
        super(status);
    }

    public FindBetException(Response.Status status) {
        super(status);
    }

    public FindBetException(Throwable cause) {
        super(cause);
    }

    public FindBetException(Throwable cause, int status) {
        super(cause, status);
    }

    public FindBetException(Throwable cause, Response.Status status) {
        super(cause, status);
    }
	
	   
}
