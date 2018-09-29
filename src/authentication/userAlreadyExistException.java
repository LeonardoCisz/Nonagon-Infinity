package authentication;

public class userAlreadyExistException extends Exception {
	
    public userAlreadyExistException(String message) {
        super(message);
    }
}
