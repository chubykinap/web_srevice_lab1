package jaxws.exceptions;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "jaxws.exceptions.SQLFault")
public class SQLTransactionException extends Exception {
    private static final long serialVersionUID = 0;
    private final SQLFault fault;

    public SQLFault getFaultInfo() {
        return fault;
    }

    public SQLTransactionException(String message, SQLFault fault) {
        super(message);
        this.fault = fault;
    }

    public SQLTransactionException(String message, SQLFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }
}
