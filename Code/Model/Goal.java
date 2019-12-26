package bsuir.Model;

import java.util.ArrayList;
import java.util.List;

public class Goal extends Element {

    private List<KeyResult> keyResults = new ArrayList<>();
    private int progress;

    public Goal(String description, int id) {
        super(description, id);
    }

    private void changeKeyResult(KeyResult keyResult){

    }

    private int getProgress(){
        return this.progress;
    }
}
