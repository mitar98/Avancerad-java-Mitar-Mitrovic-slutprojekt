module org.example.todofrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens org.example.todofrontend to javafx.fxml;
    exports org.example.todofrontend;
}
