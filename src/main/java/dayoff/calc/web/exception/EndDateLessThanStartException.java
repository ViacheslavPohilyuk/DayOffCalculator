package dayoff.calc.web.exception;

/**
 * Created by mac on 16.08.17.
 */
public class EndDateLessThanStartException extends RuntimeException {
    public EndDateLessThanStartException() {
        super("Sorry, but end date must be bigger than start date");
    }
}
