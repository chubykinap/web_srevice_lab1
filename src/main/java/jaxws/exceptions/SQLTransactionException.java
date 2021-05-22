package jaxws.exceptions;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "jaxws.exceptions.MyFault")
public class SQLTransactionException extends Exception {
    private static final long serialVersionUID = 0;
    private final MyFault fault;

    public MyFault getFaultInfo() {
        return fault;
    }

    public SQLTransactionException(String message, MyFault fault) {
        super(message);
        this.fault = fault;
    }

    public SQLTransactionException(String message, MyFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }
}
