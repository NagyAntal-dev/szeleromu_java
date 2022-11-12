module com.example.szeleromu {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.szeleromu to javafx.fxml;
    exports com.example.szeleromu;
}