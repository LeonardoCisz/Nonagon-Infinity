package controller;

import dao.TaskDAO;
import entity.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
	private void login() {
		TaskDAO dao = new TaskDAO();
		Task task = dao.getByUsernameAndPassword(nicknameField.getText(), passFIeld.getText()); //isso eh um user
		if (task != null)
			System.out.println("Usuario logado " + task.getName());
	}

}
