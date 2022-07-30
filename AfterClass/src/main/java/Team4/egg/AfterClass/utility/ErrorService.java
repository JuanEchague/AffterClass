package Team4.egg.AfterClass.utility;

public class ErrorService extends Exception{
    private static final long serialVersionUID = 7883636384872015753L;

    public ErrorService(String msn) {
        super(msn);
    }
}
