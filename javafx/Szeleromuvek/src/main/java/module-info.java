module com.example.wpa_alpha {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.naming;


    opens com.example.wpa_alpha to javafx.fxml;
    exports com.example.wpa_alpha;
    exports com.example.wpa_alpha.Modells.Stream;

    opens com.example.wpa_alpha.PersistenceModels;
}