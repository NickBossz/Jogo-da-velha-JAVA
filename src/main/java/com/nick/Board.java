package com.nick;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Board {
    
    private int xPunc;
    private int oPunc;
    private Scene scene;

    private int cellsClicked;

    private String turnOf = null;

    private Button c1l1;
    private Button c1l2;
    private Button c1l3;
    
    private Button c2l1;
    private Button c2l2;
    private Button c2l3;
    
    private Button c3l1;
    private Button c3l2;
    private Button c3l3;

    private Button restartButton;

    public Board(@SuppressWarnings("exports") Scene board){
        scene = board;

        c1l1 = (Button) LabelsController.getNode(board, "c1l1");
        c1l2 = (Button) LabelsController.getNode(board, "c1l2");
        c1l3 = (Button) LabelsController.getNode(board, "c1l3");
        
        c2l1 = (Button) LabelsController.getNode(board, "c2l1");
        c2l2 = (Button) LabelsController.getNode(board, "c2l2");
        c2l3 = (Button) LabelsController.getNode(board, "c2l3");
        
        c3l1 = (Button) LabelsController.getNode(board, "c3l1");
        c3l2 = (Button) LabelsController.getNode(board, "c3l2");
        c3l3 = (Button) LabelsController.getNode(board, "c3l3");
        
        restartButton = (Button) LabelsController.getNode(scene, "restart");
    }

    public void put(String pos){

        String color;

        if (turnOf == null) {
            turnOf = "x";
            color = "#ff0000";
        } else if (turnOf == "x") {
            turnOf = "o";
            color = "#00d9ff";
        } else if (turnOf == "o") {
            turnOf = "x";
            color = "#ff0000";
        } else {
            turnOf = "x";
            color = "#ff0000";
        }


        Button buttonClicked = (Button) LabelsController.getNode(scene, pos);
        buttonClicked.setText(turnOf.toUpperCase());
        buttonClicked.setTextFill(Color.web(color));
        String winner = checkWinner();
        cellsClicked += 1;

        if (winner != null) {
            win(winner);
        } else if (cellsClicked == 9){
            c1l1.setDisable(true);
            c1l2.setDisable(true);
            c1l3.setDisable(true);
    
            c2l1.setDisable(true);
            c2l2.setDisable(true);
            c2l3.setDisable(true);
    
            c3l1.setDisable(true);
            c3l2.setDisable(true);
            c3l3.setDisable(true);
    
            restartButton.setDisable(false);
    
            Text label = (Text) LabelsController.getNode(scene, "vencedor");
            label.setText("DRAW!");
        }
    }

    private void win(String winner){
        c1l1.setDisable(true);
        c1l2.setDisable(true);
        c1l3.setDisable(true);

        c2l1.setDisable(true);
        c2l2.setDisable(true);
        c2l3.setDisable(true);

        c3l1.setDisable(true);
        c3l2.setDisable(true);
        c3l3.setDisable(true);

        restartButton.setDisable(false);

        Text label = (Text) LabelsController.getNode(scene, "vencedor");
        label.setText("WINNER: " + winner);

        if (winner.equalsIgnoreCase("x")) {
            setXPunc(getXPunc() + 1 );
        } else if (winner.equalsIgnoreCase( "o")) {
            setOPunc(getOPunc() + 1 );
        }
    }

    public String checkWinner(){
        if (c1l1.getText().equalsIgnoreCase(c1l2.getText()) && c1l2.getText().equalsIgnoreCase(c1l3.getText()) && !c1l1.getText().equalsIgnoreCase("")) {
            return c1l1.getText();
        } else if (c2l1.getText().equalsIgnoreCase(c2l2.getText()) && c2l2.getText().equalsIgnoreCase(c2l3.getText()) && !c2l1.getText().equalsIgnoreCase("")){
            return c2l1.getText();
        } else if (c3l1.getText().equalsIgnoreCase(c3l2.getText()) && c3l2.getText().equalsIgnoreCase(c3l3.getText()) && !c3l1.getText().equalsIgnoreCase("")){
            return c3l1.getText();
        }

        if (c1l1.getText().equalsIgnoreCase(c2l1.getText()) && c2l1.getText().equalsIgnoreCase(c3l1.getText()) && !c1l1.getText().equalsIgnoreCase("")){
            return c1l1.getText();
        } else if (c1l2.getText().equalsIgnoreCase(c2l2.getText()) && c2l2.getText().equalsIgnoreCase(c3l2.getText()) && !c1l2.getText().equalsIgnoreCase("")){
            return c1l2.getText();
        } else if (c1l3.getText().equalsIgnoreCase(c2l3.getText()) && c2l3.getText().equalsIgnoreCase(c3l3.getText()) && !c1l3.getText().equalsIgnoreCase("")) {
            return c1l3.getText();
        }

        if (c1l1.getText().equalsIgnoreCase(c2l2.getText()) && c2l2.getText().equalsIgnoreCase(c3l3.getText()) && !c1l1.getText().equalsIgnoreCase("")){
            return c1l1.getText();
        } else if (c1l3.getText().equalsIgnoreCase(c2l2.getText()) && c2l2.getText().equalsIgnoreCase(c3l1.getText()) && !c1l3.getText().equalsIgnoreCase("")) {
            return c1l3.getText();
        }

        return null;
    }

    public void reset(){
        c1l1.setText("");
        c1l1.setDisable(false);
        
        c1l2.setText("");
        c1l2.setDisable(false);

        c1l3.setText("");
        c1l3.setDisable(false);

        c2l1.setText("");
        c2l1.setDisable(false);

        c2l2.setText("");
        c2l2.setDisable(false);

        c2l3.setText("");
        c2l3.setDisable(false);


        c3l1.setText("");
        c3l1.setDisable(false);

        c3l2.setText("");
        c3l2.setDisable(false);

        c3l3.setText("");
        c3l3.setDisable(false);


        Text label = (Text) LabelsController.getNode(scene, "vencedor");
        label.setText("");

        restartButton.setDisable(true);

        cellsClicked = 0;
    }

    public int getXPunc() {
        return this.xPunc;
    }

    public void setXPunc(int xPunc) {
        this.xPunc = xPunc;

        Text label = (Text) LabelsController.getNode(scene, "xPunc");
        label.setText(String.valueOf(xPunc));

    }

    public int getOPunc() {
        return this.oPunc;
    }

    public void setOPunc(int oPunc) {
        this.oPunc = oPunc;

        Text label = (Text) LabelsController.getNode(scene, "oPunc");
        label.setText(String.valueOf(oPunc));

    }

    

}