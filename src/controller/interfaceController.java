package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.InterfaceMain;
import app.Main;
import dao.taskDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import telas.ScreenUtil;
import telas.mapa;
import util.taskAdapter;
import util.taskViwer;


public class interfaceController implements Initializable {

    @FXML
    private TableView listatarefas;
    @FXML
    private Button includeTask ;
    @FXML
    private Button  editTask;
    @FXML
    private Button  excludeTask;


    @Override
    //TODO TA COM PAU ESTA MERDA!!!!1
    public void initialize(URL location, ResourceBundle resources) {

        taskDAO dao = new taskDAO();
        final ObservableList<taskViwer> listaTarefas = FXCollections
                .observableList(
                		taskAdapter.adaptarTodosParaView(dao.getTarefas()
                        )
                );

        TableColumn colunaNome = (TableColumn) listatarefas.getColumns().get(0);
        TableColumn colunaDesc = (TableColumn) listatarefas.getColumns().get(1);
        colunaNome.setCellValueFactory(new PropertyValueFactory<taskViwer, String>("nometarefa"));
        colunaDesc.setCellValueFactory(new PropertyValueFactory<taskViwer, String>("conteudotarefa"));

        listatarefas.setItems(listaTarefas);
    }
    
    @FXML
    private void includeTask() {
		System.out.println("Tentou aqui");
		
		ScreenUtil.getInstance().showScreen(mapa.includeTask_fxml);
		}
    
    @FXML
    public void editarTarefa() throws IOException {
    	
    	ScreenUtil.getInstance().showScreen(mapa.editTask_fxml);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarTarefa.fxml"));
//        Parent root = loader.load();
//        editTaskController editar = loader.getController();
//        taskViwer tView = (taskViwer) listatarefas.getSelectionModel().getSelectedItem();
//        
//        editar.load(taskAdapter.adaptarViewParaTarefa(tView));
    }

//    @FXML
//    public void editartarefa() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarTarefa.fxml"));
//        Parent root = loader.load();
//        EditarTarefaController editar = loader.getController();
//        taskViwer tView = (taskViwer) listatarefas.getSelectionModel().getSelectedItem();
//        Main.stage.setScene(new Scene(root, 800, 500));
//        editar.load(tarefaAdapter.adaptarViewParaTarefa(tView));
//    }
//
//    @FXML
//    public void deletartarefa() throws IOException {
//
//    	taskViwer tView = (taskViwer) listatarefas.getSelectionModel().getSelectedItem();
//        taskDAO dao = new taskDAO();
//        dao.deleteTarefa(tView.getId());
//        reload();
//        JOptionPane.showMessageDialog(null, "Informacoes deletadas com sucesso");
//    }
//
//    public void reload() throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("ListaTarefas.fxml"));
//        Main.stage.setScene(new Scene(root, 800, 500));
//    }

}
