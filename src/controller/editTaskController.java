package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.taskDAO;
import entity.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import telas.ScreenUtil;
import telas.mapa;

public class editTaskController {
	
	 private Task t;

	    @FXML
	    private TextField nometarefa2;
	    @FXML
	    private HTMLEditor textotarefa2;
	    @FXML
	    private Button salvartarefaedit2;

	    public void load(Task t) {
	        this.t = t;
	        nometarefa2.setText(t.getName());
	        textotarefa2.setHtmlText(t.getDesc());
	    }
	    
	    @FXML
	    private void back() {
			ScreenUtil.getInstance().showScreen(mapa.login_fxml);
		}
	    
	    @FXML
	    public void saveTask2 (ActionEvent actionEvent) throws SQLException, IOException {

	        taskDAO dao = new taskDAO();
	        dao.updateTarefa(t);
	        JOptionPane.showMessageDialog(null, "Informacoes editadas com sucesso");
	        ScreenUtil.getInstance().showScreen(mapa.interface_fxml);

	    }

}
