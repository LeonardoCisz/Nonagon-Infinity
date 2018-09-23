package authentication;

import dao.UserDAO;
import entity.User;

public class UserAuthentication {
	
private UserDAO dao;
	
	public UserAuthentication(UserDAO dao) {
		this.dao = dao;
	}
	
	public void auth(String username, String password) throws AuthException {
		User user = dao.findByUsername(username);
		if(user==null) {
			throw new UserNotRegisteredException(String.format("O usu�rio informado %s n�o foi encontrado", username));
		}
		if (!user.getPassword().equals(password)) {
			throw new InvalidPasswordException(String.format("A senha n�o � v�lida.", username));
		}
	}
}
