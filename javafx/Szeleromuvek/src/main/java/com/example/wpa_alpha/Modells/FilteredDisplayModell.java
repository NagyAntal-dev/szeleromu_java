package com.example.wpa_alpha.Modells;

import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class FilteredDisplayModell {
    private VBox tableHolder;
    private VBox container;

    private VBox filerBox;
    private Label title;
    private Label taskDescription;

    private Button button;

    private TextField townTextField;
    private  Label seged;

    private ComboBox<Integer> idComboBox;

    private ComboBox<String> countyComboBox;

    private ToggleGroup toggleGroup;

    public VBox getFilteredContainer() {return container;}

    public FilteredDisplayModell(ArrayList<String> columnHeaders, String title, String taskDescription){

        createFilterBox();

        this.title = new Label(title);
        this.title.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 25));
        this.title.setPadding(new Insets(10,20,10,20));

        Label taskTitle = new Label("Feladat:");
        taskTitle.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 14));
        taskTitle.setPadding(new Insets(0,20,5,20));

        this.taskDescription = new Label(taskDescription);
        this.taskDescription.setFont(Font.font("Helvetica", 12));
        this.taskDescription.setPadding(new Insets(0,20,20,20));

        Label tableTitle = new Label("Táblázat adatai:");
        tableTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
        tableTitle.setPadding(new Insets(20,0,10,20));

        this.tableHolder = new VBox();
        this.tableHolder.setAlignment(Pos.CENTER);
        this.container = new VBox();
        this.tableHolder.getChildren().addAll(createTableView(columnHeaders));
        StackPane stackPane = new StackPane();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(this.tableHolder);
        //scrollPane.setFitToHeight(true);
        stackPane.getChildren().addAll(scrollPane);
        stackPane.setAlignment(Pos.BASELINE_CENTER);
        stackPane.paddingProperty().set(new Insets(0, 20,0, 20));
        scrollPane.setFitToWidth(true);
        this.seged = new Label();
        this.seged.setText("Segéd");
        this.container.getChildren().addAll(this.title, taskTitle , this.taskDescription, filerBox, tableTitle,stackPane,seged);
    }

    public TableView createTableView(ArrayList<String> columnHeaders){
        TableView tableView = new TableView<>();
        for(String columnHeader : columnHeaders){
            TableColumn tableColumn = new TableColumn<>(columnHeader);
            tableView.getColumns().add(tableColumn);
        }
        return tableView;
    }

    public void createFilterBox(){
        this.filerBox = new VBox();
        Label mainTitle = new Label("Szűrés mező");
        mainTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));

        //Település nevére szűréshez
        VBox townVbox = new VBox();
        Label townLabel = new Label("Szűrés településnév alapján!");
        this.townTextField = new TextField();
        townTextField.setMaxWidth(200);
        townLabel.setPadding(new Insets(0,0,5,0));
        townTextField.promptTextProperty().set("Adjon meg egy település nevet");
        townVbox.getChildren().addAll(townLabel, townTextField);
        townVbox.setPadding(new Insets(0,0,10,0));
        //Hbox a lenyiló listáknak
        HBox comboHBox = new HBox();

        //Vbox az id lenyíló listának
        VBox idPickerBox = new VBox();
        Label idTitle = new Label("Szűrés azonosító alapján");
        idTitle.setPadding(new Insets(0,0,5,0));
        this.idComboBox = new ComboBox<>();
        idComboBox.setPrefWidth(200);
        idComboBox.getItems().add(1);
        idPickerBox.getChildren().addAll(idTitle,idComboBox);
        idPickerBox.setPadding(new Insets(0,20,0,0));

        //Vbox megye lenyíló listának
        VBox countyPickerBox = new VBox();
        Label countyTitle = new Label("Szűrés megyenév alapján");
        countyTitle.setPadding(new Insets(0,0,5,0));
        this.countyComboBox = new ComboBox<>();
        countyComboBox.setPrefWidth(200);
        countyComboBox.getItems().add("Jézus");
        countyPickerBox.getChildren().addAll(countyTitle,countyComboBox);

        comboHBox.getChildren().addAll(idPickerBox,countyPickerBox);

        //Szűrés teljesítmény alapján
        Label radioTitle = new Label("Szűrés a teljesítményre intervallumok alapján");
        radioTitle.setPadding(new Insets(10,0,5,0));
        VBox radioBox = new VBox();
        this.toggleGroup = new ToggleGroup();
        RadioButton r1 = new RadioButton("0-1000");
        RadioButton r2 = new RadioButton("1000-3000");
        RadioButton r3 = new RadioButton("3000<");
        r1.setToggleGroup(toggleGroup);
        r2.setToggleGroup(toggleGroup);
        r3.setToggleGroup(toggleGroup);
        r1.setPadding(new Insets(0,0,5,0));
        r2.setPadding(new Insets(0,0,5,0));
        radioBox.getChildren().addAll(r1,r2,r3);

        this.button = new Button();
        this.button.setOnAction(actionEvent -> collectData());

        filerBox.getChildren().addAll(mainTitle ,townVbox, comboHBox, radioTitle, radioBox, this.button);
        filerBox.setPadding(new Insets(10,10,10,20));
        filerBox.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
        filerBox.setBorder(new Border((new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, CornerRadii.EMPTY,BorderWidths.DEFAULT))));
    }

    public void collectData(){
        RadioButton rb = (RadioButton)toggleGroup.getSelectedToggle();
        seged.setText(townTextField.getText() + " - " + this.idComboBox.getValue() + " - " + this.countyComboBox.getValue() + " - " + rb.getText());
    }
}
