package com.example.wpa_alpha.Controllers;

import com.example.wpa_alpha.Modells.FilteredDisplayModell;
import com.example.wpa_alpha.Modells.StaticReadModell;
import com.example.wpa_alpha.Modells.WriteModell;
import com.example.wpa_alpha.Views.MainLayoutView;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import java.util.ArrayList;
import java.util.Collections;

public class MainLayoutController {
    public MainLayoutController(MainLayoutView view) {
        setView(view);
    }

    public void setView(MainLayoutView view) {
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
                            break;

                        case "rest1_write":
                            break;

                        case "rest1_modify":
                            break;

                        case "rest1_delete":
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
                            break;

                        case "other_stream":
                            break;

                        default:
                            System.out.println("Nincs ilyen oldal!");
                    }

                });
            }
        }
    }
}
