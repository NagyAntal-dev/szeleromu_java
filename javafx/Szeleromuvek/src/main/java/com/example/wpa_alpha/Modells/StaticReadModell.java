package com.example.wpa_alpha.Modells;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class StaticReadModell {

    private VBox tableHolder;
    private VBox container;
    private Label title;
    private Label taskDescription;

    public VBox getContainer() {return container;}

    public StaticReadModell(ArrayList<String> columnHeaders, String title, String taskDescription){
        this.title = new Label(title);
        this.title.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        this.title.setPadding(new Insets(10,0,10,20));

        Label taskTitle = new Label("Feladat:");
        taskTitle.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 14));
        taskTitle.setPadding(new Insets(0,0,5,20));

        this.taskDescription = new Label(taskDescription);
        this.taskDescription.setFont(Font.font("Helvetica", 12));
        this.taskDescription.setPadding(new Insets(0,0,20,20));


        this.tableHolder = new VBox();
        this.tableHolder.setAlignment(Pos.CENTER);
        this.container = new VBox();
        this.tableHolder.getChildren().addAll(createTableView(columnHeaders));
        this.container.getChildren().addAll(this.title, taskTitle , this.taskDescription, tableHolder);
    }

    public TableView createTableView(ArrayList<String> columnHeaders){
        TableView tableView = new TableView<>();
        for(String columnHeader : columnHeaders){
            TableColumn tableColumn = new TableColumn<>(columnHeader);
            tableView.getColumns().add(tableColumn);
        }
        //tableView.setMaxSize(500,500);
        return tableView;
    }

}
