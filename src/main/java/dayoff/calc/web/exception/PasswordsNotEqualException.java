package dayoff.calc.web.exception;

/**
 * Created by mac on 02.08.17.
 */
public class PasswordsNotEqualException extends RuntimeException {
    public PasswordsNotEqualException() {
        super("First and second passwords aren't equal. Try one more.");
    }
}
