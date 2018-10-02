package telas;

import java.io.IOException;

import authentication.NullFieldException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;


public class ScreenUtil {
	
	private static final ScreenUtil screenUtil = new ScreenUtil();
    private static Stage stage = new Stage();
    
    private ScreenUtil() {
    	
    }
    
    public static ScreenUtil getInstance() {
    	return ScreenUtil.screenUtil;
    	
    }
    
    public void showScreen(String path) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(path));
    		//new JMetro(JMetro.Style.LIGHT).applyTheme(root);
    		stage.setScene(new Scene(root));
    		stage.show();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
   
    public void newScreen(String path) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(path));
            stage.close();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void validateTextField(TextField textField) throws NullFieldException {
        if (textField.getText().equals("")) {
            throw new NullFieldException("The TextField " + textField.getId() + " is not filled.");
        }
    }
    
    public Stage getStage() {
    	return stage;
    }
    
}
