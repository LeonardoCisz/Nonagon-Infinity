package app;

import dao.ConnectionFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceMain extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		ConnectionFactory.getConnection();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("telas/login.fxml"));
		arg0.setScene(new Scene(root));
		arg0.show();
	}

}
