package com.exception.magicsnumbersws.exception;
import java.io.Serializable;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
/**
 *
 * @author fpimentel
 */
public class SaveTicketException extends WebApplicationException implements Serializable{
        private static final long serialVersionUID = 7032871751856788157L;

    public SaveTicketException() {
    }

    public SaveTicketException(Response response) {
        super(response);
    }

    public SaveTicketException(int status) {
        super(status);
    }

    public SaveTicketException(Response.Status status) {
        super(status);
    }

    public SaveTicketException(Throwable cause) {
        super(cause);
    }

    public SaveTicketException(Throwable cause, int status) {
        super(cause, status);
    }

    public SaveTicketException(Throwable cause, Response.Status status) {
        super(cause, status);
    }
	
	   
}
