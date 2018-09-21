package dao;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Task;

/**
 * Classe para obter/manipular os dados da tabela user
 */
public class TaskDAO extends baseDAO{

    // Insere nova task no Banco de dados
    public void insert(Task task){
        try(
                //Obtem a conexao com o BD
                Connection connection = getConnection();
                // Prepara o comando SQL
                PreparedStatement preparedStatement = connection.prepareStatement("insert into task(name,description) values(?,?)")
        ){
            // Substitiu o ? pela String
            preparedStatement.setString(1,task.getName());
            preparedStatement.setString(2,task.getDesc());
            preparedStatement.execute();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    // todo
    public List<Task> getAll(){
        List<Task> list = new ArrayList<>();

        //Obtem a conexao com o BD
        try(
            Connection connection = getConnection();
            Statement statement = connection.createStatement()
        ){
            // Executa a query
            ResultSet resultSet = statement.executeQuery("select 1, 2, 3");

            // Para cada resultado da query
            while(resultSet.next()){
                // Cria um novo objeto usuario
                Task user = new Task();

                // Obtem os valores dos campos, deve ser na mesma ordem informada na query
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setDesc(resultSet.getString(3));

                // Adiciona na lista
                list.add(user);
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return list;
    }

    // task by id
    public Task getById(long id){
        Task tarefa = null;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("select 1, 2, 3")
        ){
            statement.setLong(1,id);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                tarefa = new Task();

                tarefa.setId(resultSet.getLong(1));
                tarefa.setName(resultSet.getString(2));
                tarefa.setDesc(resultSet.getString(3));
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return tarefa;
    }

    // pega task by name
    public Task getByName(String name){
        Task tarefa = null;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("Script bd")
        ){
            statement.setString(1,name);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                tarefa = new Task();

                // Obtem os valores dos campos, deve ser na mesma ordem informada na query
                tarefa.setId(resultSet.getLong(1));
                tarefa.setName(resultSet.getString(2));
                tarefa.setDesc(resultSet.getString(3));
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return tarefa;
    }
    
    public Task getByUsernameAndPassword(String username, String password) {
    	final String sql = "SELECT * FROM USER WHERE NAME=? AND PASSWORD=?";
    	try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
    		statement.setString(1, username);
    		statement.setString(2, password);
    		final ResultSet rs = statement.executeQuery();
    		if(rs.next()) {
    			Task task = new Task();
    			task.setId(rs.getInt("ID"));
    			task.setName(rs.getString("NAME"));
    			task.setDesc(rs.getString("PASSWORD"));
    			return task;
    		}
    		
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }

}
