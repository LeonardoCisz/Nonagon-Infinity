package util;

import java.util.ArrayList;
import java.util.List;

import entity.Task;

public class taskAdapter {
	
	public static taskViwer adpaptarParaView(Task t) {
        return new taskViwer(t.getId(), t.getName(), t.getDesc());
    }

    public static Task adaptarViewParaTarefa(taskViwer tv) {
        Task t = new Task();
        t.setId(tv.getId());
        t.setName(tv.getNometarefa());
        t.setDesc(tv.getConteudotarefa());
        return t;
    }

    public static List<taskViwer> adaptarTodosParaView(List<Task> tarefasList) {
        List<taskViwer> lista = new ArrayList<taskViwer>();
        for (Task t : tarefasList) {
            lista.add(new taskViwer(t.getId(), t.getName(), t.getDesc()));
        }
        return lista;
    }


}
