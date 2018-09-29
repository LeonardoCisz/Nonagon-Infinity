package authentication;

public class PasswordNotMatchException extends Exception {

    public PasswordNotMatchException(String message) {
        super(message);
    }
}
