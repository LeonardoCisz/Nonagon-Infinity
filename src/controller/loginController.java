package controller;

import authentication.AuthException;
import authentication.NullFieldException;
import authentication.UserAuthentication;
import dao.UserDAO;
import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import telas.ScreenUtil;
import telas.mapa;

public class loginController{

	@FXML
	private TextField nicknameField;
	@FXML
	private PasswordField passFIeld;
	@FXML
	private Button registerButton;
	@FXML
	private Button loginButton;
	
	@FXML
	private void login() throws NullFieldException {
		try {
			//validateFields();
			UserAuthentication auth = new UserAuthentication(UserDAO.getInstance());
			auth.auth(nicknameField.getText(), passFIeld.getText());
			UserDAO dao = new UserDAO();
			User user = dao.getByUsernameAndPassword(nicknameField.getText(), passFIeld.getText()); //isso eh um user
			if (user != null) {
				System.out.println("Usuario logado " + user.getName());
				interfaceController.userLogado = user;
				ScreenUtil.getInstance().showScreen(mapa.interface_fxml);
			}
		}catch(AuthException e) {
			System.out.println(e.getMessage());
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
            alert.setTitle("Erro - Usu�rio n�o cadastrado ou informa��es inv�lidas");
	        alert.setContentText(e.getMessage());
	        alert.showAndWait();
	        return;
		}
		System.out.println("Ee p@rr, passamo");
	}
	
	@FXML
	private void registrar() {
		System.out.println("Tentou aqui");
		
		ScreenUtil.getInstance().showScreen(mapa.register_fxml);
		}
	
	@FXML
	public void show() {
		ScreenUtil.getInstance().showScreen(mapa.login_fxml);
	}
	



}
