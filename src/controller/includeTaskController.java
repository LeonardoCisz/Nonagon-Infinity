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

public class includeTaskController {
	
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
	
	 public void insertTask (ActionEvent actionEvent) throws SQLException, IOException {

	        taskDAO dao = new taskDAO();
	        dao.insertTarefa(t);
	        JOptionPane.showMessageDialog(null, "Tarefa salva com sucesso.");
	        ScreenUtil.getInstance().showScreen(mapa.interface_fxml);

	    }
	
	
//    @FXML
    //TODO TA COM PAU ESTA MERDA
//    public void insertTask (Task task) {
//    	
//    	System.out.println("testeteste");
//
//    	final String sql = "INSERT INTO TASK(NAME,DESCRICAO) VALUES(?,?)";
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setString(1, task.getName());
//			stmt.setString(2, task.getDesc());
//			stmt.execute();
//			JOptionPane.showMessageDialog(null, "Tarefa Salva!");
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Erro ao salvar a tarefa,  tente novamente");
//		}
//    }
	
}
