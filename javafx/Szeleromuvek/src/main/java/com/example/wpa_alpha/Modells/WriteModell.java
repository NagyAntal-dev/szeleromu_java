package com.example.wpa_alpha.Modells;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class WriteModell {
    private VBox container;

    private VBox filerBox;
    private Label title;
    private Label taskDescription;

    public VBox getWriteContainer() {return container;}

    public WriteModell( String title, String taskDescription){
        this.title = new Label(title);
        this.title.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        this.title.setPadding(new Insets(10,20,10,20));

        Label taskTitle = new Label("Feladat:");
        taskTitle.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 14));
        taskTitle.setPadding(new Insets(0,20,5,20));

        this.taskDescription = new Label(taskDescription);
        this.taskDescription.setFont(Font.font("Helvetica", 12));
        this.taskDescription.setPadding(new Insets(0,20,20,20));

        this.container = new VBox();
        this.container.getChildren().addAll(this.title, taskTitle , this.taskDescription);
    }
}
