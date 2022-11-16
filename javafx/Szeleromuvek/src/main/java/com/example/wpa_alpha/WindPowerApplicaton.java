package com.example.wpa_alpha;

import com.example.wpa_alpha.Controllers.MainLayoutController;
import com.example.wpa_alpha.DataAccessObjects.MegyeDAO;
import com.example.wpa_alpha.DataAccessObjects.ToronyDAO;
import com.example.wpa_alpha.PersistenceModels.Megye;
import com.example.wpa_alpha.PersistenceModels.Torony;
import com.example.wpa_alpha.Views.MainLayoutView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class WindPowerApplicaton extends Application {
    @Override
    public void start(Stage stage){
        MainLayoutView mainLayoutView = new MainLayoutView();
        MainLayoutController mainLayoutController = new MainLayoutController(mainLayoutView);
        Scene scene = new Scene(mainLayoutView.getView(), 1280, 720);
        stage.setTitle("WindPowerApplication");
        stage.setScene(scene);
        stage.setMinWidth(480);
        stage.setMinHeight(720);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}