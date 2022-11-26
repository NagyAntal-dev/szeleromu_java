package com.example.wpa_alpha.Controllers;

import com.example.wpa_alpha.Modells.*;
import com.example.wpa_alpha.Modells.Stream.Database;
import com.example.wpa_alpha.RestClient.FakeRestClient;
import com.example.wpa_alpha.Views.MainLayoutView;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class MainLayoutController {
    public MainLayoutController(MainLayoutView view) {
        setView(view);
    }

    public void setView(MainLayoutView view) {
        String helyszinURL = "C:\\Users\\Habony Zoltán\\Documents\\GitHub\\szeleromu_java\\javafx\\Szeleromuvek\\src\\main\\resources\\com\\example\\wpa_alpha\\helyszin.txt";
        String megyeURL = "C:\\Users\\Habony Zoltán\\Documents\\GitHub\\szeleromu_java\\javafx\\Szeleromuvek\\src\\main\\resources\\com\\example\\wpa_alpha\\megye.txt";
        String toronyURL = "C:\\Users\\Habony Zoltán\\Documents\\GitHub\\szeleromu_java\\javafx\\Szeleromuvek\\src\\main\\resources\\com\\example\\wpa_alpha\\torony.txt";
        Database streamDatabase = new Database(helyszinURL, megyeURL, toronyURL);
        FakeRestClient fakeRestClient = new FakeRestClient();

        for (int i = 0; i < view.getMenuBar().getMenus().size(); i++) {
            int finalI = i;
            for (int j = 0; j < view.getMenuBar().getMenus().get(i).getItems().size(); j++) {
                int finalJ = j;
                view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).setOnAction(actionEvent ->
                {
                    switch (view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getId()){
                        //Adatbázis menü
                        case "db_read":
                            ArrayList<String> headerColumns = new ArrayList<>();
                            String title = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String taskDescription = "Megjeleníti az adatbázis adatait egy táblázatban. Az adatbázis legalább 3 táblájának adatait használja fel. Ha túl sok adatot tartalmaz az adatbázis, akkor elég csak egy részét megjeleníteni.";
                            headerColumns.add("Header");
                            headerColumns.add("Header1");
                            headerColumns.add("Header2");
                            headerColumns.add("Header3");
                            StaticReadModell staticReadModell = new StaticReadModell(headerColumns, title,taskDescription);
                            view.getMainFrameBP().setCenter(staticReadModell.getContainer());
                            break;

                        case "db_read2" :
                            ArrayList<String> headerColumns2 = new ArrayList<>();
                            String title2 = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String taskDescription2 = "Hasonló, mint az előző, de az oldalon először jelenjen meg egy Űrlap, aminek segítségével tud szűrni az adatbázis adataira. Az űrlapon használja a következő elemeket: szöveges beviteli mező, lenyíló lista, radio gomb, jelölőnégyzet.";
                            headerColumns2.add("Header");
                            headerColumns2.add("Header1");
                            headerColumns2.add("Header2");
                            headerColumns2.add("Header3");
                            FilteredDisplayModell filteredDisplayModell = new FilteredDisplayModell(headerColumns2, title2,taskDescription2);
                            view.getMainFrameBP().setCenter(filteredDisplayModell.getFilteredContainer());
                            break;

                        case "db_write":
                            String title3 = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String taskDescription3 = "Hasonló, mint az előző, de az oldalon először jelenjen meg egy Űrlap, aminek segítségével tud szűrni az adatbázis adataira. Az űrlapon használja a következő elemeket: szöveges beviteli mező, lenyíló lista, radio gomb, jelölőnégyzet.";
                            WriteModell writeModell = new WriteModell(title3, taskDescription3);
                            view.getMainFrameBP().setCenter(writeModell.getWriteContainer());
                            break;

                        case "db_modify":
                            break;

                        case "db_delete":
                                break;

                                //Rest1 menü

                        case "rest1_read":
                            String fakeRestReadTitle = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String fakeRestReadTaskDescription = "Készítsen egy Restful klienst az eladáson bemutatott https://gorest.co.in Rest szerverhez, amely megvalósítja a Read műveletet(GET metódus)";
                            FakeRestReadModell fakeRestReadModell = new FakeRestReadModell(fakeRestReadTitle, fakeRestReadTaskDescription);
                            view.getMainFrameBP().setCenter(fakeRestReadModell.getContainer());
                            break;

                        case "rest1_write":
                            String fakeRestWriteTitle = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String fakeRestWriteTaskDescription = "Készítsen egy Restful klienst az eladáson bemutatott https://gorest.co.in Rest szerverhez, amely megvalósítja a Write műveletet(POST metódus)";
                            FakeRestWriteModell fakeRestWriteModell = new FakeRestWriteModell(fakeRestWriteTitle, fakeRestWriteTaskDescription);
                            view.getMainFrameBP().setCenter(fakeRestWriteModell.getContainer());
                            break;

                        case "rest1_modify":
                            String fakeRestModifyTitle = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String fakeRestModifyTaskDescription = "Készítsen egy Restful klienst az eladáson bemutatott https://gorest.co.in Rest szerverhez, amely megvalósítja a Modify műveletet(PUT metódus)";
                            FakeRestModifyModell fakeRestModifyModell = new FakeRestModifyModell(fakeRestModifyTitle, fakeRestModifyTaskDescription);
                            view.getMainFrameBP().setCenter(fakeRestModifyModell.getContainer());
                            break;

                        case "rest1_delete":
                            String fakeRestDeleteTitle = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String fakeRestDeleteTaskDescription = "Készítsen egy Restful klienst az eladáson bemutatott https://gorest.co.in Rest szerverhez, amely megvalósítja a Delete műveletet(DELETE metódus)";
                            FakeRestDeleteModell fakeRestDeleteModell = new FakeRestDeleteModell(fakeRestDeleteTitle, fakeRestDeleteTaskDescription);
                            view.getMainFrameBP().setCenter(fakeRestDeleteModell.getContainer());
                            break;

                            //Rest2 menü

                        case "rest2_read":
                            break;

                        case "rest2_write":
                            break;

                        case "rest2_modify":
                            break;

                        case "rest2_delete":
                            break;

                            //SoapKliens menü

                        case "sk_download":
                            break;

                        case "sk_download2":
                            break;

                        case "sk_graph":
                            break;

                            //Adatgyűjtés menü

                        case "dc_download":
                            break;

                        case "dc_download2":
                            break;

                            //Egyéb menü

                        case "other_parallel":
                            String parallelTitle = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String parallelTaskDescription = "Mutassa be a párhuzamos programvégrehajtást egy oldalon. pl. egy gombra való kattintás után egy Label-ben 1 másodpercenként, a másik Labelbe 2 másodpercenként jelenjen meg egy változó szöveg. 10x fog végrehajtódni utánna megszűnik a párhuzamosság";
                            ParalellModell paralellModell = new ParalellModell(parallelTitle, parallelTaskDescription);
                            view.getMainFrameBP().setCenter(paralellModell.getWriteContainer());
                            break;

                        case "other_stream":
                            String streamTitle = view.getMenuBar().getMenus().get(finalI).getText() + " - " + view.getMenuBar().getMenus().get(finalI).getItems().get(finalJ).getText() + " almenü";
                            String streamTaskDescription = "Olvassa ki a válsztott adatbázis minden adatát egy Stream-be. Késztsen egy űrlapot (beviteli mezők, lenyíló lista, radio gomb, jelölő négyzet), ahol több szűrőfeltételt is beállíthat az adatokra. Jelenítse meg egy táblázatban a szűrt adatokat.";
                            StreamReadModell streamReadModell = new StreamReadModell(streamTitle,streamTaskDescription,streamDatabase);
                            view.getMainFrameBP().setCenter(streamReadModell.getFilteredContainer());
                            break;

                        default:
                            System.out.println("Nincs ilyen oldal!");
                    }

                });
            }
        }
    }
}
