package bsuir.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class Element {

    private int id;
    private String description;


    public Element(String description,int id){
        this.id = id;
        this.description = description;
            }

    public String getDescription(){
        return description;
    }

    public int getId(){
        return id;
    }

    private void changeDescription(String description){
        this.description = description;
    }
}
