package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import dao.taskDAO;
import entity.Task;
import entity.User;
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
import javafx.stage.Stage;
import telas.ScreenUtil;
import telas.mapa;
import util.taskAdapter;
import util.taskViwer;


public class interfaceController implements Initializable {

    @FXML
    private TableView<taskViwer> listatarefas;
    @FXML
    private Button includeTask ;
    @FXML
    private Button  editTask;
    @FXML
    private Button  excludeTask;

    public static User userLogado;

    @Override
    //TODO TA COM PAU ESTA MERDA!!!!1
    public void initialize(URL location, ResourceBundle resources) {

        taskDAO dao = new taskDAO();
        final ObservableList<taskViwer> listaTarefas = FXCollections
                .observableList(
                		taskAdapter.adaptarTodosParaView(dao.getTarefas(userLogado.getId())
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
    	taskViwer v = listatarefas.getSelectionModel().getSelectedItem();
    	showEdit(taskAdapter.adaptarViewParaTarefa(v));
    }


    @FXML
    public void deletTask() throws IOException {

    	taskViwer tView = (taskViwer) listatarefas.getSelectionModel().getSelectedItem();
        taskDAO dao = new taskDAO();
        dao.deleteTarefa(tView.getId());
        reload();
        JOptionPane.showMessageDialog(null, "Informacoes deletadas com sucesso");
    }
    
    private void showEdit(Task t) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("telas/telasFXML/IncludeTask.fxml"));
    	Parent root = loader.load();
    	saveTaskController controller = loader.getController();
    	controller.receiveTask(t);
    	Stage stage = ScreenUtil.getInstance().getStage();
    	stage.setScene(new Scene(root));
		stage.show();
    }

    public void reload() {
    	ScreenUtil.getInstance().showScreen(mapa.interface_fxml);
    }
}
