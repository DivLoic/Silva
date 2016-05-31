package fr.isep.reverse;

/**
 * Created by LoicMDIVAD on 26/12/2015.
 */
public class TooLazyStudentException extends Exception {

    public TooLazyStudentException(){
        super(  "\nThis Exception sets the boundaries of the Assignement.\n" +
                "For exemple a connection to a Postgres or SQLlite database is not implemented");
    }

    public TooLazyStudentException(String message){
        super();
    }

    public TooLazyStudentException(String message, Throwable cause){
        super(message, cause);
    }

    public TooLazyStudentException(Throwable cause){
        super(cause);
    }
}
