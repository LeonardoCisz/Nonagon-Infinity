package app;

import dao.TaskDAO;
import entity.Task;

public class Main {

	public static void main(String[] args) {
		
		Task task = new Task();
		
		task.setName("Matar o magnetico");
		task.setDesc("Descrevendo como matar o magnetico");
		
		TaskDAO dao = new TaskDAO();
		
		for(Task x : dao.getAll()) {
			System.out.println(x);
		}
	}

}
