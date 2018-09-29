package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import authentication.NullFieldException;
import authentication.PasswordNotMatchException;
import authentication.userAlreadyExistException;
import dao.ConnectionFactory;
import dao.UserDAO;
import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import telas.ScreenUtil;
import telas.mapa;

public class registerController {
	
	@FXML
	private TextField regNick;
	@FXML
	private PasswordField regPass;
	@FXML
	private PasswordField regConfirmPass;
	
	@FXML
	private void backlogin() {
		ScreenUtil.getInstance().showScreen(mapa.login_fxml);
	}

    @FXML
    private void register() throws NullFieldException, PasswordNotMatchException {
    	
		try {
			CheckUserBanco(regNick.getText());
		} catch (userAlreadyExistException | SQLException e1) {
			e1.printStackTrace();
    		Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
            alert.setTitle("Erro");
	        alert.setContentText("Já existe um usuário com esse nick");
	        alert.showAndWait();
			return;
		}
    	
    	try {
    		
    		if (regNick.getText().equals("") || regPass.getText().equals("") || regConfirmPass.getText().equals("")) {
    			throw new NullFieldException("Campo em branco"); 
    		}
    	} catch(NullFieldException e) {
    		Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
            alert.setTitle("Erro");
	        alert.setContentText("Deixou um campo em branco");
	        alert.showAndWait();
	        return;
    	}
    	try {
    	
    	if(!regPass.getText().equals(regConfirmPass.getText())) {
    		throw new PasswordNotMatchException("Senhas diferentes");
    		}
    	}
    	catch(PasswordNotMatchException e) {
    		Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
            alert.setTitle("Erro");
	        alert.setContentText("As senhas digitadas são diferentes");
	        alert.showAndWait();
	        return;
    	}
    	UserDAO dao = UserDAO.getInstance();
    	User user = new User();
    	user.setUsername(regNick.getText());
    	user.setPassword(regPass.getText());
    	dao.salvar(user);
    	back();
    }
    @FXML
	private void back() {
		ScreenUtil.getInstance().showScreen(mapa.login_fxml);
	}
    
    private static void CheckUserBanco(String regNick) throws userAlreadyExistException, SQLException {
			Connection connection = ConnectionFactory.getConnection();
	        PreparedStatement st = connection.prepareStatement("select 1 from user where name=?");
	        st.setString(1, regNick);
	        ResultSet r1=st.executeQuery();
	         if(r1.next()) 
	         {
	        	 throw new userAlreadyExistException("Usuário já existe");
	         }
    }
 
}
	         