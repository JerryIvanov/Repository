package Calc.Methods;

public class CustomException extends Exception {

    private static final Exception excep = new CustomException();

    public static Exception getException() throws Exception {
        throw excep;
    }
}
