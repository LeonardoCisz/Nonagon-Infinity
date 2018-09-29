package util;

import javafx.beans.property.SimpleStringProperty;

public class taskViwer {

    private int id;
    private SimpleStringProperty nometarefa;
    private SimpleStringProperty conteudotarefa;

    public taskViwer(Long id, String Name, String conteudotarefa) {
        this.nometarefa = new SimpleStringProperty(Name);
        this.conteudotarefa = new SimpleStringProperty(conteudotarefa);
        this.id = id;
    }

    public String getNometarefa() {
        return nometarefa.get();
    }

    public String getConteudotarefa() {
        return conteudotarefa.get();
    }

    public int getId() {
        return id;
    }

}
