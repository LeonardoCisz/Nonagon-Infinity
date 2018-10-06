package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Task;

public class taskDAO extends baseDAO{
	
	private Connection connection;
	private static final taskDAO dao = new taskDAO();
	
	public taskDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public static taskDAO getInstance() {
		return dao;
	}
	
	public void insertTarefa(Task task) {
		final String sql = "INSERT INTO TASK(NAME,DESCRICAO, DONO) VALUES(?,?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, task.getName());
			stmt.setString(2, task.getDesc());
			stmt.setInt(3, task.getDono());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	   public void deleteTarefa(long l) {
	        try {
	            Connection conn = ConnectionFactory.getConnection();
	            PreparedStatement p = conn.prepareStatement("delete from task where id=?");
	            p.setLong(1, l);
	            p.execute();
	            p.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   
	    public void updateTarefa(Task t) {
	        try {
	            Connection conn = ConnectionFactory.getConnection();
	            PreparedStatement p = conn.prepareStatement("update task set name=?, descricao=? where id=?");
	            p.setString(1, t.getName());
	            p.setString(2, t.getDesc());
	            p.setLong(3, t.getId());	
	            p.execute();
	            p.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public List<Task> getTarefas(Integer dono) {
	        Connection conn = ConnectionFactory.getConnection();
	        List<Task> todasTarefas = null;
	        try {
	            PreparedStatement p = conn.prepareStatement("SELECT * FROM task where dono = ?");
	            p.setInt(1, dono);
	            ResultSet rs = p.executeQuery();
	            todasTarefas = new ArrayList<>();
	            while (rs.next()) {
	                Task t = new Task();
	                t.setId(rs.getInt("ID"));
	                t.setName(rs.getString("NAME"));
	                t.setDesc(rs.getString("DESCRICAO"));
	                todasTarefas.add(t);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return todasTarefas;
	        
	    }
	
}