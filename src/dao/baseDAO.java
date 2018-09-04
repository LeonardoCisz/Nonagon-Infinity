package dao;

import java.sql.Connection;

//Classe dao para reduzir o acoplamento com a factory

public class baseDAO {

	Connection getConnection() {
		return ConnectionFactory.getConnection();
	}

}
