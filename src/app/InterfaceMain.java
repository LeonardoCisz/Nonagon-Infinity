package app;

import controller.loginController;
import javafx.application.Application;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class InterfaceMain extends Application {
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		new loginController().show();
	
	}

}
