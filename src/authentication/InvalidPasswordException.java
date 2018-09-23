package authentication;

public class InvalidPasswordException extends AuthException{
	
	public InvalidPasswordException(String message) {
		super(message);
	}

}
