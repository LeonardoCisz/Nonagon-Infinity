package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	/**
	 * Configurações com o banco de dados Mysql
	 */

	private final static String dataBaseName = "justdoit";
	private final static String dataBaseUser = "root";
	private final static String dataBasePassword = "root";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(String.format("jdbc:mysql://localhost:3306/%s?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", dataBaseName), dataBaseUser,
					dataBasePassword);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
