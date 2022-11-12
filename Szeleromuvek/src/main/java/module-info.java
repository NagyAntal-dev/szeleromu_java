module com.example.wpa_alpha {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wpa_alpha to javafx.fxml;
    exports com.example.wpa_alpha;
}