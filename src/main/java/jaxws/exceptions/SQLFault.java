package jaxws.exceptions;

public class SQLFault {
    private static final String DEFAULT_MESSAGE = "An error occurred during sql query";

    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static SQLFault defaultInstance() {
        SQLFault fault = new SQLFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
