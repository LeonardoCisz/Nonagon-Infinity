package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.taskDAO;
import entity.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import telas.ScreenUtil;
import telas.mapa;

public class saveTaskController {
	
	private Task t;
	
	@FXML
	private TextField nometarefa;
	
	@FXML
	private TextArea textotarefa;
	
	@FXML
	private Button salvartarefa;
	
	@FXML
	private Button cancelarTarefa;
	
	private Connection connection;
	
	private static final taskDAO dao = new taskDAO();
	
	@FXML
	private void back() {
		ScreenUtil.getInstance().showScreen(mapa.interface_fxml);
	}
	
	public void receiveTask(Task t) {
		this.t= t;
		nometarefa.setText(t.getName());
		textotarefa.setText(t.getDesc());
	}
	
	public void saveTask (ActionEvent actionEvent) throws SQLException, IOException {
        taskDAO dao = new taskDAO();
        
        if (this.t == null) {
        	t = new Task();
        	t.setDono(interfaceController.userLogado.getId());
        	t.setName(nometarefa.getText());
    	 	t.setDesc(textotarefa.getText());
        	dao.insertTarefa(t);
        } else {
        	t.setName(nometarefa.getText());
    	 	t.setDesc(textotarefa.getText());
        	dao.updateTarefa(t);
        }
        
        JOptionPane.showMessageDialog(null, "Tarefa inserida com sucesso.");
        ScreenUtil.getInstance().showScreen(mapa.interface_fxml);
	}
	 

}
