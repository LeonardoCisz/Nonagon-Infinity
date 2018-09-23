package app;

import dao.UserDAO;
import entity.Task;

public class Main {

	public static void main(String[] args) {
		
		Task task = new Task();
		
		task.setName("Matar o magnetico");
		task.setDesc("Descrevendo como matar o magnetico");
		
		UserDAO dao = new UserDAO();
		

	}
}
