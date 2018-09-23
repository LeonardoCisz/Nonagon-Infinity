package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

/**
 * Classe para obter/manipular os dados da tabela user
 */
public class UserDAO extends baseDAO{
	
	private Connection connection;
	private static final UserDAO dao = new UserDAO();
	
	public UserDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public static UserDAO getInstance() {
		return dao;
	}
	
	public void salvar(User user) {
		final String sql = "INSERT INTO USER(NAME,PASSWORD) VALUES(?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.execute();
				
			}catch(SQLException e) {
				e.printStackTrace();
		}
	}
  
    public User getByUsernameAndPassword(String username, String password) {
    	final String sql = "SELECT * FROM USER WHERE NAME=? AND PASSWORD=?";
    	try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
    		statement.setString(1, username);
    		statement.setString(2, password);
    		final ResultSet rs = statement.executeQuery();
    		if(rs.next()) {
    			User user = new User();
    			user.setId(rs.getInt("ID"));
    			user.setName(rs.getString("NAME"));
    			user.setPassword(rs.getString("PASSWORD"));
    			return user;
    		}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
	
    public User findByUsername(String username) {
        final String sql = "SELECT * FROM USER WHERE NAME=?";
        User user = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("ID"));
                user.setUsername(rs.getString("NAME"));
                user.setPassword(rs.getString("PASSWORD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
