package controller;

import dao.UserDAO;
import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import telas.NullFieldException;
import telas.PasswordNotMatchException;
import telas.ScreenUtil;
import telas.mapa;

public class registerController {
	
	@FXML
	private TextField regName;
	@FXML
	private TextField regNick;
	@FXML
	private PasswordField regPassword;
	@FXML
	private PasswordField regConfirmPass;
	
	@FXML
	private void backlogin() {
		ScreenUtil.getInstance().showScreen(mapa.login_fxml);
	}

    @FXML
    private void register() {
    	
    	System.out.println("User tomo na jabiroca");
    	
    	//    		validateFields();
		//            validatePassword();
		            UserDAO dao = UserDAO.getInstance();
		            User user = new User();
		            user.setUsername(regNick.getText());
		            user.setPassword(regPassword.getText());
		            dao.salvar(user);
		//            backlogin();
		//            
		//        } catch (NullFieldException e) {
		//            System.out.println(e.getMessage());
    }
	
//	private void validateFields() throws {
//		ScreenUtil.getInstance().validateTextField(regName);
//		ScreenUtil.getInstance().validateTextField(regNick);
//		ScreenUtil.getInstance().validateTextField(regPassword);
//		ScreenUtil.getInstance().validateTextField(regConfirmPass);
//	}
	
    private void validatePassword() throws PasswordNotMatchException {
        if (!regPassword.getText().equals(regConfirmPass.getText())) {
            throw new PasswordNotMatchException("Senhas diferentes! As senhas precisam ser iguais.");
        }
    }

}
