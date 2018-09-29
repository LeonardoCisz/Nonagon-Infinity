package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
    public void initialize(URL location, ResourceBundle resources) {

        taskDAO dao = new taskDAO();
        final ObservableList<taskViwer> listaTarefas = FXCollections
                .observableList(
                		taskViwer.adaptarTodosParaView(dao.getTarefas()
                        )
                );

        TableColumn colunaNome = (TableColumn) listatarefas.getColumns().get(0);
        TableColumn colunaDesc = (TableColumn) listatarefas.getColumns().get(1);
        colunaNome.setCellValueFactory(new PropertyValueFactory<taskViwer, String>("nometarefa"));
        colunaDesc.setCellValueFactory(new PropertyValueFactory<taskViwer, String>("conteudotarefa"));

        listatarefas.setItems(listaTarefas);
    }

    @FXML
    public void homehome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        Main.stage.setScene(new Scene(root, 800, 500));
    }

    @FXML
    public void incluirtarefa3() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IncluirTarefa.fxml"));
        Main.stage.setScene(new Scene(root, 800, 500));
    }


    @FXML
    public void editartarefa() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarTarefa.fxml"));
        Parent root = loader.load();
        EditarTarefaController editar = loader.getController();
        taskViwer tView = (taskViwer) listatarefas.getSelectionModel().getSelectedItem();
        Main.stage.setScene(new Scene(root, 800, 500));
        editar.load(tarefaAdapter.adaptarViewParaTarefa(tView));
    }

    @FXML
    public void deletartarefa() throws IOException {

    	taskViwer tView = (taskViwer) listatarefas.getSelectionModel().getSelectedItem();
        taskDAO dao = new taskDAO();
        dao.deleteTarefa(tView.getId());
        reload();
        JOptionPane.showMessageDialog(null, "Informacoes deletadas com sucesso");
    }

    public void reload() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ListaTarefas.fxml"));
        Main.stage.setScene(new Scene(root, 800, 500));
    }

}
