package com.nick;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;

public class LabelsController {
    
    public static void changeText(@SuppressWarnings("exports") Scene scene, String id, String text){
        for (javafx.scene.Node node : scene.getRoot().getChildrenUnmodifiable()) {
            if (node.getId() == null) {continue;}
            if (node.getId().equalsIgnoreCase(id)){
                ((Labeled) node).setText(text.toUpperCase());
            }
        }
    }

    @SuppressWarnings("exports")
    public static Node getNode(Scene scene, String id){
        for (javafx.scene.Node node : scene.getRoot().getChildrenUnmodifiable()) {
            if (node.getId() == null) {continue;}
            if (node.getId().equalsIgnoreCase(id)){
                return node;
            }
        }
        return null;
    }

}
