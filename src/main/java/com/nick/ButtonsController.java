package com.nick;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class ButtonsController {

    public void restartGame(){
        Board board = App.getBoard();
        board.reset();
    }

    public void buttonClick(@SuppressWarnings("exports") ActionEvent event){
        Board board = App.getBoard();
        Button button = (Button) event.getSource();
        String pos = button.getId();

        if (button.getText() == ""){
            board.put(pos);
        }
    }

}