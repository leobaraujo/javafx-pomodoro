module com.example {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.controllers to javafx.fxml;
    exports com.example;
}
