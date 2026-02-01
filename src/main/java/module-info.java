module org.example.restaurant_final {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.restaurant_final to javafx.fxml;
    exports org.example.restaurant_final;
}
